package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Switch extends Device{
    //reads the source MAC address, and notes the port it came from, adding the MAC-port pair to the table. 
    //reads the destination MAC address, 
    //  if the table contains it it sends it to the according port. 
    //  If not if floods all the ports except the one it came from. 
    //the intended device recieves the packet, 
    //responds and the switch learns and stores the new MAC address and port in the table. 

    private Packet packet;  //for now a switch can only handle a single packet at a time
    private ArrayList<Integer> ports;
    private HashMap<MAC, Integer> table;
    public static void recievePacket()
    {

    }
    public static void forwardPacket()
    {

    }
}
