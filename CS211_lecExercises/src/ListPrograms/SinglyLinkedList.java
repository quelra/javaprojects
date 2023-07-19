package ListPrograms;

public class SinglyLinkedList<T> {
        Node head;

        public void insert(T data){
                Node node = new Node();
                node.setData(data);

                if(head==null){
                        head = node;
                } else{
                        Node n = head;
                        while(n.getNext()!=null){
                                n = n.getNext();
                        }
                        n.setNext(node) ;
                }
        }

        public void insertAt(){

        }

        public void insertAtStart(){

        }
        public void insertAtEnd(){

        }
        public void delete(){

        }

        public void show(){
                 Node node = head;

                 while(node.getNext()!=null){
                         System.out.println(node.getData());
                         node = node.getNext();
                 }
                System.out.println(node.getData());
        }

        //etc.
}
