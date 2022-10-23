package ArrayExamples;

import java.util.Arrays;
import java.util.Random;

public class CardDeck {

    public static void main(String[] args) {
        String [] deck = buildDeck();
        System.out.println(Arrays.toString(deck));
        System.out.println(Arrays.toString(shuffle(deck)));

    }

    public static String[] buildDeck(){
        // using java unicode characters for club, heart, spade, diamond (could also use string emojis)♥♣♦♠
        // String [] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
        String[] suits = {"♥", "♣", "♦", "♠"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int i = 0;

        for(String suit : suits) { // for each suit in the suits array
            for(String rank : ranks) { // for each rank in ranks
                deck[i++] = suit + rank;
            }
        }
        return deck;
    }

    public static String[] shuffle(String[] aos){

        Random rng = new Random();

        for(int i = 0; i < aos.length - 1; i++){
            int r = rng.nextInt(i, aos.length); // i is changing w the index and the length isn't included )
            String temp = aos[i]; // taking the string at i and storing it in a temp variable
            aos[i] = aos[r]; // assigning string at i to the string at random place (r)
            aos[r] = temp; // assigning original string at i to the random place (swapping)
        }

        return aos;
    }

}
