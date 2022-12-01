package RecursionExamples;


public class Recursion {

    public static void main(String[] args) {

        // testing sum of digits
        System.out.println(sod(4192) == 16);

        // testing count 7s
        System.out.println(count7s(7132771) == 3);

        // testing pow
        System.out.println(pow(2,10) == 1024);

        // testing reverse
        System.out.println(reverse("hello").equals("olleh"));

        // testing is palindrome
        System.out.println(isPalindrome("go hang a salami im a lasagna hog"));

        // testing remove spaces
        System.out.println(removeSpaces("go hang a salami im a lasagna hog").equals("gohangasalamiimalasagnahog"));

        // testing is palindrome 2
        System.out.println(isPalindrome2("racecar"));

        // testing sum of array
        System.out.println(sum(new int []{1,2,3,4}, 0) == 10);
    }

    // sum of the digits
    // sod(1234) ==  10
    public static int sod(int n) {
        if(n == 0)
            return 0;
        else
            return sod(n / 10) + n % 10;
    }

    // count7s(7132771) == 3
    public static int count7s(int n) {
        if(n == 0)
            return 0;
        else if(n % 10 == 7)
            return count7s(n / 10) + 1; // the plus one is the count
        else
            return count7s(n / 10);
    }

    // pow(2, 10) == 1024
    public static int pow(int x, int y) {
        if(y == 0) // y keeps getting smaller, and x^0 = 1
            return 1;
        else
            return x * pow(x, y-1);
    }

    // reverse("hello").equals("olleh")
    public static String reverse(String s) {
        if(s.length() == 0)
            return "";
        else
            return reverse(s.substring(1)) + s.charAt(0);
    }

    // removeSpaces("  h   e ll    o  ").equals("hello")
    public static String removeSpaces(String s) {
        if(s.length() == 0)
            return "";
        else if(s.charAt(0) == ' ')
            return removeSpaces(s.substring(1));
        else
            return s.charAt(0) + removeSpaces(s.substring(1));
    }

    // Don't write recursively, use previous functions
    // Go hang a salami I'm a lasagna hog
    // Eva, can I see bees in a cave?
    // racecar, repaper, rotator, detartrated
    // saippuakivikauppias (Finnish for a dealer in lye)
    public static boolean isPalindrome(String s) {
        s = removeSpaces(s);
        return s.equals(reverse(s));
    }

    // write recursively not using functions we wrote. Just string
    // function CharAt
    public static boolean isPalindrome2(String s) {
        if(s.length() < 2)
            return true;
        else if((s.charAt(0) == s.charAt(s.length()-1)) &&
                (isPalindrome2(s.substring(1,s.length()-1)))) // open interval substring
            return true;
        else
            return false;

    }

    // printBinary(23) should print 010111.
    public static void printBinary(int n) {

    }

    // toBinary(23).equals("010111")
    public static String toBinary(int n) {
        return null;
    }

    // sum(new int []{1,2,3,4}) == 10
    // i is the position in the array
    public static int sum(int[] a, int i) {
        if(i == a.length)
            return 0;
        else
            return sum(a, (i + 1)) + a[i];

    }



    public static void swap(int [] aos, int i, int j) {
        int temp = aos[i];
        aos[i] = aos[j];
        aos[j] = temp;
    }

    // Arrays.equals(new int [] {1,2,3,4},
    //               new int [] {4,3,2,1})
    // i and j are left and right bounds of the array
    public static void reverse(int [] a, int i, int j) {

    }



}