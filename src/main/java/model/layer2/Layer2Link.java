package model.layer2;

import java.util.HashSet;

public class Layer2Link {
    HashSet<Layer2Port> ports;
    //TODO elaborate this in the future
    final double delay = 0.5;       //for initial concept 
    public Layer2Link(HashSet<Layer2Port> endpoints) {
        if (endpoints.size() == 2) ports = endpoints;
    }
    public void transferData(Layer2Port source, Frame frame)
    {
        for (Layer2Port port : ports)
        {
            if (!port.equals(source))
            {
                port.recieve(frame);
                break;
            }
        }
    }
}
