package ListPrograms;

public class Test {
    public static void main(String[] args){
//        SinglyLinkedList<String> sLList = new SinglyLinkedList<>();
//
//        sLList.insert("a");
//        sLList.insert("b");
//        sLList.insert("c");
//        sLList.insert("d");
//        sLList.insert("e");
//        sLList.insert("f");
//        sLList.insert("g");
//
//        sLList.show();
//
//        ListNode<Integer> ptr1 = new ListNode<Integer>(32,null);
////        ListNode<Integer> list = new ListNode<Integer>(18,ptr1.getLink());
////        ptr1.
//
//
//        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
//        list.insert(18);
//        list.insert(32);
//        list.insert(23);
//        list.insert(16);
//        list.insert(43);
//        list.insert(87);
//        list.insert(25);
//        list.insert(44);


        ListNode<Integer> list = new ListNode<Integer>(18,null);
        ListNode<Integer> ptr1 = new ListNode<Integer>(32,null);
        ListNode<Integer> n3 = new ListNode<Integer>(23,null);
        ListNode<Integer> n4 = new ListNode<Integer>(16,null);
        ListNode<Integer> n5 = new ListNode<Integer>(43,null);
        ListNode<Integer> ptr2 = new ListNode<Integer>(87,null);
        ListNode<Integer> n7 = new ListNode<Integer>(25,null);
        ListNode<Integer> n8 = new ListNode<Integer>(44,null);

        list.setLink(ptr1);
        ptr1.setLink(n3);
        n3.setLink(n4);
        n4.setLink(n5);
        n5.setLink(ptr2);
        ptr2.setLink(n7);
        n7.setLink(n8);

//        ptr1=ptr1.getLink();
//        System.out.println(ptr1.getInfo());

//        ListNode<Integer> newNode = new ListNode<Integer>(10,
//                ptr1.getLink());
//        ptr1.setLink(newNode);
//
//        System.out.println(ptr1.getLink().getInfo());
//
//        ptr2=ptr2.getLink().getLink();
//        System.out.println(ptr2.getInfo());

//        System.out.println(list.getLink().getLink().getInfo());

//        ListNode<Integer> newNode = new ListNode<Integer>(99,ptr2.getLink());
//        ptr2.setLink(newNode);
//        System.out.println(ptr2.getLink().getInfo());

    }
}
