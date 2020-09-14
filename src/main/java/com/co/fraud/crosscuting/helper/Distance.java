package com.co.fraud.crosscuting.helper;

public class Distance {

    public Distance() {
        super();
    }

    /**
     *
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference.
     * @param lat1
     * @param lon1
     * End point
     * @param lat2,
     * @param lon2 End point
     * @returns Distance in Kilometers
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = (dist * 60 * 1.1515) * 1.609344;
        return (dist);
    }

    /**
     * This function converts decimal degrees to radians
     * @param deg
     * @return double
     */
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     *  This function converts decimal degrees to radians
     * @param rad
     * @return double
     */
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
