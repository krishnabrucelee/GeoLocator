package com.mycompany.geolocation;

import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HostConfiguration;

import org.apache.commons.httpclient.protocol.Protocol;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeoXmlImpl implements GeoLocator {

    @Override
    public String ip() {

        HttpClient client = new HttpClient();
        client.getParams().setParameter("http.useragent", "Test Client");
        client.getParams().setParameter("http.connection.timeout", new Integer(5000));

        GetMethod method = new GetMethod();

        FileOutputStream fos = null;
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            method.setURI(new URI("http://freegeoip.net", true));
            int returnCode = client.executeMethod(method);

            if (returnCode != HttpStatus.SC_OK) {
                System.err.println(
                        "Unable to fetch default page, status code: " + returnCode);
            }

            System.err.println(method.getResponseBodyAsString());

            method.setURI(new URI("http://freegeoip.net/xml/8.8.8.8", true));
            returnCode = client.executeMethod(method);

            if (returnCode != HttpStatus.SC_OK) {
                System.err.println("Unable to fetch xml file, status code: " + returnCode);
            }

            byte[] data = method.getResponseBody();
            fos = new FileOutputStream(new File("C:\\file.xml"));
            fos.write(data);

            transformer.transform(method, data);

            method.setURI(new URI("/", true));

        } catch (HttpException he) {
            System.err.println(he);
        } finally {
            // Release the connection.
            method.releaseConnection();
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
