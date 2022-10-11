package HW6;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SwallowStats {

    public static void main(String[] args){
        swallow_stats();
    }

    // calc and print average
    // calc and print max and minimum values
    public static void swallow_stats(){

        // Connect to the web page of speeds
        URL url = null; // null is the "nothing value"
        Scanner s = null;
        String path = "http://10.60.15.25/~ehar/cs219/swallow-speeds.txt";

        try {
            url = new URL(path); // create a URL object for the path
            s = new Scanner(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double sum = 0.0;
        int count = 0;
        double max = 0.0;
        double min = Double.POSITIVE_INFINITY;

        while(s.hasNextLine()){ // read each line of the web file

            String line  = s.nextLine(); // read a line of the website

            // going through and adding the current valid line to the sum and count
            if(line.indexOf("#") == -1 && line.length() > 0){
                sum = sum + Double.parseDouble(line);
                count ++;
                if(Double.parseDouble(line) >= max)
                    max = Double.parseDouble(line);
                if(Double.parseDouble(line) <= min)
                    min = Double.parseDouble(line);
            }

        }
        System.out.println("The average swallow speed is: " + sum / count);
        System.out.println("The fastest speed is: " + max);
        System.out.println("The slowest speed is: " + min);
    }
}

