package utils;

public abstract class Device {
    private MAC macAddr;
    private IP ipAddr;

    public MAC mac() {return macAddr;}
    public IP ip() {return ipAddr;}
}
