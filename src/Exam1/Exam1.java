package Exam1;

import java.util.Scanner;

public class Exam1 {

    public static void main(String[] args){
        System.out.printf("There are %d numbers between 2 and 7 in your number.", getDigits());
    }

    // gets the number of digits between 2 and 7 in a given number
    public static int getDigits(){

        // getting the input from the user
        Scanner kbd = new Scanner(System.in);
        int n = getValidN(kbd);

        // getting the digits
        int count = 0;
        while(n > 0){
            int x = n % 10;
            if(x > 2 && x < 7){
                count ++;
            }
            n /= 10;
        }
        return count;
    }

    // makes sure the number given by the user is valid
    public static int getValidN(Scanner s){
        boolean isValid = false;
        int num = 0;

        while(!isValid){
            System.out.print("Please enter a positive integer: ");

            if(s.hasNextInt()){
                num = s.nextInt();
                isValid = true;

                if (num < 0) {
                    isValid = false;
                    System.out.println("Error: Please enter a positive integer. You entered: " + num);
                }

            } else {
                String invalidNum = s.next();
                System.out.println("Error: Should enter a positive NUMBER. You entered: " + invalidNum);
            }
        }
        return num;
    }
}
