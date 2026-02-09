package model.layer3;

import java.util.ArrayDeque;
import java.util.ArrayList;

import model.devices.Device;
import model.layer2.Frame;
import model.layer2.Layer2Port;
import model.layer2.MAC;

public class Router extends Device{
    //reads destination IP, looks up the best path --> routing table
    //forwards packets to the next device or segment on the chosen path
    //assigns unique local IP addresses (no thats the DHCP server responsibility)


    //TODO implement DHCP
    //TODO router responsibilities
    /*
    routing table
    path determination - routing
    - static 
    - dynamic
    NAT
    Firewall/Filtering

    */
    /*
    the router is a layer 3 device
    router gets a frame
    examines destination mac 
    if it matches extracts packet from frame
    routes based on ip
    once route is defined a new frame is assembled
    new frames destination mac now matches the host destination mac

    
    need a routing table implementation
    
    a routing table has
    - Destination network: target ip address or subnet
    - Next Hop: ip address of the next router on the path
    - Interface: physical port to use for forwarding 
    - Metric: indicator for the desirability of a route lower = better
    */
    
    private ArrayDeque<Packet> packages;

    //layer2 
    public class Layer2RouterInterface {
        final String macAddr;
        int[] ipAddr;
        Layer2Port port;
        public Layer2RouterInterface()
        {
            macAddr = MAC.generateMACAddress();
        }
    }
    private ArrayList<Layer2RouterInterface> interfaces;
    private ArrayDeque<Frame> recievedFrames;
    private ArrayDeque<Frame> assembledFrames;

    //the router has a separate MAC and IP for each of it's network interfaces, one layer2Port/interface
    //private HashMap<Layer2Port, String> interfaces;

    private Router(){}
    
    public Router createRouter(int numberOfInterfaces)
    {
        Router router = new Router();
        for (int i = 0; i < numberOfInterfaces; i++)
        {
            interfaces.add(new Layer2RouterInterface());
        }
        return router;
    }

    public void recieveFrame(Frame frame, Layer2Port port)  //this port here can be the interface port it came in on
    {
        recievedFrames.add(frame);
    }
    private void handleFrames()
    {
        //Time ticking eventually?
        //for now one frame at a time (per call to this method)
        Frame frame = recievedFrames.pop();
        //if destination mac matches the interface it came in on we decapsulate
    }
}
