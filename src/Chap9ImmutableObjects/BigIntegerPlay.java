package Chap9ImmutableObjects;


import java.math.BigInteger;

public class BigIntegerPlay {

    public static void main(String[] args) {

        System.out.println(fact(5) == 120);
        System.out.println(bigFact(2000));

        /*
        // print the first 15 factorial
        for(int i = 1; i < 30; i++){
            System.out.printf("%d : %d\n", i, fact(i));
        }

        // BigInteger
        BigInteger x = new BigInteger("1234567890987654321234567890");
        System.out.println(x.multiply(x).pow(20000));

         */
    }
    public static int fact(int n){
        int prod = 1;
        for(int i = 1; i <= n; i++){
            prod *= i;
        }
        return prod;
    }

    public static BigInteger bigFact(int n){

        BigInteger prod = BigInteger.ONE;
        for(int i = 1; i <= n; i++){
            prod = prod.multiply(BigInteger.valueOf(i));
            // prod = prod.multiply(new BigInteger(Integer.toString(i)));
        }
        return prod;
    }

    // rewrite using biginteger
    public static int power(int x, int y){
        int prod = 1;
        for(int i = 0; i < y; i++){
            prod *= x;
        }
        return prod;
    }

}
