package model.layer3;

public class Packet {
    private int sourceIP;
    private int destinationIP;
    private Packet(){}
    protected Packet(int src){sourceIP = src;}
    public static Packet createPacket(int src){
        Packet packet = new Packet();
        packet.setSourceIP(src);
        return packet;
    }
    public void setDestIP (int destination) {destinationIP = destination;}
    public void setSourceIP(int source) {sourceIP = source;}
    public int  getSourceIP() {return sourceIP;}
    public int getDestIP() {return destinationIP;}
}
