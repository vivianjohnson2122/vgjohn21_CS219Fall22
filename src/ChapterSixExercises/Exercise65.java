package ChapterSixExercises;

public class Exercise65 {

    public static void main(String[] args){

        // testing isDoubloon()
        System.out.println(isDoubloon("appeases"));
        System.out.println(isDoubloon("abba"));
        System.out.println(isDoubloon("esophagographers"));
        System.out.println(!isDoubloon("apple"));
    }

    /*
     * Returns true if every letter in s appears exactly twice
     */
    public static boolean isDoubloon(String s){
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                   count ++;
                }
            }
            if(count != 2) {
                return false;
            }
        }
        return true;
    }
}
