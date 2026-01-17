package utils;

public class DHCP {
    public static void discover(Device device)
    {
        /*
        From 0.0.0.0 to 255.255.255.255
         */
    }
    public static void offer()
    {
        /*
        to 255.255.255.255 from DHCP server address
        - Offered IP address
        - Subnet Mask
        - Lease timeframe
        - DHCP Server address
        - MAC address of the device that requested an IP
         */
    }
    public static void request()
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
