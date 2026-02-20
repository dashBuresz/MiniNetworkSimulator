package main;

import java.util.HashSet;
import java.util.List;

import model.devices.Endpoint;
import model.layer2.Layer2Link;
import model.layer2.Layer2Port;
import model.layer2.Switch;
import model.layer3.Router;

public class Main {
    public static void main(String[] args) {
        Endpoint pc1 = Endpoint.createEndpoint("PC1");
        Endpoint pc2 = Endpoint.createEndpoint("PC2");
        Switch s1 = new Switch(2);
        Switch s2 = new Switch(2);
        Router r1 = Router.createRouter(2);

        Layer2Link p1s1, s1r1, r1s2, s2p2;
        //pc1 switch1 link
        HashSet linkPorts = new HashSet<Layer2Port>();
        linkPorts.add(List.of(pc1.getDeviceInterface().port(), s1.getPort(0)));
        p1s1 = new Layer2Link(linkPorts);

        //switch1 router1 link
        linkPorts.clear();
        linkPorts.add(List.of(s1.getPort(0), r1.interfaces().get(0)));
        s1r1 = new Layer2Link(linkPorts);

        //router1 switch2 link
        linkPorts.clear();
        linkPorts.add(List.of(r1.interfaces().get(1), s2.getPort(0)));
        r1s2 = new Layer2Link(linkPorts);

        //switch2 pc2 link
        linkPorts.clear();
        linkPorts.add(List.of(s2.getPort(1), pc2.getDeviceInterface()));
        s2p2 = new Layer2Link(linkPorts);
    }
}