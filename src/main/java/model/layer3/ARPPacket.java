package model.layer3;

public class ARPPacket extends Packet{
    private String srcMACAddr, tgtMACAddr;
    private int srcIPAddr, tgtIPAddr;
    public ARPPacket(int srcIP, int tgtIP, String srcMAC, String tgtMAC) {
        super(srcIP);
        srcMACAddr = srcMAC;
        tgtMACAddr = tgtMAC;
        tgtIPAddr = tgtIP;
        super.setDestIP(tgtIPAddr);
    }

}
