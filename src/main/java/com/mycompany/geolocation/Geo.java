/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.geolocation;

/**
 *
 * @author sony
 */
public class Geo {
    
    public GeoLocator getGeoLocation(String ipType){
        if(ipType == null){
            return null;
        }
        if(ipType.matches("http://freegeoip.net/xml/8.8.8.8")){
            return new xml();
        }
        if(ipType.equalsIgnoreCase("http://freegeoip.net/csv/4.2.2.2")){
            return new csv();
        }
        if(ipType.equalsIgnoreCase("http://freegeoip.net/json/github.com")){
            return new json();
        }
        return null;
    }
}
