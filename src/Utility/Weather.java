package Utility;

import java.util.Scanner;

public class Weather {

    public static void main(String [] args){

        System.out.println("They said \"Don't do it\" ");
        // used for getting input from the keyboard
        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter temperature in degrees F: ");
        double temperature = kbd.nextDouble();

        System.out.print("Enter wind velocity in MPH: ");
        double velocity = kbd.nextDouble();

        // calling method using printf()
        System.out.printf("The Windchill for %.1f degrees F at %.1f mph is %.2f\n",
                temperature, velocity, windchill(temperature, velocity));
    }

    // This method calculates the wind chill
    // Takes in the temperature (F) and the wind speed (MPH)
    public static double windchill(double temp, double windVelocity){
        double wc = 35.75 + (0.6215 * temp) + (0.4275 * temp - 35.75) * Math.pow(windVelocity, 0.16);
        return wc;
    }
}
