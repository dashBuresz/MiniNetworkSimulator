package model.layer3;



public class ARPPacket extends Packet{
    public enum  ARPType{
        REQUEST, 
        REPLY
    }
    private ARPType opcode;
    private String srcMACAddr, tgtMACAddr;
    
    private  ARPPacket(int srcIP, int tgtIP, String srcMAC, String tgtMAC, ARPType opcode) {
        super(srcIP);
        srcMACAddr = srcMAC;
        tgtMACAddr = tgtMAC;
        this.opcode = opcode;
        super.setDestIP(tgtIP);
    }
    public static ARPPacket createARPRequest(int srcIP, int tgtIP, String srcMAC)
    {
        return new ARPPacket(srcIP, tgtIP, srcMAC, "FF:FF:FF:FF:FF:FF", ARPType.REQUEST);
    }
    public static ARPPacket createARPReply(int srcIP, int tgtIP, String srcMAC, String tgtMAC)
    {
        //TODO not sure if finished yet
        return new ARPPacket(srcIP, tgtIP, srcMAC, tgtMAC, ARPType.REPLY);
    }
}
