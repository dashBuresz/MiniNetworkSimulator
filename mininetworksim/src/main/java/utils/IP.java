package utils;

import java.util.Random;

public class IP {
    //24 bit address
    //TODO might need to implement a utility class for binary and decimal IP, in order for the subnet mask to work correctly. 
    //should have a subnet mask
    //built in methods to create broadcast addresses and loopback interfaces
    //all addresses should be unique within a network
    //for now let's only do local networks, but the option for non-local addresses should be left in. (enum?)
    private static final Random generator = new Random();
    private enum IPType{
        LOCAL, PUBLIC
    }
    private String address;
    private String subnetMask;
    private IPType type;
    private IP()
    {
        createIPString();
        subnetMask = "0.0.0.0";
    }
    public static IP createLocalIP()
    {
        IP ip = new IP();
        ip.setType(IPType.LOCAL);
        ip.setSubnetMask("255.255.255.0");
        return ip;
    }
    public static IP broadcast()
    {
        IP ip = new IP();
        ip.setType(IPType.LOCAL);
        ip.setSubnetMask("255.255.255.0");
        return ip;
    }
    public boolean isLoopBackInterface()
    {
        //TODO
        return false;
    }
    public boolean isBroadcastAddress()
    {
        //TODO
        return false;
    }
    private String createIPString()
    {
        return 
        createOctet() + "." 
        + createOctet() + "." 
        + createOctet() + "." 
        + createOctet();
    }
    private int createOctet()
    {
        return generator.nextInt(256);
    }
    public void setSubnetMask(String newSubnetmask) {subnetMask = newSubnetmask;}
    public void setType(IPType ipType)
    {
        type = ipType;
    }
    public void setAddress(String newAddress)
    {
        address = newAddress;
    }
}
