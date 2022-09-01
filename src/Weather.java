public class Weather {

    public static void main(String [] args){

        // Calling and printing the windchill function
        System.out.println(windchill(32, 10));
    }

    // This method calculates the wind chill
    // Takes in the temperature (F) and the wind speed (MPH)
    public static double windchill(double temp, double windVelocity){
        double wc = 35.75 + (0.6215 * temp) + (0.4275 * temp - 35.75) * Math.pow(windVelocity, 0.16);
        return wc;
    }
}
