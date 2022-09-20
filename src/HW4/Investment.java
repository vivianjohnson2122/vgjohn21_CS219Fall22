/*
Vivian Johnson
9.20.22
Homework 4
 */
package HW4;

import java.util.Scanner;

public class Investment {

    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);

        // have the user enter a valid initial deposit
        double c = getInvestment(kbd);

        // have the user enter a valid interest rate
        double r = getInvestmentRate(kbd);

        // have the user enter a valid number of years
        double t = getNumYears(kbd);

        // have the user enter a valid number of times to compound
        int n = getTimesCompounded(kbd);

        // printing the investment given the user's inputs
        System.out.printf("Your investment is worth %.2f",
                Investment.investment(c, r, t, n));
    }

    // calculates the investment given a deposit, rate, period of time, and number of times to compound
    public static double investment(double c, double r, double t, int n) {
        return c * Math.pow(1 + r / n, t * n);
    }

    public static double getInvestment(Scanner s) {
        boolean isValid = false;
        double investment = 0;

        while (!isValid) {
            System.out.print("Enter an amount to be invested: ");

            if (s.hasNextDouble()) {
                investment = s.nextDouble();
                isValid = true;

                if (investment < 0) {
                    isValid = false;
                    System.out.println("Error: Initial deposit should be greater than 0. You entered: " + investment);
                }

            } else {
                String invalidDeposit = s.next();
                System.out.println("Error: Initial deposit should be a decimal. You entered: " + invalidDeposit);
            }
        }
        return investment;
    }

    public static double getInvestmentRate(Scanner s){
        double rate = 0;
        boolean isValid = false;

        while (!isValid){
            System.out.print("Enter an interest rate (in decimal form):");

            if (s.hasNextDouble()) {
                rate = s.nextDouble();
                isValid = true;
                if (0 > rate || rate > 1) {
                    System.out.println("Error: Rate should be a decimal between 0 and 1. You entered: " + rate);
                    isValid = false;
                }
            } else {
                String invalidRate = s.next();
                System.out.println("Error: Initial deposit should be a decimal. You entered: " + invalidRate);
            }
        }
        return rate;
    }

    public static double getNumYears(Scanner s){
        boolean isValid = false;
        double numYears = 0;

        while (!isValid){
            System.out.print("Enter a number of years: ");

            if(s.hasNextDouble()) {
                numYears = s.nextDouble();
                isValid = true;
                if (numYears < 0) {
                    isValid = false;
                    System.out.println("Error: Time should be a number of years greater than 0. You entered: " + numYears);
                }
            } else {
                String invalidTime = s.next();
                System.out.println("Error: Time should be a number of years greater than 0. You entered: " + invalidTime);
            }
        }
        return numYears;
    }

    public static int getTimesCompounded(Scanner s){
        boolean isValid = false;
        int timesCompounded = 0;

        while(!isValid){
            System.out.print("Enter a number of times compounded per year: ");

            if (s.hasNextInt()) {
                timesCompounded = s.nextInt();
                isValid = true;
                if (timesCompounded < 0) {
                    isValid = false;
                    System.out.println("Error: Times compounded should be an integer greater than 0. You entered: " + timesCompounded);
                }
            } else {
                String invalidN = s.next();
                System.out.println("Error: Times compounded should be an integer greater than 0. You entered: " + invalidN);
            }
        }
        return timesCompounded;
    }
}
