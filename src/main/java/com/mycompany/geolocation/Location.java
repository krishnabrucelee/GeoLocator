
package com.mycompany.geolocation;

/**
 *
 * @author Krishna.
 */
public class Location {

    public static void main(String args[]){
        
        GeoFactory geo = new GeoFactory();
        
        GeoLocator geoLocator = geo.getGeoLocation("http://freegeoip.net/xml/8.8.8.8");
        geoLocator.ip();
        
        
        GeoLocator geoLocator1 = geo.getGeoLocation("http://freegeoip.net/csv/4.2.2.2");
        geoLocator1.ip();
        
        
        GeoLocator geoLocator2 = geo.getGeoLocation("http://freegeoip.net/json/github.com");
        geoLocator2.ip();
    }
}
