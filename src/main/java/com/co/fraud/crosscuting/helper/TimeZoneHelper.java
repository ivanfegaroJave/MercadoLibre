package com.co.fraud.crosscuting.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneHelper {

    public TimeZoneHelper() {
        super();
    }

    /**
     * method that calculate the hour in base of the time zone
     *
     * @Param zone
     * @returns string. hour in base for each time zone
     */
    public static String hora(String zone) {
        TimeZone tz = TimeZone.getTimeZone(zone);
        Calendar c = Calendar.getInstance(tz);
        return String.format("%02d" , c.get(Calendar.HOUR_OF_DAY))+":"+
                String.format("%02d" , c.get(Calendar.MINUTE))+":"+
               String.format("%02d" , c.get(Calendar.SECOND));
    }

    /**
     * method that calculate the date in base of the time zone
     *
     * @Param zone
     * @returns string. date in base for each time zone
     */
    public static String fecha(String zone){
        TimeZone tz = TimeZone.getTimeZone(zone);
        Calendar c = Calendar.getInstance(tz);
        return String.format("%02d" , c.get(Calendar.YEAR))+"/"+
                String.format("%02d" , c.get(Calendar.MONTH))+"/"+
                String.format("%02d" , c.get(Calendar.DATE));

    }

}
