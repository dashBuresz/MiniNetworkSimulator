package utils;

public class Packet {

    private Integer sourceIP;
    private Integer destinationIP;

    private String sourceMAC;
    private String destinationMAC;

    private Packet(){}

    public Packet(Integer sourceIP, String sourceMAC)
    {
        this.sourceIP = sourceIP;
        this.sourceMAC = sourceMAC;
    }
    public void setDestIP (int destination) {destinationIP = destination;}
    public void setDestMAC(String destination) {destinationMAC = destination;}

    public int  getSourceIP() {return sourceIP;}
    public String getSourceMAC() {return sourceMAC;}
    public int getDestIP() {return destinationIP;}
    public String getDestMAC() {return destinationMAC;}
}
