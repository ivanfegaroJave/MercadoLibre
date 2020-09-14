package com.co.fraud.crosscuting.constants;
/**
 * Class that help to declare the constants
 *
 * @author Iván García
 * @version 1.0.0
 */

public class Constants {

    public Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CROSS_ORIGIN = "*";
    public static final String IP = "ip";
    public static final String NAME = "name/{id}";
    public static final String EXCHANGE = "base";
    public static final String COUNTRY = "id";



    public static final String ERROR_SERVICE = "Error consuming rest service";
    public static final String ERROR_NAME_CURRENCY_INVALID = "No data for this currency";
    public static final String ERROR_IP = "The ip is wrong";

    public static final double LAT1 = -34;
    public static final double LON1 = -60;

    public static final int INITIAL_VALUE = 1;

    public static final String AVERAGE_MESSAGE = "The average value for all request in KM: ";
    public static final String EXCHANGE_CURRENCY = "(1 %s = U$S ";
    public static final String KM = " KM";

}
