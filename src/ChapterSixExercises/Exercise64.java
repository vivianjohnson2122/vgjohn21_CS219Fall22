package ChapterSixExercises;

public class Exercise64 {

    public static void main(String [] args){
        // testing isAbecedarian()
        System.out.println(isAbecedarian("biopsy"));
        System.out.println(isAbecedarian("mossy"));
        System.out.println(!isAbecedarian("hello"));

        // testing isAlphabetical()
        System.out.println(isAlphabetical("biopsy"));
        System.out.println(isAlphabetical("mossy"));
        System.out.println(!isAlphabetical("hello"));

        // testing toLower()
        System.out.println(toLower("APPLE"));
        System.out.println(toLower("APplE"));

    }

    public static String toLower(String s){
        String r = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // check if character at position I is uppercase
            // use int positions of uppercase letter in Unicode List
            if('A' <= ch && ch <= 'Z')
                r = r + (char) ('a' + (ch - 'A'));
            else
                r = r + ch;
        }
        return r;
    }

    public static boolean isAbecedarian(String s){
        s = toLower(s);
        for(int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) > s.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static boolean isAlphabetical(String s){
        s = toLower(s);
        int i = 0;
        while(i < s.length() - 1){
            if(s.charAt(i) > s.charAt(i + 1))
                return false;
            i++;
        }
        return true;
    }
}
