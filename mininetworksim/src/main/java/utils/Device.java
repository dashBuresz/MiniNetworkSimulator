package utils;

public abstract class Device {
    //TODO implement DHCP

    private String macAddr;
    private int ipAddr;
    private int networkAddr;

    public String mac() {return macAddr;}
    public int ip() {return ipAddr;}

    public Device() 
    {
        macAddr = MAC.generateMACAddress();
        //initially all devices get a local IP address
    }
    public static void sendPacket(int destination)
    {
        
    }
    //do we need this? or just a dhcp discover call?
    public void setIP(int ip)
    {
        ipAddr = ip;
    }
}
