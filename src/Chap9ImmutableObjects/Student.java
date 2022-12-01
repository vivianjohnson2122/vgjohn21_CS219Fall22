package Chap9ImmutableObjects;

public class Student {

    // classes encapsulate related data
    // template for creating objects

    private String first;
    private String last;
    private String id;
    private String nickname;

    // making a constructor
    public Student(String first_, String last_, String id_, String nickname_){

        first = first_;
        last = last_;
        id = id_;
        nickname = nickname_;

    }

    public String toString(){
        return last + ", " + first + "(" + nickname + ")";
    }

}
