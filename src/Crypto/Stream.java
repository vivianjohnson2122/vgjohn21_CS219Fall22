package Crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Stream {

    public static String E(String clear, int key, boolean encrypt){
        String cipher = "";
        final int ALPHA_LENGTH = ('~' - ' ') + 1; // this doesn't change
        final char BASE_CHAR = ' '; // The starting character of the alphabet

        SecureRandom rng = null;
        try {
            rng = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        rng.setSeed(key); // seeding the random number

        for(int i = 0; i < clear.length(); i++){
            char clear_char = clear.charAt(i);
            int clear_char_pos = clear_char - BASE_CHAR; // getting the unicode position in the alphabet starting w start char
            int shift = rng.nextInt(100);
            System.out.println(shift);
            if(!encrypt) // checking if want to encrypt/decript
                shift = -shift;
            int cipher_char_pos = Math.floorMod(clear_char_pos + shift, ALPHA_LENGTH); // getting the pos of the new char
            char cipher_char = (char) (cipher_char_pos + BASE_CHAR);
            cipher += cipher_char;
        }
        return cipher;
    }


    public static void main(String[] args){

        // comparing strings using the .equals() method
        System.out.println(E("java", 10, true));
        System.out.println(E("j\\?v", 10, false)); // have to use \\ as a \ in a string
    }
}
