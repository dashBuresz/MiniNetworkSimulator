package utils;

public abstract class Device {
    //TODO implement DHCP

    private String macAddr;
    private int[] ipAddr;

    public String mac() {return macAddr;}
    public int[] ip() {return ipAddr;}

    public Device() 
    {
        ipAddr = new int[4];
        ipAddr[0] = 0b00000000;
        ipAddr[1] = 0b00000000;
        ipAddr[2] = 0b00000000;
        ipAddr[3] = 0b00000000;
        macAddr = MAC.generateMACAddress();
        //initially all devices get a local IP address
    }
    public static void sendPacket(int[] destination, Packet payload)
    {
        //TODO implement and figure out how this  is going to work
    }
    public static void recievePacket()
    {

    }
    //do we need this? or just a dhcp discover call?
    public void setIP(int[] ip)
    {
        ipAddr = ip;
    }
}
