package model.layer3;

import java.util.ArrayDeque;
import java.util.ArrayList;

import model.devices.Device;
import model.layer2.Frame;
import model.layer2.Layer2Port;

public class Router extends Device{
    //reads destination IP, looks up the best path --> routing table
    //forwards packets to the next device or segment on the chosen path
    //assigns unique local IP addresses (no thats the DHCP server responsibility)


    //TODO router responsibilities
    /*
    routing table
    path determination - routing
    - static 
    - dynamic
    NAT
    Firewall/Filtering

    the router is a layer 3 device
    router gets a frame
    examines destination mac 
    if it matches extracts packet from frame
    routes based on ip
    - if the destination is found in the routing table the packet will be forwarded on the appropriate interface
    - if there is no match, then ICMP message to the sender, and the router drops the packet
    once route is defined a new frame is assembled
    new frames destination mac now matches the host destination mac
    
    need a routing table implementation, a routing table has
    - Destination network: target ip address or subnet
    - Next Hop: ip address of the next router on the path
    - Interface: physical port to use for forwarding 
    - Metric: indicator for the desirability of a route lower = better

    Router flow to outer networks
    - recieves frame
    - checks destination mac and finds that it matches one of its interfaces mac addresses
    - strips off the frame header and analyzes the packets destination ip address
    - sees that the destination ip is on a different network so it looks up that network in the routing table and identifies the interface
    - the router assembles a new frame, that has 
        - the mac address of the next hop router interface in its destination mac field
        - the mac address of the interface it forwarded out on as the source mac address
    - the assembled frame is forwarded on the appropriate interface
    Router flow to directly connected networks
    - recieves frame 
    - checks destination mac and finds that it matches one of its interfaces mac addresses
    - strips off the frame header and analyzes the packets destination ip address
    - sees that the destination ip is on a different network so it looks up that network in the routing table and identifies the interface
    - the router assembles a new frame, that has
        - the mac address of the destination endpoint as the destination mac
        - the mac address of the interface it forwarded out on as the source mac address
    */
    
    private ArrayDeque<Packet> packets;

    /**
     * This Class represents an entry within the routing table of a router. 
     * The most important fields are the network address, the interface to reach that address and the next hop. 
     * - networkAddr: destination network
     * - netMask: subnet mask of the destination network
     * - routerInterface: the interface to be used to get to the destination network/next hop on the route
     * - directConnection: is the destination network directly connected?
     * - nextHop: ip address of the next hop on the route. 
     */
    public class Route {
        private int networkAddr, netMask, nextHop;
        private DeviceInterface routerInterface;
        private boolean directConnection;
        public Route(int netAddr, int mask, DeviceInterface routerInterface, boolean isDirect, int hop)
        {
            networkAddr = netAddr;
            netMask = mask;
            this.routerInterface = routerInterface;
            directConnection = isDirect;
            nextHop = hop;
        }
        //getters
        public int getNetworkAddr(){return networkAddr;}
        public int getSubnetMaskBinarized(){return netMask;}
        public int getNextHop() {return nextHop;}
        public DeviceInterface getInterface(){return routerInterface;}
        public boolean isDirectConntection() {return directConnection;}
        //setters
        public void setNetworkAddr(int addr) {networkAddr = addr;}
        public void setSubnetMaskBinary(int mask) {netMask = mask;}
        public void setNextHop(int hop) {nextHop = hop;}
        public void setInterface(DeviceInterface rInterface){routerInterface = rInterface;}
        public void setDirectConnection(boolean isDirect) {directConnection = isDirect;}
    }
    private ArrayList<DeviceInterface> interfaces;
    private ArrayDeque<Frame> recievedFrames;
    private ArrayList<Route> routingTable;
    private ArrayDeque<Frame> assembledFrames;

    //the router has a separate MAC and IP for each of it's network interfaces, one layer2Port/interface

    public ArrayList<DeviceInterface> interfaces(){return interfaces;}

    private Router()
    {
        routingTable = new ArrayList<>();
    }
    /**
     * Factory Method for the Router class
     * @param numberOfInterfaces the amount of interfaces our router will have
     * @return the created Router object
     */
    public static Router createRouter(int numberOfInterfaces)
    {
        Router router = new Router();
        for (int i = 0; i < numberOfInterfaces; i++)
        {
            router.interfaces().add(new DeviceInterface(router));
        }
        return router;
    }

    public void recieveFrame(Frame frame, Layer2Port port)  //this port here can be the interface port it came in on
    {
        //we add the incoming frame to the frames being handled by the router
        //if destination mac matches the interface it came in on can handle the frame otherwise we'll just drop it
        //for now we dont care about destination mac we decapsulate either way
        if (frame.destinationMAC().equals(port.owner().mac())) recievedFrames.add(frame);
    }
    private void handleFrames()
    {
        //Time ticking eventually?
        //for now one frame at a time (per call to this method)
        Frame frame = recievedFrames.pop();

        Packet packet = frame.packet();
        packets.add(packet);
        //look for the longest subnet match between interfaces ip and the destination ip
        //find the mac of the destination device or next hop
        //assemble the new frame and forward it through the appropriate interface
        Route choosenRoute = findIdealRoute(packet.getDestIP());

    }
    /**
     * Finds the Route associated with the longest subnet match,
     * @param ip the 32 bit ip address we search the longest subnet match to from the msb
     * @return the Route with the longest subnet match. 
     */
    private Route findIdealRoute(int ip)
    {
        Route idealRoute = routingTable.get(0);
        int longestMatch = 0;
        for (Route route : routingTable)
        {
            int routeMatchLength = findMatchLength(route.getNetworkAddr(), ip);
            if (longestMatch < routeMatchLength && idealRoute.getSubnetMaskBinarized() < route.getSubnetMaskBinarized()) 
            {
                longestMatch = routeMatchLength;
                idealRoute = route;
            }
        }
        return idealRoute;
    }
    /**
     * This method uses bitshifting to check the length of match between too integers or in this case 32 bit ip addresses, from the msb
     * @param ip1 first 32 bit integer to compare
     * @param ip2 second 32 bit integer to compare
     * @return the length of match from the msb
     */
    private static int findMatchLength(int ip1, int ip2)
    {
        //build a inverse 32 bit distance vector, where both ips matched the bit is 1 and if there is no match it should be 0, 
        // after the first discreptancy all oother bits will be 0
        //calculate and return the weight of said inverse distance vector
        int distanceVector = ip1^ip2;   // match = 0, different = 1
        //for readability's sake
        int inverseDistanceVector = ~distanceVector;    //all matches = 1, different = 0
        //moving mask from msb, we calculate the weight until we find the first 0
        return unsignedWeight(inverseDistanceVector);
    }
    /**
     * This method uses Kernighan's algorithm to calculate the set bits in a number, treating the number as unsigned. 
     * @param number the nember whos set bits we count
     * @return the number of 1 bits in the integer
     */
    private static int unsignedWeight(int number)
    {
        //the amount of loops equal to the set bits within the integer
        int count = 0;
        while (number != 0)
        {
            number &= (number -1);
            count++;
        }
        return count;
    }
}
