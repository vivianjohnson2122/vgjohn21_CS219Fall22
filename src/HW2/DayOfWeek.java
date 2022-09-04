// given three ints representing a date, calculate the day of the week it falls on
package HW2;
import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args){
        // getting input (a date) from the user
        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter a month (in number form): ");
        int mon = kbd.nextInt();

        System.out.print("Enter a date: ");
        int d = kbd.nextInt();

        System.out.print("Enter a year: ");
        int yr = kbd.nextInt();

        // calling method
        System.out.println(dayOfWeek(mon, d, yr));
    }

    // method takes in a month, day, year and returns an int
    // representing the day of the week (0-6 sun-sat)
    public static int dayOfWeek(int month, int day, int year){
        int y = year-(14 - month)/12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14-month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;

        return d;
    }
}
