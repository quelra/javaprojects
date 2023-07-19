package ListPrograms;

public class ListNode<T> {

    private T info;
    private ListNode<T> link;

    public ListNode(T info, ListNode<T> link){
        this.info = info;
        this.link = link;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public void setLink(ListNode<T> link){
        this.link = link;
    }

    public T getInfo(){
        return info;
    }

    public ListNode<T> getLink(){
        return link;
    }
}
