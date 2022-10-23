package HW5;

public class Exercise66 {

    public static void main(String[] args) {
        System.out.println(canSpell("boot", "axobasrto"));
        System.out.println(canSpell("mighty", "ykjxttuihrgim"));
        System.out.println(canSpell("omega", "cotmugdedray"));
        System.out.println(canSpell("GrEat", "uoLhegeTuaru"));
        System.out.println(canSpell("Giants", "kdhtnigIaoopests"));
        System.out.println(!canSpell("hi", "aahaaa"));
        System.out.println(!canSpell("zoink", "abcdefgh"));
        System.out.println(!canSpell("llama", "pplplpamo"));
        System.out.println(!canSpell("hippo", "haxbapsrito"));
        System.out.println(!canSpell("llama", "pplppaamo"));


    }

    // check and see if char at index i of word is in tiles at all
    // if it is, go to next index, if not return false
    // if it is, remove letter from the tiles because can only use once
    public static boolean canSpell(String word, String tiles) {
        boolean canSpell = true;
        word = word.toLowerCase();
        tiles = tiles.toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (tiles.indexOf(currentChar) >= 0) { // currentChar of word is in the tiles
                    int position = tiles.indexOf(currentChar); // gets the index of currentChar in tiles
                    tiles = tiles.substring(0, position) + tiles.substring(position + 1); // remove the char at pos from tiles
                } else
                    canSpell = false;
        }
        return canSpell;
    }
}

