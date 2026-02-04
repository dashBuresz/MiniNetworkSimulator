package model.layer3;

import java.util.ArrayList;

import model.devices.Device;
import model.layer2.Frame;

public class Router extends Device{
    //reads destination IP, looks up the best path --> routing table
    //forwards packets to the next device or segment on the chosen path
    //assigns unique local IP addresses
    //TODO implement DHCP
    private ArrayList<Device> connections;
    public void recieveFrame(Frame frame)
    {

    }
}
