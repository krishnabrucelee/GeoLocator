/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.geolocation;


public class xml implements GeoLocator {

    @Override
    public String ip() {
        
//        
//    private static String url = "http://freegeoip.net/xml/8.8.8.8";
//
//    // Create an instance of HttpClient.
//    HttpClient client = new HttpClient();
//
//    // Create a method instance.
//    GetMethod method = new GetMethod(url);
//
//    
//        try{
//    // Execute the method.
//    int statusCode = client.executeMethod(method);
//
//        if (statusCode != HttpStatus.SC_OK) {
//            System.err.println("Method failed: " + method.getStatusLine());
//        }
//    
//    // Read the response body.
//    byte[] responseBody = method.getResponseBody();
//    
        
    private static String url = "http://freegeoip.net/";

        HttpClient client = new HttpClient();
        
    GetMethod method  = new GetMethod();
    
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
//
//      if(returnCode != HttpStatus.SC_OK) {
//        System.err.println("Unable to fetch image, status code: " + returnCode);
//      }

      
      // write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(url);
		StreamResult result = new StreamResult(new File("C:\\file.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
