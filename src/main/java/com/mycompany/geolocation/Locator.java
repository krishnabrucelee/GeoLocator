

package com.mycompany.geolocation;

import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HostConfiguration;

import org.apache.commons.httpclient.protocol.Protocol;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class Locator {

//  public static void main(String args[]) {

    HttpClient client = new HttpClient();
    client.getParams().setParameter("http.useragent", "Test Client");
    client.getParams().setParameter("http.connection.timeout",new Integer(5000));

    GetMethod method  = new GetMethod();
    FileOutputStream fos = null;

    try {

      method.setURI(new URI("http://freegeoip.net/", true));
      int returnCode = client.executeMethod(method);

      if(returnCode != HttpStatus.SC_OK) {
        System.err.println(
          "Unable to fetch default page, status code: " + returnCode);
      }

      System.err.println(method.getResponseBodyAsString());

      method.setURI(new URI("http://freegeoip.net/xml/8.8.8.8", true));
      returnCode = client.executeMethod(method);

      if(returnCode != HttpStatus.SC_OK) {
        System.err.println("Unable to fetch image, status code: " + returnCode);
      }

      byte[] imageData = method.getResponseBody();
      fos = new FileOutputStream(new File("Response.xml"));
      fos.write(imageData);

      HostConfiguration hostConfig = new HostConfiguration();
      hostConfig.setHost("www.yahoo.com", null, 80, Protocol.getProtocol("http"));

      method.setURI(new URI("/", true));

      client.executeMethod(hostConfig, method);

      System.err.println(method.getResponseBodyAsString());

    } catch (HttpException he) {
      System.err.println(he);
    } catch (IOException ie) {
      System.err.println(ie);
    } finally {
      method.releaseConnection();
      if(fos != null) try { fos.close(); } catch (Exception fe) {}
    }

  }

