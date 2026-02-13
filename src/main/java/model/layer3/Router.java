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
    once route is defined a new frame is assembled
    new frames destination mac now matches the host destination mac
    
    need a routing table implementation, a routing table has
    - Destination network: target ip address or subnet
    - Next Hop: ip address of the next router on the path
    - Interface: physical port to use for forwarding 
    - Metric: indicator for the desirability of a route lower = better
    */
    
    private ArrayDeque<Packet> packets;

    //layer2 
    public class RouterInterface extends Device{
        //basicly the interface acts as a separate device that is closely tied with the core router. 
        //The interfaces maintain a reference to their own routers and the routers maintain a reference to their interfaces
        Layer2Port port;
        Router owner;
        public RouterInterface(Router router)
        {
            port = new Layer2Port(1, this);
            owner = router;
        }

        @Override
        public void recieveFrame(Frame frame, Layer2Port port) {
            owner.recieveFrame(frame, this.port);
        }
    }
    private ArrayList<RouterInterface> interfaces;
    private ArrayDeque<Frame> recievedFrames;
    private ArrayDeque<Frame> assembledFrames;

    //the router has a separate MAC and IP for each of it's network interfaces, one layer2Port/interface

    public ArrayList<RouterInterface> interfaces(){return interfaces;}

    private Router(){}
    /**
     * Factory Method for the Router class
     * @param numberOfInterfaces the amount of interfaces our router will have
     * @return the created Router object
     */
    public Router createRouter(int numberOfInterfaces)
    {
        Router router = new Router();
        for (int i = 0; i < numberOfInterfaces; i++)
        {
            router.interfaces().add(new RouterInterface(this));
        }
        return router;
    }

    public void recieveFrame(Frame frame, Layer2Port port)  //this port here can be the interface port it came in on
    {
        //we add the incoming frame to the frames being handled by the router
        //if destination mac matches the interface it came in on can handle the frame otherwise we'll just drop it
        //for now we dont care about destination mac we decapsulate either way
        recievedFrames.add(frame);
    }
    private void handleFrames()
    {
        //Time ticking eventually?
        //for now one frame at a time (per call to this method)
        Frame frame = recievedFrames.pop();
        Packet packet = frame.packet();
        //look for the longest subnet match between interfaces ip and the destination ip
        //find the mac of the destination device or next hop
        //assemble the new frame and forward it through the appropriate interface
        RouterInterface routerInterface = findLongestSubnetMatch(packet.getDestIP());
        //we will forward through this
        //TODO implement a way to resolve the new MAC --> run ARP
        String resolvedMAC = new String();
        Frame assembledFrame = Frame.assembleFrame(packet, frame.sourceMAC(), resolvedMAC);
        routerInterface.port.send(assembledFrame);

        packets.add(frame.packet());
    }
    /**
     * Finds the RouterInterface associated with the longest subnet match
     * @param ip the 32 bit ip address we search the longest match to from the msb
     * @return the RouterInterface with the longest matching ip from the msb
     */
    private RouterInterface findLongestSubnetMatch(int ip)
    {
        ArrayList<Integer> subnetMatchLengths = new ArrayList();
        for (RouterInterface routerInterface : interfaces)
        {
            subnetMatchLengths.add(findMatchLength(ip, routerInterface.ip()));
        }
        //find the longest match
        int greatestMatchLength = subnetMatchLengths.get(0);
        int greatestMatchIdx = -1;
        for(int i = 0; i < subnetMatchLengths.size(); i++)
        {
            if (greatestMatchLength < subnetMatchLengths.get(i)) 
            {
                greatestMatchLength = subnetMatchLengths.get(i);
                greatestMatchIdx = i;
            }
        }
        return interfaces.get(greatestMatchIdx);
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
        int weight = 0;
        for (int i = 0; i < Integer.SIZE; i++)
        {
            if (((inverseDistanceVector >> i) & 1 )== 1) weight++;
            else return weight;
        }
        //return the weight
        return weight;
    }
}
