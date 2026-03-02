package model.devices;

import java.util.ArrayList;
import java.util.HashMap;

import model.layer2.Frame;
import model.layer2.Layer2Port;
import model.layer3.DeviceInterface;
import model.layer3.Packet;

public class Endpoint extends Device{
    private String name;
    //layer 2
    private DeviceInterface deviceInterface;
    public DeviceInterface getDeviceInterface(){return deviceInterface;}
    private ArrayList<Frame> frames;
    private ArrayList<Packet> packets;
    private int subnetMask;
    private int defaultGateWay;
    //DNS resolution, the endpoint first gets the destination IP address (dns query for a domain name)
    //the device checks it's ARP cache for said IP, if the IP isn't found, it sends and ARP Request, 
    //broadcasting to the entire local network: Who has [destination IP]? tell [my IP]
    //ARP Reply(Unicast): the device with the IP responds directly with its MAC address
    private Endpoint()
    {
        frames = new ArrayList<>();
        packets = new ArrayList<>();
    }
    public static Endpoint createEndpoint(String endpointName)
    {
        Endpoint endpoint = new Endpoint();
        endpoint.setName(endpointName);
        return endpoint;
    }
    private HashMap<Integer, String> arpCache;
    public void recieveFrame(Frame frame, Layer2Port port)
    {
        frames.add(frame);
    }
    public void handleFrames()
    {

    }
    public void setName(String newName){name = newName;}
}
