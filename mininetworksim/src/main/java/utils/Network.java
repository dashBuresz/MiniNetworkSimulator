package utils;

import java.util.ArrayList;

public class Network {
    private static ArrayList<Device> devices;
    private Network()
    {
        devices = new ArrayList<>();
    }
    public Network createNetwork()
    {
        Network network = new Network();
        return network;
    }
    public void addDevice(Device device)
    {
        devices.add(device);
    }
    public void removeDevice(Device device)
    {
        devices.remove(device);
    }
}
