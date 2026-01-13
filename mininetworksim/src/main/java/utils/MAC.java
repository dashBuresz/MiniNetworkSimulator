package utils;

import java.util.ArrayList;
import java.util.Random;

public class MAC{
    private static Random generator = new Random();
    public static class MAClibrary{
        public static ArrayList<MAC> usedAddresses; 
    }
    private String address;
    //example MAC 00:1A:2B:3C:4D:5E (12 digit HEX)
    //TODO implement this, the generation of a MAC address so it's always unique
    private MAC()
    {
        //TODO generate a MAC address until it is unique, we check it agains the MAClibrary "database"
        //check against all of the existing mac addresses, 
        // and if there is at least one that is the same generate a new one, do this until the address is fully unique
        boolean validaddress;
        do 
        {
            validaddress = true;
            address = generateMACAddress();
            for (MAC mac : MAClibrary.usedAddresses)
            {
                if (mac.address().equals(address)) 
                    {
                        validaddress = false;
                        break;
                    }
            }
        } while (!validaddress);
    }
    public static MAC createMAC()
    {
        //Factory pattern muhhahahahah
        MAC m = new MAC();
        MAClibrary.usedAddresses.add(m);
        return m;
    }
    private String generateMACAddress()
    {
        return 
            createHexvalue() + ":" + 
            createHexvalue() + ":" + 
            createHexvalue() + ":" + 
            createHexvalue() + ":" + 
            createHexvalue() + ":" +
            createHexvalue() + ":" 
        ;
    }
    private String createHexvalue()
    {
        int randInt = generator.nextInt(15);
        return Integer.toHexString(randInt);
    }
    public String address() {return address;}
}
