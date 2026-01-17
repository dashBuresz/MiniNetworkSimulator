package utils;

import java.util.ArrayList;
import java.util.Random;

public class MAC{
    private static Random generator = new Random();
    
    public static ArrayList<String> usedAddresses; 
    
    private MAC()
    {

    }
    private static String generateMACString()
    {
        //example MAC 00:1A:2B:3C:4D:5E (12 digit HEX)
        return 
            createHexvalue() + ":" + 
            createHexvalue() + ":" + 
            createHexvalue() + ":" + 
            createHexvalue() + ":" + 
            createHexvalue() + ":" +
            createHexvalue() + ":" 
        ;
    }
    private static String createHexvalue()
    {
        int randInt = generator.nextInt(15);
        return Integer.toHexString(randInt);
    }
    public static String generateMACAddress()
    {
        boolean validaddress;
        String address;
        do 
        {
            validaddress = true;
            address = generateMACString();
            for (String s : usedAddresses)
            {
                if (s.equals(address)) 
                    {
                        validaddress = false;
                        break;
                    }
            }
        } while (!validaddress);
        return address;
    }
}
