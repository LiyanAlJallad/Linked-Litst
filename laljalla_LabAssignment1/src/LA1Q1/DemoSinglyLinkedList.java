package LA1Q1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class DemoSinglyLinkedList {
    public static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {

            //calling my header method
        myHeader(1);

            //Array list of type int and st to hold the values in the sample output
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));
        ArrayList<String> nmList = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));

            //instantiating the SinglyLinkedList class
            //one to hold int values and 2 to hold st values
        SinglyLinkList<Integer> list3 = new SinglyLinkList<>();
        SinglyLinkList<String> listSt = new SinglyLinkList<>();


            //prints out the arraylists
        System.out.println("The given Integer array: " + intList);
        System.out.println("The given String array: " + nmList);

            //INT ARRAY --> switching the first three positions for the int array
        for (int i = 0; i<3; i++) {
            list3.addFirst(intList.get(i)); }

            //switching positions for the last 2 elements in the int arr
        for (int j=4; j>2; j--) {
            list3.addLast(intList.get(j)); }

            //printing out the array after transferring the positions
        System.out.print("Your Integer List: " + list3);


            //STRING ARRAY --> switching the first three positions for the string array
        for (int i = 0; i<3; i++) {
            listSt.addFirst(nmList.get(i)); }

            //switching positions for the last 2 elements in the int arr
        for (int j=4; j>2; j--) {
            listSt.addLast(nmList.get(j)); }

            //printing out the array after transferring the positions
        System.out.println("Your String List: " + listSt);

            //calling the satckDemo class
        System.out.print("Stack demo with the Integer linked list ...\n");
        stackDemo(list3);

            //calling the queue demo class
        System.out.print("\nQueue dmeo with the String linked list ...\n");
        queueDemo(listSt);


        System.out.println("\nLet's search the stack: \nThe current Stack: " + list3.toString());
            //while loop if the user would like to continue the search process
        while (true) {
                    System.out.print("Enter the value you are searching for: ");
                    int value = input.nextInt();
                    int size = list3.getSize()+1;
                    int position = list3.searchStack(value);

                    while (true) {
                            //since in the method, the position could get incremented to a value of 5 for option two or a value of 3 for option 1 then conditional statements need to be set
                            //if the position found is bigger than the size of the list then the element that the user put doesn't exist
                        if (position>=size) {
                            System.out.print("The value is not found!");
                            break;
                        }

                            //if the position happens to satisfy the size of the element then an elements is found, thus its position will be returned for the search stack method
                        else {
                            System.out.print("The value " + value + " is found in location " + list3.searchStack(value) + " from the top of the stack");
                            break;
                        }
                    }

                            //if the user chooses to put y then the loop will start all over again for looking for a position for the user's input
                        System.out.print("\nDo you want to continue? (enter 'y' for yes, or enter any other key to discontinue): ");
                    char cont = input.next().charAt(0);
                    if (cont == 'y') {
                        continue;
                    }
                  else break;
                }

                myFooter(1);
        }




    public static void stackDemo(SinglyLinkList list3) {
       // Scanner input = new Scanner(System.in);
        int choice;


            while (true) {
                try {
                    System.out.print("Which end of the Linked List you would like to use as the stack top? ");
                    System.out.print("\nEnter 1 for head or 2 for tail: ");
                    choice = input.nextInt();

                    //conditional statement if choice is one
                    if (choice == 1) {
                        System.out.print("\nStack Top: Head of the linked list\n\nLet's pop all the elements from the stack in sequence: ");
                        System.out.println("\nThe current stack: " + list3.toString());

                            //loop that will remove  elements of the list by order
                            //it will start from the first index of the list, remove it, then move to the next one, stops at where the list stops
                        for (int i = 0; i <5 ; i++) {
                            System.out.print(list3.dequeueAtHead() + " has been popped! the revised stack: " + list3.toString());

                        }

                            //adding 39 and -58
                        System.out.println("\n\nLet's push 39 and -58 in the stack...");
                        System.out.println("The current Stack: " + list3.toString());
                        list3.pushAtHead(39);
                        System.out.print("After 39 is pushed, the revised stack: " + list3.toString());
                        list3.pushAtHead(-58);
                        System.out.print("After 58 is pushed, the revised stack: " + list3.toString());

                        break;
                    }
                    if (choice == 2) {
                        System.out.print("Stack Top: Tail of the linked list\n\nLet's pop first three elements from the stack in sequence: ");
                        System.out.println("\nThe current stack: " + list3.toString());

                            //loop that will start wih the element at the end of the list, removes it, then moves down to the previous elements
                            //until it gets till the second element, it stops
                        for (int i =list3.getSize(); i>2; i--){
                        System.out.print(list3.popFromTail() + " has been popped! The revised stack: " + list3.toString());
                    }

                        System.out.println("\nLet's push 39 and -58 in the stack...");
                        System.out.print(list3.toString());

                            //adding 39 and -58 to the end of the list
                        list3.pushAtTail(39);
                        System.out.print("After 39 is pushed, the revised stack: " + list3.toString());
                        list3.pushAtTail(-58);
                        System.out.print("After 58 is pushed, the revised stack: " + list3.toString());


                        break;
                    }
                        //validate the user input by throwing an exception
                    else {
                        throw new Exception();
                    }
                }
                //will catch the error/exception and return incorrect input + clean the buffer
                catch (Exception e) {
                    System.out.print("Incorrect input! ");
                    input.nextLine();

                }

            }
    }

    public static void  queueDemo(SinglyLinkList listSt){
        System.out.print("Note: Head is the Q-front, and Tail is the Q-rear\n\nLet's enqueue Joelle and Lukas in the queue in sequence...\n\nThe current Queue: " + listSt.toString() );
            //adding joelle and lukas to the end of the list by calling the enqueue tail method from the other class
        listSt.enqueueAtTail("Joelle");
        System.out.print("\nAfter Joelle is enqueued, the revised Queue: " + listSt.toString());
        listSt.enqueueAtTail("Lukas");
        System.out.println("After Lukas is enqueued, the revised Queue: " + listSt.toString() + "\nLet's dequeue first three elements from the queue in sequence ....\n\nThe current Queue: " + listSt.toString());

            //loop that will remove the first three elements of the list
        for (int i = 0; i < 3; i++) {
            System.out.print(listSt.dequeueAtHead() + " has been dequeued! the revised queue: " + listSt.toString());
        }

    }


        //my header method from lab 1 (edited)
    public static void myHeader(int exerciseNum) {
        System.out.printf("=======================================================\nLab Assignment %d\nPrepared By: Liyan Al-Jallad\nStudent Number: 251246155\nGoal of this Exercise: Working with Nodes\n=======================================================\n", exerciseNum);
    }

     //my footer method from lab 1 (edited)
    public static void myFooter(int exerciseNum) {
        System.out.printf("=======================================================\nCompletion of Lab Exercise %d is successful!\nSigning off- Liyan\n=======================================================\n", exerciseNum);
    }
}

