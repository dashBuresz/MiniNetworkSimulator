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

    */
    private ArrayDeque<Frame> recievedFrames;
    private ArrayDeque<Frame> assembledFrames;
    private ArrayDeque<Packet> packages;
    //need a routing table implementation
    /*
    a routing table has
    - Destination network: target ip address or subnet
    - Next Hop: ip address of the next router on the path
    - Interface: physical port to use for forwarding 
    - Metric: indicator for the desirability of a route lower = better
    */


    public void recieveFrame(Frame frame, Layer2Port port)
    {

    }
}
