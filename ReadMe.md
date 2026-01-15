# Mini-Network-Simulator
This Project aims to model a simple network with a graphical user interface, in a realistic way. The inspiration for the creation of this software is GNS3. 
## Project State
Currently the projects background logic is under implementation, with the GUI implementation halted until this initial phase is done. 
As if now the basic structure and background logic of the project is in question concerning its current state. A complete overhaul might be needed to avoid future headaches.  
## Roadmap
1. Architectural planning and basic logic implementation
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
## TODOs
> figure these out, or ask others opinions about this.  
- should I switch from this kind of approach to intead of the the current one representing the different headers with classes?
    - so instead of IP class there would be an IP header class, the DHCP class would be split into a DHCP server class and a DHCP header class and so on. 
- how do you want to make DHCP work?
    - what does DHCP do?
    - how do DHCP interactions start?
    - how should the DHCP discover call interact with the IP class?
- how do you want IP and MAC addresses to interact?
    - should I write methods, and or implement utility classes/subclasses, for operations on addresses like comparing addresses
- How should routing protocols be implemented?
    - link state or distance vector method?