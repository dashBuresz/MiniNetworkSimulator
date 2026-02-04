package model.layer4;

import model.Data;

public class UDPDatagram extends Data{
    int sourcePort, destingationPort;
    int checksum, length;
    Data data;
}
