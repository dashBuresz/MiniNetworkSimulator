# Mini-Network-Simulator
This Project aims to model a simple network with a graphical user interface, in a realistic way. The inspiration for the creation of this software is GNS3. 
## Project State
Currently the projects background logic is under implementation, with the GUI implementation halted until this initial phase is done. 
As if now the basic structure and background logic of the project is in question concerning its current state. A complete overhaul might be needed to avoid future headaches.  
## Roadmap
1. [CURRENT] Architectural planning and basic logic implementation
    - create a skeleton of the project with some basic working classes to demonstrate how everything should work in a nutshell. 
2. Bare Bones GUI implementation
    - implement a basic GUI to represent the network visually. 
    - initially it doesn't need to be responsive and dynamic. 
3. Full logic and "back-end" implementation
    - Implement all the planned and unforseen logical requirements of the project. 
4. Full GUI implementation
    - Full fledged GUI, "make it look pretty" with interactive elements, for example you can not only see the devices in your network model, you cand drag and drop them around, you also have options to drag and drop devices, and the project prompts you to configure them once that is done. 
6. Unit tests maybe?
    - We'll see how feaasible this is, but if it can be done it will be. 
7. Release
    - Host the project on github, announce it on LinkedIn all that good stuff. 
## Basic implementation question TODOs
> figure these out, or ask others opinions about this.  
- [ ] How should routing protocols be implemented?
    - link state or distance vector method?
> [!WARNING]
> Needs to be implemented
- [ ] **Implement Time Ticking in Network class**
    - this will make or break the simulator

## IP stack considerations
- IP Header
    - Do I need an IP header class that contains all necessary information when sending a packet?
- ICMP
    - What way should it be implemented
- Packages
    - decided to use a Protocol class that each protocol inherits, this way we can store all active protocols in a package or exchange in a Protocol header. 
- DHCPServer
    - Implementing a way where we store offered and assigned IP addersses by the devices MAC - HashMap?
### Where are we at?
> [!NOTE]
> Currently ongoing work considerations
- **Router**
    - Currently implementing the basic router framework, the initialization of a router and then ofc 
        - [X] decapsualtion 
        - [ ] encapsulation 
        - [ ] routing, routing tables
        - [ ] time ticking with packet and frame processing
- Device
    - Refactoring
- Packet
    - Implementing the universal protocol header vision. 
        - decided to go with the ip stack approach where the ip header contains marking for the transport layer protocol traveling above it. 
### Status of relevant classes to ongoing implementation
- MAC class finished
- Frame class finished
- Layer2Link class finished
- Layer2Port class finished
- Switch class finished
- Device class WIP
- Router class WIP
    - To Implement 
        - ARP
        - Routing tables
- Data class not implemented
- Protocol class not implemented
- UDPDatagram class WIP
### Resources
- [Video explaining a simple network and packets](https://youtu.be/aFR1kKKJoic?si=QgujDzxMpA8USnmE)
- [Video explaining the same thing a little better](https://youtu.be/zhlMLRNY5-4?si=qoNrfjNCqNaoU4eM)