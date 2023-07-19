package ListPrograms;

public class MySinglyLinkedCircularList<T> {

    private ListNode last;
    private int length;

    private class ListNode<T>{
        private ListNode next;
        private T data;

        public ListNode(T data){
            this.data = data;
        }

    }

    public MySinglyLinkedCircularList(){
        last = null;
        length = 0;
    }

    public int getLength(){
        return length;
    }


    public boolean isEmpty(){
        return length == 0;
    }
    public void createCircularLinkedList() {
        ListNode first = new ListNode("a");
        ListNode second = new ListNode("b");
        ListNode third = new ListNode("c");
        ListNode fourth = new ListNode("d");

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;

    }
    public static void main(String[] args) {
        MySinglyLinkedCircularList csll = new MySinglyLinkedCircularList();
        csll.createCircularLinkedList();
    }


}
