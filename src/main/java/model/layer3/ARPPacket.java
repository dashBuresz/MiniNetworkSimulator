package model.layer3;



public class ARPPacket extends Packet{
    public enum  ARPType{
        REQUEST, 
        REPLY
    }
    private ARPType opcode;
    private String srcMACAddr, tgtMACAddr;
    
    public ARPPacket(int srcIP, int tgtIP, String srcMAC, String tgtMAC, ARPType opcode) {
        super(srcIP);
        srcMACAddr = srcMAC;
        tgtMACAddr = tgtMAC;
        this.opcode = opcode;
        super.setDestIP(tgtIP);
    }

}
