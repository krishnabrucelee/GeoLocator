package com.mycompany.geolocation;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GeoJsonImpl implements GeoLocator {

    @Override
    public String ip() {

        try {
            // build a URL
            String s = "http://freegeoip.net/";

            s += URLEncoder.encode("json/github.com", "UTF-8");
            URL url = new URL(s);

            String str;
            try ( // read from the URL
                    Scanner scan = new Scanner(url.openStream())) {
                str = new String();
                while (scan.hasNext()) {
                    str += scan.nextLine();
                }
            }

            // build a JSON object
            JSONObject obj = new JSONObject(str);
            if (!obj.getString("status").equals("OK")) {
                return obj;
            }
            JSONObject res = obj.getJSONArray("GeoLocation").getJSONObject(0);
            System.out.println(res.getString("formatted_address"));
            JSONObject loc
                    = res.getJSONObject("geometry").getJSONObject("location");
            System.out.println("ip: " + loc.getDouble("ip")
                    + ", country_code: " + loc.getString("country_code")
                    + ", country_name: " + loc.getString("country_name")
                    + ", region_code: " + loc.getString("region_code")
                    + ", region_name: " + loc.getString("region_name")
                    + ", city: " + loc.getString("city")
                    + ", zip_code: " + loc.getDouble("zip_code")
                    + ", time_zone: " + loc.getString("time_zone")
                    + ", latitude: " + loc.getDouble("latitude")
                    + ", longitude: " + loc.getDouble("longitude")
                    + ", metro_code: " + loc.getString("metro_code"));
        } catch (Exception he) {
            System.err.println(he);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
