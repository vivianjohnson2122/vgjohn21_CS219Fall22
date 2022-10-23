package StringPlay;

public class CharacterPlay {

    public static int countVowels(String s){
        int numVowels = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i); // get the character at index i
            if(ch == 'a' || ch == 'A'|| ch == 'e' || ch == 'E' ||
                    ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' ||
                    ch == 'u' || ch == 'U'){
                numVowels ++;
            }
        }
        return numVowels;
    }

    public static void main(String[] args){

        System.out.println(countVowels("applesauce") == 5);
        System.out.println(countVowels("Hippopotomonstrosesquipedaliophobia") == 16);

        char ch = 'a';  // use '' ONLY for chars
                        // shorthand for int - assigned by the unicode consortium
        System.out.println(ch);
        System.out.println((int) ch);   // gives the unicode character number
        System.out.println((char) ('a' + 1)); // converts the unicode number of 98 to a char (b)
        System.out.println((char) 8749);    // need to cast it as a char so that the character comes up
        System.out.println((char) 198);
        System.out.println((char) 960);
    }
}
