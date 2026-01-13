package utils;

import java.util.HashMap;

public class DNS {
    //we're  going to make a DNS implementation, 
    // all devices will have access to all IP addresses associated with every device in the network, 
    // this will be done by the DNS class having a Hashmap of IP, Device pairs. 
    private static HashMap<Device, IP> localCache;

    public static IP resolveIP(Device device) {return localCache.get(device);}
    public void addDevice(Device device)
    {
        localCache.put(device, device.ip());
    }
    public void removeDevice(Device device)
    {
        localCache.remove(device);
    }
}
