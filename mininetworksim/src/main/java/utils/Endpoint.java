package utils;

import java.util.HashMap;

public class Endpoint extends Device{
    private String name;
    //DNS resolution, the endpoint first gets the destination IP address (dns query for a domain name)
    //the device checks it's ARP cache for said IP, if the IP isn't found, it sends and ARP Request, 
    //broadcasting to the entire local network: Who has [destination IP]? tell [my IP]
    //ARP Reply(Unicast): the device with the IP responds directly with its MAC address

    public Endpoint createEndpoint(String endpointName)
    {
        Endpoint endpoint = new Endpoint();
        endpoint.setName(endpointName);
        return endpoint;
    }
    //TODO configure IP by sending DHCP Discover
    public void dhcpDiscover()
    {
        
    }

    private HashMap<IP, MAC> arpCache;
    
    public static void sendPacket()
    {

    }
    public static void recievePacket()
    {

    }
    public void setName(String newName)
    {
        name = newName;
    }
}
