package model.layer3;

import model.devices.Device;
import model.layer2.Frame;
import model.layer2.Layer2Port;

//layer2 
public class DeviceInterface extends Device{
    //basicly the interface acts as a separate device that is closely tied with the core router. 
    //The interfaces maintain a reference to their own routers and the routers maintain a reference to their interfaces
    Layer2Port port;
    Device owner;
    public DeviceInterface(Device device)
    {
        port = new Layer2Port(1, this);
        owner = device;
    }
    public Layer2Port port(){return port;}
    @Override
    public void recieveFrame(Frame frame, Layer2Port port) {
        owner.recieveFrame(frame, this.port);
    }
}