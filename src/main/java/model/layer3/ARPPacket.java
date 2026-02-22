package model.layer3;

public class ARPPacket extends Packet{
    private String srcMACAddr, tgtMACAddr;
    
    public ARPPacket(int srcIP, int tgtIP, String srcMAC, String tgtMAC) {
        super(srcIP);
        srcMACAddr = srcMAC;
        tgtMACAddr = tgtMAC;
        super.setDestIP(tgtIP);
    }

}
