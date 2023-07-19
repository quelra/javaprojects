package ListPrograms;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data){
    }

    public Node() {
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setNext(Node<T> node){
        next = node;
    }

    public Node<T> getNext(){
        return next;
    }
}
