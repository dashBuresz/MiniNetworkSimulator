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

    //private Frame frame;  //for now a switch can only handle a single frame at a time
    private ArrayList<Layer2Port> ports;
    private HashMap<Layer2Port, String> macAddrTable;
    //private HashMap<Integer, Device> connections;

    public Switch(int numberOfPorts)
    {
        for (int i = 1; i < numberOfPorts + 1; i++) 
        {
            ports.add(new Layer2Port(i, null));
        }
    }

    public void addConnection(Device device) 
    {
        //we look through the ports, if a port is not associated with a device, we can assign it to the new device. 
        for (Layer2Port p : ports)
        {
            if (macAddrTable.putIfAbsent(p, device.mac()) != null) return;
        }
    }
    public void removeConnection(int portnumber) {macAddrTable.remove(portnumber);}


    public void recieveFrame(Frame frame)
    {
        
    }
    public void forwardFrame(Frame frame, Device device)
    {
        //in the future we can extend this 
        device.recieveFrame(frame);
    }
}
