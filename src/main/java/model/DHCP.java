package model;

import model.devices.Device;

public class DHCP extends Protocol{
    



    public static void discover(Device device)
    {
        /*
        From 0.0.0.0 to 255.255.255.255
         */
        int destination = ~0;
        //Packet message = new Packet(device.ip(), device.mac());
        //TODO what should be the message sent?
        
        //device.sendPacket(destination, message);
    }
    public static void offer(Device dhcpServer)
    {
        /*
        to 255.255.255.255 from DHCP server address
        - Offered IP address
        - Subnet Mask
        - Lease timeframe
        - DHCP Server address
        - MAC address of the device that requested an IP
         */
        int[] destination = new int[4];
        destination[0] = 0b11111111;
        destination[1] = 0b11111111;
        destination[2] = 0b11111111;
        destination[3] = 0b11111111;
        //TODO this is where we find a suitable IP address and we offer it to the device that requested the IP
        /*
        message has 
        - offered IP
        - lease timeframe
        - DHCP server address
        - MAC address of the device that requested the IP
        */
        //Packet message = new Packet(dhcpServer.ip(), dhcpServer.mac());
        //dhcpServer.sendPacket(destination, message);
    }
    public static void request(Device device)
    {
        /*
        The Endpoint requests one of the offers to be assigned to them
        - Transaction ID (which DHCP server gave the offer)
        - from 0.0.0.0 to 255.255.255.255 or to the DHCP server address
        message contents
        - Requested IP
        - DHCP Server address
        */
        
    }
    public static void acknowledge()
    {
        /*
        From DHCP server address to broadcast
        Message contents
        - the distributed IP
        - subnet mask
        - lease timeframe
        */
    }
}
