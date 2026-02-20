package model.devices;

import java.util.HashMap;

import model.layer2.Frame;
import model.layer2.Layer2Port;
import model.layer3.DeviceInterface;

public class Endpoint extends Device{
    private String name;
    //layer 2
    private DeviceInterface deviceInterface;
    public DeviceInterface getDeviceInterface(){return deviceInterface;}
    
    private int subnetMask;
    private int defaultGateWay;
    //DNS resolution, the endpoint first gets the destination IP address (dns query for a domain name)
    //the device checks it's ARP cache for said IP, if the IP isn't found, it sends and ARP Request, 
    //broadcasting to the entire local network: Who has [destination IP]? tell [my IP]
    //ARP Reply(Unicast): the device with the IP responds directly with its MAC address
    private Endpoint(){}
    public static Endpoint createEndpoint(String endpointName)
    {
        Endpoint endpoint = new Endpoint();
        endpoint.setName(endpointName);
        return endpoint;
    }
    private HashMap<Integer, String> arpCache;
    public void recieveFrame(Frame frame, Layer2Port port)
    {
        
    }
    public void setName(String newName){name = newName;}
}
