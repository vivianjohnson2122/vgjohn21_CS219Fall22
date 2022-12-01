package Binary;

public class Binary {

    public static void main(String[] args) {
        printBinary(43); // 101011
        System.out.println();
        System.out.println(toBinary(43));
        System.out.println(parseInt("101011") == 43);
        System.out.println(Integer.parseInt("101011", 2));
        System.out.println(Integer.toBinaryString(43));
        System.out.println(0b1111); // binary constant
    }

    // takes int n and prints binary representation
    public static void printBinary(int n){

        if (n == 0)
            System.out.print(0); // leading 0 doesn't matter
        else
            printBinary(n / 2);
        System.out.print(n % 2);
    }

    // build up a string to return in binary
    public static String toBinary(int n){

        String r = "";
        while(n > 0){
            r = (n % 2) + r; // having n first adds n before adding r
            n /= 2;
        }
        return r;
    }

    public static int parseInt(String bits){

        int currPow2 = 1;
        int result = 0;

        for(int i = bits.length() - 1; i >= 0; i--){
            if(bits.charAt(i) == '1'){
                result += currPow2;
            }
            currPow2 *= 2;
        }

        return result;
    }

}
