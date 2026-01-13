package utils;

import java.util.ArrayList;

public class Router extends Device{
    //reads destination IP, looks up the best path --> routing table
    //forwards packets to the next device or segment on the chosen path
    //assigns unique local IP addresses
    //TODO implement DHCP
    private ArrayList<Device> connections;
}
