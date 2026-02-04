package model.devices;

import java.util.ArrayList;

import model.layer2.Frame;
import model.layer2.Layer2Port;
import model.layer2.MAC;
import model.layer3.Packet;

public abstract class Device {
    //Network Interface layer 2
    private String macAddr;
    private ArrayList<Layer2Port> layer2Ports;
    //layer 2 getter setter
    public ArrayList<Layer2Port> layer2Ports(){return layer2Ports;}

    //layer 3
    private int[] ipAddr = new int[4];
    private int[] defaultGateWay = new int[4];


    public String mac() {return macAddr;}
    public int[] ip() {return ipAddr;}

    public Device() 
    {
        ipAddr[0] = 0b00000000;
        ipAddr[1] = 0b00000000;
        ipAddr[2] = 0b00000000;
        ipAddr[3] = 0b00000000;
        macAddr = MAC.generateMACAddress();
        //initially all devices get a local IP address
    }
    public static void sendPacket(int[] destination, Packet payload)
    {
        //When sending a packet we know the destination IP, the default gateway interface IP and MAC
        //The packet thats in a frame is sent to the switch (network IP) 
        //TODO implement and figure out how this  is going to work
    }
    public abstract void recieveFrame(Frame frame, Layer2Port port);
    //do we need this? or just a dhcp discover call?
    public void setIP(int[] ip)
    {
        ipAddr = ip;
    }
}
