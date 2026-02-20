package model.layer2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.devices.Device;

public class Switch extends Device{
    //reads the source MAC address, and notes the port it came from, adding the MAC-port pair to the table. 
    //reads the destination MAC address, 
    //  if the table contains it it sends it to the according port. 
    //  If not if floods all the ports except the one it came from. 
    //the intended device recieves the packet, 
    //responds and the switch learns and stores the new MAC address and port in the table. 

    private ArrayList<Layer2Port> layer2Ports;
    public ArrayList<Layer2Port> layer2Ports(){return layer2Ports;}
    private HashMap<Layer2Port, String> macAddrTable;
    private ArrayDeque<Frame> frames;

    public Switch(int numberOfPorts)
    {
        for (int i = 1; i < numberOfPorts + 1; i++) 
        {
            layer2Ports.add(new Layer2Port(i, null));
        }
        frames = new ArrayDeque<>();
    }
    public Layer2Port getPort(int portId){return layer2Ports.get(portId);}
    public void addConnection(String deviceMACAddr) 
    {
        //we look through the ports, if a port is not associated with a device, we can assign it to the new device. 
        for (Layer2Port p : this.layer2Ports())
        {
            if (macAddrTable.putIfAbsent(p, deviceMACAddr) != null) return;
        }
    }

    @Override
    public void recieveFrame(Frame frame, Layer2Port port)
    {
        //we get the frame, we have to peek inside to see what we should do 
        frames.add(frame);
        macAddrTable.putIfAbsent(port, frame.sourceMAC()); //putifabsent also gives functionality for testing
    }
    public void handleFrames()
    {
        //we can implement time ticking here later too
        //for now handling a single frame each time this method is called will do
        Frame frame = frames.pop();
        if(macAddrTable.containsValue(frame.destinationMAC()))
        {
            for (Map.Entry<Layer2Port, String> entry : macAddrTable.entrySet()) {
                Layer2Port port = entry.getKey();
                String mac = entry.getValue();
                if (mac.equals(frame.destinationMAC())) port.send(frame);
            }
        }
        else {
            //we flood all the ports except the sourceport with the frame
            //
            for (Map.Entry<Layer2Port, String> entry : macAddrTable.entrySet()) {
                Layer2Port port = entry.getKey();
                String mac = entry.getValue();
                if (!mac.equals(frame.sourceMAC()) && port.link() != null) port.send(frame);
            }
        }
    }
    public void forwardFrame(Frame frame)
    {
        //might be unneeded
    }
}
