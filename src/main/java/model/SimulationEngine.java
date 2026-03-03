package model;

import java.util.ArrayDeque;
import java.util.ArrayList;

import model.devices.Device;
import model.layer2.Frame;

public class SimulationEngine {
    private static double time;
    private boolean terminate;
    private ArrayDeque<NetworkEvent> eventQueue;
    public SimulationEngine()
    {
        time = 0;
        terminate = true;
        eventQueue = new ArrayDeque<>();
    }
    public void start() {terminate = false;}
    public void pause() {terminate = true;}
    public double currentTime() {return time;}
    public void schedule(double time, Runnable action, Frame frame)
    {
        NetworkEvent event = new NetworkEvent();
        event.timeStamp = time;
        event.frame = frame;
        event.action = action;
        eventQueue.add(event);
    }

}
