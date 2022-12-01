package ZipCodeDB;

/*
    Hold data about one zipcode
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Watchable;
import java.util.Scanner;

public class Zipcode implements Comparable<Zipcode>, Distance, WeatherInfo{

    private String code;
    private String state; // two character code abbreviation
    private String city;
    private double lng; // can do math with longitude/latitude so it's a double
    private double lat;
    private int pop;



    public Zipcode(String code, String state, String city, double lng, double lat, int pop) {

        // saying this private variable is the variable passed in the constructor
        this.code = code;
        this.state = state;
        this.city = city;
        this.lng = lng;
        this.lat = lat;
        this.pop = pop;

    }

    public String toString() {
        return "Zipcode{" +
                "code='" + code + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", pop=" + pop +
                '}';
    }

    public String getCode() {

        return code;
    }

    // The natural ordering for a zipcode
    @Override
    public int compareTo(Zipcode zc) {
        return this.code.compareTo(zc.code); // comparing the code in the class to the code in the parameter
    }

    @Override
    public double distance(Zipcode zip) {

        return 0; // fancy great circle distance
    }

    public WeatherObservation getWeatherData() { // don't need to pass in long and lat becuase it's in the zipcode

        // http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=44&lng=-74&username=edharcourt

        URL url = null;
        Scanner s = null;

        String path = "http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=" +
                this.lat + "&lng=-" + this.lng + "&username=edharcourt";
        try {
            url = new URL(path);
            // url = new URL(path); // create a URL object for the path -url
            //url = new URL("http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=44&lng=-74&username=edharcourt"); // create a URL object for the path -url
            //url = new URL("http://10.60.15.25/~ehar/cs219/zips.txt"); // create a URL object for the path -url
            s = new Scanner(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double humidity = 0, temp = 0, speed = 0;
        String clouds = "";


        while(s.hasNextLine()){
            String line = s.nextLine();

            // check for humidity
            if(line.indexOf("humidity") > 0){
                humidity = Double.parseDouble(line.substring(line.indexOf(':' + 1, line.indexOf(','))));
            }

            // check for speed
            if(line.indexOf("windspeed") > 0){
                speed = Double.parseDouble(line.substring(line.indexOf(':' + 2, line.indexOf(',') -1)));
            }

            // check for temp
            if(line.indexOf("temperature") > 0){
                speed = Double.parseDouble(line.substring(line.indexOf(':' + 2, line.indexOf(',') -1)));
            }

            // check for clouds
            if(line.indexOf("clouds") > 0){
                clouds = line.substring((line.indexOf(':' + 2, line.indexOf(',') -1)));
            }
        }

        WeatherObservation ob = new WeatherObservation(humidity, speed, temp, clouds);
        return ob;
    }
}
