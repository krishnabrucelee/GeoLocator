
package com.mycompany.geolocation;

import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.protocol.Protocol;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeoLocatorImpl implements GeoLocator {

    @Override
    public String ip() {

    private static String url = "http://freegeoip.net/";

    // Create an instance of HttpClient.
    HttpClient client = new HttpClient();

    // Create a method instance.
    GetMethod method = new GetMethod(url);

    
        try{
    // Execute the method.
    int statusCode = client.executeMethod(method);

        if (statusCode != HttpStatus.SC_OK) {
            System.err.println("Method failed: " + method.getStatusLine());
        }
    
    // Read the response body.
    byte[] responseBody = method.getResponseBody();
    
    if(responseBody == ) {
        
        GeoLocatorXMLImpl instance = new GeoLocatorXMLImpl();
        String method = GeoLocatorXMLImpl.();
        instance.ip();
    }
}
}
