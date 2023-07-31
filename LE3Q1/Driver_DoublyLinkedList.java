package LE3Q1;

public class Driver_DoublyLinkedList {
    public static void main(String[] args) {

        myHeader(3,1);

        DoublyLinkedList <Student> liyanList = new DoublyLinkedList<>();

        Student s0= new Student();
        Student s1= new Student("Harry",67.35);
        Student s2= new Student("Luna",87.5);
        Student s3= new Student("Vincent", 60.5);
        Student s4= new Student("Hermione",89.2);

        liyanList.addLast(s0);
        liyanList.addLast(s1);
        liyanList.addLast(s2);
        liyanList.addLast(s3);
        System.out.print("Adding 4 students to the list.\nThe list Content:\n" + liyanList + "\nAdding Hermione to the list in between Luna and Vincent.....\nThe list Content:\n");

        DoublyLinkedList.Node<Student> mainNode = new DoublyLinkedList.Node<>(s4,liyanList.findNode(s2),liyanList.findNode(s3));
        liyanList.addBetween(s4,mainNode.getPrev(),mainNode.getNext());

        System.out.println(liyanList);

        myFooter(3,1);

    }

    public static void myHeader(int exerciseNum, int qNum) {
        System.out.printf("=======================================================\nLab Exercise %d-Q%d\nPrepared By: Liyan Al-Jallad\nStudent Number: 251246155\nGoal of this Exercise: Working with Nodes\n=======================================================\n", exerciseNum,qNum);
    }

    public static void myFooter(int exerciseNum,int qNum) {
        System.out.printf("=======================================================\nCompletion of Lab Exercise %d-Q%d is successful!\nSigning off- Liyan\n=======================================================\n", exerciseNum,qNum);
    }

}
