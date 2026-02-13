package model.devices;

import model.layer2.Frame;
import model.layer2.Layer2Port;
import model.layer2.MAC;
/**
 * This class represents a common parent class for all devices in the simulator. 
 * 
 * Layer2: 
 * - Each device has it's own unique MAC
 * - Each device must have it's own layer2 implementation, since that can differ from device to device.
 * - Each device must implement the recieveFrame(Frame, Layer2Port) methdd to have a unified way of recieving frames through the network. 
 * 
 * Layer3: 
 * - Each device has it's own ip address
 */
public abstract class Device {
    //Network Interface layer 2
    private final String macAddr;
    //layer 2 getter setter
    

    //layer 3
    private int ipAddr;
    private int defaultGateWay;


    public String mac() {return macAddr;}
    public int ip() {return ipAddr;}

    public Device() 
    {
        ipAddr = 0;
        macAddr = MAC.generateMACAddress();
        //initially all devices get a local IP address
    }
    /**
     * This method models a device recieving a frame
     * @param frame the incoming frame
     * @param port the layer2 port the frame comes in on. 
     */
    public abstract void recieveFrame(Frame frame, Layer2Port port);
    //do we need this? or just a dhcp discover call?
    public void setIP(int ip)
    {
        ipAddr = ip;
    }
}
