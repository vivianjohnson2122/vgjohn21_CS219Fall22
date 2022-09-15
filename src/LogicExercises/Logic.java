package LogicExercises;

public class Logic {
    public static void main(String[] args){

        // testing caughtSpeeding
        System.out.println(caughtSpeeding(60, false) == 0);
        System.out.println(caughtSpeeding(65, false) == 1);
        System.out.println(caughtSpeeding(65, true) == 0);
        System.out.println(caughtSpeeding(81, false) == 2);
        System.out.println(caughtSpeeding(81, true) == 1);

        // testing cigarParty
        System.out.println(cigarParty(30, false) == false);
        System.out.println(cigarParty(50, false) == true);
        System.out.println(cigarParty(70, true) == true);

        // testing ordered
        System.out.println(ordered(1, 2, 3) == true);
        System.out.println(ordered(3, 2, 1) == true);
        System.out.println(ordered(5, 2, 8) == false);
    }

    public static boolean cigarParty(int cigars, boolean isWeekend){
        if(isWeekend){
            if(cigars >= 40){
                return true;
            } else {
                return false;
            }
        } else {
            if(cigars >= 40 && cigars <= 60){
                return true;
            } else {
                return false;
            }
        }
    }
    public static int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday) {
            if(speed <= 65){
                return 0;
            } else if(speed <= 85){
                return 1;
            } else {
                return 2;
            }
        } else {
            if(speed <= 60){
                return 0;
            } else if(speed <= 80){
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static boolean ordered(int d1, int d2, int d3){
        // returns the t/f value of this conditional statement
        return ((d1 > d2 && d2 > d3) || (d3 > d2 && d2 > d1));
    }
}
