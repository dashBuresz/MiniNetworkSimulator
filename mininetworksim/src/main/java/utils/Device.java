package utils;

public abstract class Device {
    //TODO implement DHCP
    private MAC macAddr;
    private IP ipAddr;

    public MAC mac() {return macAddr;}
    public IP ip() {return ipAddr;}

    public Device() 
    {
        macAddr = MAC.createMAC();
        //initially all devices get a local IP address
    }
    
    //do we need this? or just a dhcp discover call?
    public void setIP(IP ip)
    {
        ipAddr = ip;
    }
}
