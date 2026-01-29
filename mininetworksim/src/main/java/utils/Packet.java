package utils;

public class Packet {

    private int[] sourceIP;
    private int[] destinationIP;
    private Protocol header;
    private String sourceMAC;
    private String destinationMAC;

    //TODO implement a way to send universal packets, with universal payloads, meaning the format of a payload might change from packet to packet
    
    //TODO ICMP needs to be implemented
    

    private Packet(){}

    public Packet(int[] sourceIP, String sourceMAC)
    {
        this.sourceIP = sourceIP;
        this.sourceMAC = sourceMAC;
    }
    public void setDestIP (int[] destination) {destinationIP = destination;}
    public void setDestMAC(String destination) {destinationMAC = destination;}

    public int[]  getSourceIP() {return sourceIP;}
    public String getSourceMAC() {return sourceMAC;}
    public int[] getDestIP() {return destinationIP;}
    public String getDestMAC() {return destinationMAC;}
}
