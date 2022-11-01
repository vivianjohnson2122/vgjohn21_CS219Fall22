package Exam2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Exam {

    public static void main(String[] args) {
        String[] words = loadWords("http://10.60.15.25/~ehar/cs219/wordle-nyt-solutions.txt", 2309);
        System.out.println(Arrays.toString(reverse(words)));
    }

    // checks to see if the word is a palindrome
    public static boolean isPalindrome(String s) {
        if(s.length() < 2)
            return true;
        else if((s.charAt(0) == s.charAt(s.length()-1)) &&
                (isPalindrome(s.substring(1,s.length()-1)))) // open interval substring
            return true;
        else
            return false;

    }

    // reverses the array
    public static String[] reverse(String[] aos) {
        int i = 0;
        int j = aos.length - 1;
        while(i != j){
            String temp = aos[i];
            aos[i] = aos[j];
            aos[j] = temp;
            i++;
            j--;
        }
        return aos;
    }

    // returns an array of the words that are palindromes
    public static String[] loadWords(String path, int n) {

        // Connect to the web page of speeds
        URL url = null; // null is the "nothing value"
        Scanner s = null;

        try {
            url = new URL(path); // create a URL object for the path
            s = new Scanner(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create an array of strings
        String[] words = new String[n];
        String[] palindromes = new String[9];

        int i = 0;
        int j = 0;
        while(s.hasNextLine()){
            words[i] = s.nextLine();
            if(isPalindrome(words[i])){
                palindromes[j] = words[i];
                j++;
            }
            i++;
        }

        return palindromes;

    }
}
