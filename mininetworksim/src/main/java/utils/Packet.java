package utils;

public class Packet {

    private IP sourceIP;
    private IP destinationIP;

    private MAC sourceMAC;
    private MAC destinationMAC;

    private Packet(){}

    public Packet(IP sourceIP, MAC sourceMAC)
    {
        this.sourceIP = sourceIP;
        this.sourceMAC = sourceMAC;
    }
    public void setDestIP(IP destination) {destinationIP = destination;}
    public void setDestMAC(MAC destination) {destinationMAC = destination;}

    public IP getSourceIP() {return sourceIP;}
    public MAC getSourceMAC() {return sourceMAC;}
    public IP getDestIP() {return destinationIP;}
    public MAC getDestMAC() {return destinationMAC;}
}
