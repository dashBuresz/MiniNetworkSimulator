package utils;

public abstract class Device {
    //TODO implement DHCP

    private String macAddr;
    private int[] ipAddr = new int[4];
    private int[] defaultGateWay = new int[4];

    public String mac() {return macAddr;}
    public int[] ip() {return ipAddr;}

    public Device() 
    {
        ipAddr[0] = 0b00000000;
        ipAddr[1] = 0b00000000;
        ipAddr[2] = 0b00000000;
        ipAddr[3] = 0b00000000;
        macAddr = MAC.generateMACAddress();
        //initially all devices get a local IP address
    }
    public static void sendPacket(int[] destination, Packet payload)
    {
        //When sending a packet we know the destination IP, the default gateway interface IP and MAC
        //The packet thats in a frame is sent to the switch (network IP) 
        //TODO implement and figure out how this  is going to work
    }
    public static void recievePacket()
    {
        //TODO implement and figure out how this  is going to work
    }
    //do we need this? or just a dhcp discover call?
    public void setIP(int[] ip)
    {
        ipAddr = ip;
    }
}
