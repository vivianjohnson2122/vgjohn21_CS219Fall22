package Crypto;

public class Caesar {

    public static String E(String clear, int key){
        String cipher = "";
        final int ALPHA_LENGTH = 26; // this doesn't change

        for(int i = 0; i < clear.length(); i++){
            char clear_char = clear.charAt(i);
            int clear_char_pos = clear_char - 'a'; // getting the unicode position in the alphabet
            int cipher_char_pos = Math.floorMod(clear_char_pos + key, ALPHA_LENGTH); // getting the pos of the new char
            char cipher_char = (char) (cipher_char_pos + 'a');
            cipher += cipher_char;
        }
        return cipher;
    }

    public static String D(String cipher, int key){
        String clear = "";
        final int ALPHA_LENGTH = 26;

        for (int i = 0; i < cipher.length(); i++){
            char cipher_char = cipher.charAt(i);
            int cipher_char_pos = cipher_char - 'a';
            int clear_char_pos = Math.floorMod(cipher_char_pos - key, ALPHA_LENGTH);
            char clear_char = (char) (clear_char_pos + 'a');
            clear += clear_char;

        }
        return clear;
    }

    public static void main(String[] args){

        // comparing strings using the .equals() method
        System.out.println(E("cold", 20).equals("wifx"));
        System.out.println(D(E("cold", 20), 20).equals("cold"));
    }
}
