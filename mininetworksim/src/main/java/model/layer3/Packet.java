package model.layer3;

import model.Data;

public class Packet {

    /*
    for the header we would have
    version
    IHL
    ToS
    Total length
    Ident, flags, fragment offset
    TTL
    Protocol
    Header checksum
    source ip
    destination ip
     */
    private int[] sourceIP;
    private int[] destinationIP;
    private Data data; 
    

    //TODO implement a way to send universal packets, with universal payloads, meaning the format of a payload might change from packet to packet
    
    //TODO ICMP needs to be implemented
    

    //private Packet(){}

    public Packet(int[] sourceIP)
    {
        this.sourceIP = sourceIP;
    }
    public void setDestIP (int[] destination) {destinationIP = destination;}
    
    public int[]  getSourceIP() {return sourceIP;}
    public int[] getDestIP() {return destinationIP;}
}
