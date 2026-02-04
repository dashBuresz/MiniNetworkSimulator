package model;

import java.util.ArrayList;

import model.devices.Device;

public class Network {
    //TODO you need to implement time ticking FAHHHH
    private int address;
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
    public void connectDevice(Device device)
    {
        devices.add(device);
        DHCP.discover(device);
    }
    public void disconnectDevice(Device device)
    {
        devices.remove(device);
    }
}
