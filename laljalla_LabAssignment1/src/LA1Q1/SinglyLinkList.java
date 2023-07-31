package LA1Q1;

import java.util.Scanner;

public class SinglyLinkList <T> {

        //fields
    private Node<T> head;
    private Node<T> tail = null;
    private int size;

        //constructor with parameters
    public SinglyLinkList(Node<T> head, Node<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

        //constructor
    public SinglyLinkList() {}

        //size of the list
    public int getSize() {
        return size;
    }

    //prints out the proper format of the list
    public String toString() {

            //if list is empty with no elements
        if (size == 0) {
            return "[]";
        }
        String rs = String.format("[");

        //current is the variable of head (Node type)
        Node<T> current = head;

            //when there is a head pointing to another element then it will go through the loop to print " , " each time
        while (current != null) {
            rs += String.format(current.getElement() + ", ");

                //makes the new head, the element next to the previous head
            current = current.getNext();
        }

            //lastly closes the stack with
        rs += String.format("\b\b]\n");
        return rs;
    }

        // checks if the list is empty
    public boolean isEmpty() {
        if (getSize() == 0)
            return true;
        else
            return false;
    }

        //this method will add a new head to the list
    public void addFirst(T newHead) {
        Node <T> newNode = new Node <T> (newHead,head);
        head=newNode;
        if(isEmpty()){
            tail=head;
        }
        size++;

            //makes a new head by calling Node with constructor
//        Node<T> newNode = new Node<T>(newHead, head);
//        head=newNode;
//            //if no elements, then head is tail
//        if (size==0) {
//            tail = head;
//        }
//            //increment size
//        size++;
    }

        //this method adds a new tail to the list
    public void addLast(T newTail) {
            //makes a new tail that points to the null
        Node<T> newNode = new Node<>(newTail, null);
            //if it's an empty list then the head is = tail
        if (isEmpty()) {
            head = newNode;
        }
            //setting the new tail and increasing the size of the list
        else
            tail.setNext(newNode);
        tail=newNode;
//           tail.setNext(newNode);
//        tail = newNode;
        size++;
    }


    public T removeFirst() {
        if (isEmpty())
            return null;
        T answer = head.getElement(); //update new head element
        head = head.getNext();  //update head to point to next node in the list
        size--; //decrease the size
        if (size == 0)
            tail = null;
        return answer;
    }

    public T removeLast() {
            //reference variable
        T removeElement = null;

            //if list is empty
        if (isEmpty())
            return null;

            //if list size is 1 then only one thing will get removed
            // thus the head and tail which are both the same element will be equal to null, hence removed
        else if (size == 1) {
            removeElement = head.getElement();
            size--;
            head = tail = null;
            return removeElement;
        }
            //current is the head. if the element after the element of the head points to null then it means it's the tail

        else {
            Node<T> current = head;
            for (int i = 1; i < size; i++) {
                if (current.getNext().getNext() == null) {

                        //gets the element of the tail
                    removeElement = tail.getElement();
                        //sets null as to where current is pointing at
                    current.setNext(null);
                    tail = current;
                    size--;
                    break;
                }
                current = current.getNext();
            }
        }
        return removeElement;
    }


        //will add an element to the head of the list
    public void pushAtHead(T element) {
        addFirst(element);
    }

        //will remove the first element of the head
    public T popFromHead() {
        return removeFirst();
    }

        //will remove the last element of the list
    public T popFromTail() {
        return removeLast();
    }

        //will add an element to the end of the list
    public void pushAtTail(T element) {
        addLast(element);
    }

        //will add an element to the end of the list
    public void enqueueAtTail(T element) {
        addLast(element);
    }

        //will remove the first element of the head
    public T dequeueAtHead() {
        return removeFirst();
    }


    public int searchStack(T element) {
            //initialize the position with a value of one
        int position = 1;
        Node curr = head;

            //while loop that will loop if the head value is does not point to null
        while (curr != null) {
                //if the element at the head is equal to the user input, position that got set to 1 with one will return, thus user here input the value of the first element
            if (curr.getElement() == element)
                return position;
                //if the user didn't put the value of the first element then the new value of the head will be the next element of the list
            else
                curr = curr.getNext();
                //position is therefore incremented in this loop
            position =position+1;
        }
        return position;
    }
}





