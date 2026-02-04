package model.layer2;

import model.devices.Device;

/**
 * This class represents a layer 2 port in a network device, representing the connection points in the data-link and physical layers. 
 */
public class Layer2Port {
    private int id;
    private Device owner;
    private Layer2Link link;
    public Layer2Port(int portid, Device host)
    {
        id = portid;
        owner = host;
        link = null;
    }
    public void send(Frame frame)
    {
        if(link != null) link.transferData(this, frame);
        //else we might be able to give feedback to the NIC that this port has no connection. 
        //TODO
    }
    public void recieve(Frame frame)
    {
        owner.recieveFrame(frame, this);
    }
    //getter setter
    public int id() {return id;}
    public Device owner() {return owner;}
    public Layer2Link link() {return link;}
    public void setLink(Layer2Link l) {link = l;}
}
