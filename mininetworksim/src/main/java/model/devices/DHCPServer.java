package model.devices;

import model.layer2.Frame;
import model.layer2.Layer2Port;

public class DHCPServer extends Device{
    //implement enum for dynamic, automatic and manual IP assignment
    //this class implements a DHCP server. 
    //a dhcp server listens for DHCP messages, and responds accordingly
    //- what does a DHCP server need to know about?
    //- start and end of dynamic IP range
    private int[] serverAddress, startAddress, endAddress, networkAddress, subnetMask;
    private int defLeaseTime;

    private DHCPServer creatServer(int[] serverAddress)
    {
        DHCPServer server = new DHCPServer(); 
        server.setServerAddress(serverAddress); 
        return server;
    }
    public void configureServer(int[] networkAddress, int[] subnetMask)
    {
        //set the server up with basic parameters
        
    }
    public void setServerAddress(int[] serverAddress)
    {
        //maybe check that serverAddress is a valid IP address (4 octets)
        this.serverAddress = serverAddress;
    }
    public void recieveFrame(Frame frame, Layer2Port port)
    {
        
    }
}
