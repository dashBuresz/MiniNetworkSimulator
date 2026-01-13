package utils;

public class IP {
    //24 bit address
    //should have a subnet mask
    //built in methods to create broadcast addresses and loopback interfaces
    //all addresses should be unique within a network
    //for now let's only do local networks, but the option for non-local addresses should be left in. (enum?)
    private enum IPType{
        LOCAL, PUBLIC
    }
    private String address;
    private String subnetMask;
    private IPType type;
    public IP()
    {
        
    }
    public boolean isLoopBackInterface()
    {
        //TODO
    }
    public boolean isBroadcastAddress()
    {
        //TODO
    }
}
