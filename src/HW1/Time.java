// Generating the number of seconds left in the day and that have elapsed
// Calculating the percent of the day that has passed
package HW1;

public class Time {
    public static void main(String [] args){
        // variables that set the current time (24 hr clock)
        int hour = 15;
        int minute = 23;
        int second = 20;
        final int SEC_IN_AN_HOUR = 3600;
        final int SEC_IN_A_MIN = 60;
        final int SEC_IN_A_DAY = 86400;

        // calculating the number of seconds since midnight
        int numSeconds  = (hour * SEC_IN_AN_HOUR) + (minute * SEC_IN_A_MIN) + second;
        System.out.println("Homework 1");
        System.out.print(hour + ":" + minute + ":" + second + " is ");
        System.out.println(numSeconds + " seconds since midnight");

        // calculating the number of seconds remaining in the day
        int secondsRemaining = SEC_IN_A_DAY - numSeconds;
        System.out.println("There are " + secondsRemaining + " seconds remaining");

        // calculating the percent of the day that has passed and rounding it
        double percentOfDayPassed = ((double) numSeconds / SEC_IN_A_DAY) * 100;
        long roundedPercent = Math.round(percentOfDayPassed);
        System.out.println(roundedPercent + "% of the day has elapsed");
    }
}
