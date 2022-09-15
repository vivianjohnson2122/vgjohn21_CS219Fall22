/*
Vivian Johnson
9.15.22
Homework 3
 */
package HW3;

import java.util.Scanner;

public class Investment {

    // calculates the investment given a deposit, rate, period of time, and number of times to compound
    public static double investment(double c, double r, double t, int n) {
        return c * Math.pow(1 + r / n, t * n);
    }

    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);

        // have the user enter a valid initial deposit
        double c;
        System.out.print("Enter an amount to be invested: ");
        if (kbd.hasNextDouble()) {
            c = kbd.nextDouble();
            if (c < 0) {
                System.out.println("Error: Initial deposit should be greater than 0. You entered: " + c);
                return;
            }
        } else {
            String invalidDeposit = kbd.next();
            System.out.println("Error: Initial deposit should be a decimal. You entered: " + invalidDeposit);
            return;
        }

        // have the user enter a valid interest rate
        double r;
        System.out.print("Enter an interest rate (in decimal form):");
        if (kbd.hasNextDouble()) {
            r = kbd.nextDouble();
            if (0 > r || r > 1) {
                System.out.println("Error: Rate should be a decimal between 0 and 1. You entered: " + r);
                return;
            }
        } else {
            String invalidRate = kbd.next();
            System.out.println("Error: Initial deposit should be a decimal. You entered: " + invalidRate);
            return;
        }

        // have the user enter a valid number of years
        double t;
        System.out.print("Enter a number of years: ");
        if (kbd.hasNextDouble()) {
            t = kbd.nextDouble();
            if (t < 0) {
                System.out.println("Error: Time should be a number of years greater than 0. You entered: " + t);
                return;
            }
        } else {
            String invalidTime = kbd.next();
            System.out.println("Error: Time should be a number of years greater than 0. You entered: " + invalidTime);
            return;
        }

        // have the user enter a valid number of times to compound
        int n;
        System.out.print("Enter a number of times compounded per year: ");
        if (kbd.hasNextInt()) {
            n = kbd.nextInt();
            if (n < 0) {
                System.out.println("Error: Times compounded should be an integer greater than 0. You entered: " + n);
                return;
            }
        } else {
            String invalidN = kbd.next();
            System.out.println("Error: Times compounded should be an integer greater than 0. You entered: " + invalidN);
            return;
        }

        // printing the investment given the user's inputs
        System.out.printf("Your investment is worth %.2f",
                Investment.investment(c, r, t, n));
    }
}