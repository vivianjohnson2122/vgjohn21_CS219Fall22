package Wordle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class Game {


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

        int i = 0;
        while(s.hasNextLine()){
            words[i] = s.nextLine();
            i++;
        }

        return words;

    }

    // return the index of target in aos otherwise return -1
    public static int indexOf(String target, String[] aos){

        for(int i = 0; i < aos.length; i++){
            if(aos[i].equals(target))
                return i;
        }
        return -1;
    }

    /*
        Return the location of target in aos between low and high
     */
    public static int bsearch(String[] aos, String target, int low, int high){

        // when the word isn't found low and high will switch
        if(low > high)
            return -1;

        int mid = (low + high) / 2;

        // checking if target is at mid
        if(aos[mid].equals(target))
            return mid;
        else if(aos[mid].compareTo(target) < 0) // if mid is alphabetically less than the target
            return bsearch(aos, target, mid+1, high);
        else // if mid is alphabetically greater than the target
            return bsearch(aos, target, low, mid-1);
    }

    public static void main(String[] args) {

        // making the array of words to pick from
        String[] words = loadWords("http://10.60.15.25/~ehar/cs219/wordle-nyt-solutions.txt", 2309);

        Random rng = new Random();
        // pick a word at random
        rng.setSeed(23);
        String word = words[rng.nextInt(0, words.length)];
        System.out.println(word);

        // find the location of word in words
        System.out.println(indexOf(word, words));
        System.out.println(bsearch(words, word, 0, words.length-1));
    }
}
