package LE3Q1;

import java.util.ArrayList;
public class DoublyLinkedList <E> {

    public static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        //constructor with parameters
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        //setter
        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        //getter
        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        //getter
        public E getElement() {
            return element;
        }

    }

    private Node<E> trailer;
    private int size;
    private Node<E> header;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else return false;
    }

    public int size() {
        return size;
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public String toString() {
        ArrayList<E> studentList = new ArrayList<>();

        String rs = String.format("[");
        Node<E> current = header;
        current = current.getNext();

        while (current != null) {
            studentList.add(current.getElement());
            rs += String.format(current.getElement() + ", ");
            current = current.getNext();
        }
        //studentList.remove(0);
        studentList.remove(studentList.size() -1);
        return String.format(studentList.toString());
    }

    public Node<E> findNode(E element) {
        Node<E> current = header.getNext();
        if (isEmpty()) {
            return null;
        }
        else {
            while (current != null) {
                //System.out.println(current);
                if (current.getElement() == element) {
                    break;
                }//   return current;

                else
                    current = current.getNext();
                continue;

            }
        }
        return current;
    }
}

