**Mini-Network-Simulator**
This Project aims to model a simple network with a graphical user interface, in a realistic way. The inspiration for the creation of this software is GNS3. Currently the projects background logic is under implementation, with the GUI implementation halted until this initial phase is done. 
TODO
figure these out 
- how do you want to make DHCP work?
    - what does DHCP do?
    - how do DHCP interactions start?
    - how should the DHCP discover call interact with the IP class?
- how do you want IP and MAC addresses to interact?
    - should I write methods, and or implement utility classes/subclasses, for operations on addresses like comparing addresses
- How should routing protocols be implemented?
    - link state or distance vector method?