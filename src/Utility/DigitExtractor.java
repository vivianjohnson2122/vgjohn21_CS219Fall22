package Utility;

public class DigitExtractor {

    public static int last(int n){
        if(n < 0){
            n = -n;
        }
        return n % 10;
    }

    public static int secondToLast(int num){
        if(num < 0){
            num = -num;
        }
        num = num % 100;
        num = num / 10;
        return num;
    }

    public static void main(String[] args){
        System.out.println(last(2753) == 3);
        System.out.println(last(-749) == 9);

        System.out.println(secondToLast(1234) == 3);
        System.out.println(secondToLast(-4321) == 2);
    }
}
