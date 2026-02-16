package model.layer3;

import model.Data;
import model.Protocol;

public class IPPacket extends Packet {

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
    private Protocol protocol; //the ip header has a field dedicated to mark the protocol traveling above it in the transport layer. 
    private Data data; 
    

    //TODO implement a way to send universal packets, with universal payloads, meaning the format of a payload might change from packet to packet
    
    //TODO ICMP needs to be implemented
    

    //private Packet(){}

    public IPPacket(int sourceIP)
    {
        super(sourceIP);
    }
    
}
