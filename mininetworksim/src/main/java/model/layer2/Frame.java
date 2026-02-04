package model.layer2;

import model.layer3.Packet;

public class Frame {
    private Packet packet;
    private String sourceMAC;
    private String destinationMAC;
    private Frame()
    {

    }
    public Frame assembleFrame(Packet packet, String destinationMAC, String sourceMAC)
    {
        Frame frame = new Frame();
        frame.setPacket(packet);
        frame.setDestinationMAC(destinationMAC);
        frame.setSourceMAC(sourceMAC);
        return frame;
    }
    public void setPacket(Packet p){packet = p;}
    public void setSourceMAC(String s){sourceMAC = s;}
    public void setDestinationMAC(String d) {destinationMAC = d;}
    public Packet packet() {return packet;}
    public String sourceMAC() {return sourceMAC;}
    public String destinationMAC() {return destinationMAC;}
}
