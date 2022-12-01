package Chap9ImmutableObjects;

import java.time.temporal.ChronoField;

public class Main {

    public static void main(String[] args) {

        // strings are immutable - can't be changed
        String s = "hello";
        String t = new String("hello");

        // make a version of s that is capitalized
        String s1 = Character.toUpperCase(s.charAt(0)) + s.substring(1);

        // character objects are also immutable
        char ch = 'a';
        Character ch2 = 'a';
        //Character ch3 = new Character('a');

        /*
            Double, Long, Boolean, Integer, Character are all wrapper classes for their respective primitive type
            Autoboxing: taking a primitive value and wrapping it in an object
            Autounboxing: turning an object into its primitive
            ints are primitive - can be represented in binary
            y is a referecne object - it refers to the object (which is 33)
         */

        int x = 33;
        Integer y = 33;
        //Integer y1 = new Integer(33);

        double pi = 3.14159;
        Double pi1 = 3.14159;
        pi1 = 2.7128; // this is ok because it's reassigning a reference to a new object

        boolean flag = false;
        Boolean flag1 = false;

        long l = 43;
        Long ll = 43L; // defines as a long with 64 bits intead of a 32 bit int

        Student student1 = new Student("Hermione", "Granger", "123", "The Smart One");
        // student1.first = "Harry"; --> error because can't access private data outside of class
        System.out.println(student1); // toString() is implicitly called

        Student student2 = new Student("Vivian", "Johnson", "14006079", "Viv");
        System.out.println(student2);

    }
}

