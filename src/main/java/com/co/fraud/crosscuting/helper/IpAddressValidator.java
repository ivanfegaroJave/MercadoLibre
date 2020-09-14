package com.co.fraud.crosscuting.helper;

import java.util.regex.Pattern;
/**
 * Class to help to validate the structure to the IP address
 *
 * @author Iván García
 * @version 1.0.0
 */
public class IpAddressValidator {


    private static final String zeroTo255
            = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

    private static final String IP_REGEXP
            = zeroTo255 + "\\." + zeroTo255 + "\\."
            + zeroTo255 + "\\." + zeroTo255;

    private static final Pattern IP_PATTERN
            = Pattern.compile(IP_REGEXP);

    public IpAddressValidator() {
        super();
    }

    /**
     * This method valid if the ip adres is valid
     *
     * @param address to validate, this value for the ip Address
     * @return boolean related from the ip address.
     */
    public static boolean isValid(String address) {
        return IP_PATTERN.matcher(address).matches();
    }

}
