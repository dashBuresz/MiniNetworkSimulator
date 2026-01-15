package utils;

public class DHCP {
    public static void discover(Device device)
    {
        device.sendPacket(IP.broadcast);
    }
}
