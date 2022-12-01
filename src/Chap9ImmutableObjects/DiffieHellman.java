package Chap9ImmutableObjects;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    public static void main(String[] args) {

        // get a big prime number
        BigInteger p = new BigInteger("7919");

        // compute a private key - make a random one
        BigInteger aPrivate = new BigInteger("123456789");

        // compute alice's public key
        BigInteger aPublic = BigInteger.TWO.modPow(aPrivate, p);

        // send bob the public key

        // bob picks a private key
        BigInteger bPrivate = new BigInteger("497");

        // bob computes public key
        BigInteger bPublic = BigInteger.TWO.modPow(bPrivate, p);

        // bob sends public key to alice
        // alice can now compute shared key
        BigInteger aShared = bPublic.modPow(aPrivate, p);

        // bob can compute the shared key
        BigInteger bShared = aPublic.modPow(bPrivate, p);

        // printing out shared keys
        System.out.println(aShared);
        System.out.println(bShared);
    }
}
