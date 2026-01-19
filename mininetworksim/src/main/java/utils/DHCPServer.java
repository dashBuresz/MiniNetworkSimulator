package utils;

public class DHCPServer {
    //implement enum for dynamic, automatic and manual IP assignment
    //this class implements a DHCP server. 
    //a dhcp server listens for DHCP messages, and responds accordingly
    //- what does a DHCP server need to know about?
    //- start and end of dynamic IP range
    private Integer[] startAddress, endAddress, networkAddress, subnetMask;
    private int defLeaseTime;

    public void configureServer(int networkAddress, int subnetMask)
    {
        //set the server up with basic parameters
    }
}
