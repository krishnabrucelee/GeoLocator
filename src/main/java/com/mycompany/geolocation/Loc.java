package com.mycompany.geolocation;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 *
 * @author intern
 */
public class Loc {

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
        String method = GeoLocatorXMLImpl.ip();
        instance.ip();
    }
    
    

//    TransformerFactory transformerFactory = TransformerFactory.newInstance();
//    Transformer transformer = transformerFactory.newTransformer();
//    DOMSource source = new DOMSource(method);
//    StreamResult result = new StreamResult(new File("C:\\file.xml"));
//
//        // Output to console for testing
//    // StreamResult result = new StreamResult(System.out);
//    transformer.transform (source, result);
}
}
