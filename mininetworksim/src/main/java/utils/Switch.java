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
    private HashMap<Integer, Device> connections;

    public Switch(int portnumber)
    {
        for (int i = 1; i < portnumber + 1; i++) ports.add(i);
    }

    public void addConnection(Device device) 
    {
        //we look through the ports, if a port is not associated with a device, we can assign it to the new device. 
        for (Integer p : ports)
        {
            if (!connections.containsKey(p))
            {
                connections.put(p, device);
                return;
            }
        }
        //System.err.println("No ports available! ");
    }
    public void removeConnection(int port) {connections.remove(port);}


    public static void recievePacket()
    {

    }
    public static void forwardPacket()
    {

    }
}
