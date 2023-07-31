package LA1Q1;

public class Node <T>{

        //fields
    private T element;
    Node <T> next;

        //constructor
    public Node(){}

        //constructor with parameters
    public Node (T element, Node<T> next){
        this.element=element;
        this.next=next;
    }

        //setter
    public void setNext(Node <T> next){
        this.next=next;
    }

        //getter
    public Node<T> getNext(){
        return next;
    }

        //getter
    public T getElement (){
        return element;
    }


}
