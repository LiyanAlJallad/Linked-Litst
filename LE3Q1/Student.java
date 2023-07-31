package LE3Q1;

public class Student {

    private String firstName;
    private Double score;

    public Student (){
        firstName="Liyan";
        score=89.55;
    }

    public Student(String firstName, Double score){
        this.firstName=firstName;
        this.score=score;
    }

    public String toString (){

        return String.format("%s: %.2f" ,firstName,score );
    }
}
