

package DataStructureGeneric;


public class LinkedlistGeneric<T extends Comparable<T>> {

    Node<T> head;
    //initialization of a node
    /*
    @desc : Class node is a generic class it contains and data and a next pointer of type T which we initialize

     */
    public class Node<T>{
        T data;
        Node<T> next;
        /*
        @desc : constructor initializing node with value d of type T(object)
        @param - T(Type object primitive) - data
        @return : no return
         */
        Node(T data){
            this.data = data;
            next = null;
        }
    }

/*

 @desc : Inserts a new element with the specified value at the end of the linked list of given type T.

 @param val The value to be inserted of type T.

 @return No explicit return value.

 */

    public void insertAtEnd(T val){
        Node<T> latestNode = new Node<T>(val);
        latestNode.next = null;
        if(head == null){
            head = latestNode;
        }else{
            Node<T> last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = latestNode;
        }
    }

    /*

 @desc : Inserts a new element with the specified value at the position specified of the linked list of given type T.

 @param val The value to be inserted of type T.
 @param position the position to be inserted of type integer

 @return No explicit return value.

 */
    public  void insertByPosition(T val , int position){
        Node<T> latestNode = new Node<T>(val);
        Node<T> nextNode = null;
        latestNode.next = null;

        if(head == null){
            head = latestNode;
        }else if(position==0){
            Node<T> temp = head;
            head = latestNode;
            latestNode.next = temp;
        }else{
            Node<T> last = head;
            int counter=1;
            while(last.next != null){
                if(counter == position){
                    nextNode = last.next;
                    break;
                }
                counter++;
                last = last.next;
            }
            if(position > counter){
                System.out.println("your entered position " + position + " is more than the linked list size");
                System.out.println("So we are adding at last");
            }
            last.next = latestNode;
            latestNode.next = nextNode;
        }
    }

    /*

 @desc : Inserts a new element with the specified value at the beginning of the linked list of given type T.

 @param val The value to be inserted of type T.

 @return No explicit return value.

 */

    public void insertAtBegin(T val){
        Node<T> latestNode = new Node<T>(val);
        latestNode.next = null;
        if(head == null){
            head = latestNode;
        }else{
            Node<T> last = head;
            head = latestNode;
            head.next = last;
        }
    }

    /*
     @desc :  Inserts a node with the specified data in ascending order in the linked list.
     This method compares the data of the current node with the given data and inserts the new node at the appropriate position.

      @param data The data to be inserted.
      @return : no return
     */
    public void insertByOrder(T data) {
        Node<T> latestNode = new Node<T>(data);
        latestNode.next = null;

        if (head == null) {
            head = latestNode;
        } else {
            Node<T> currNode = head;
            Node<T> prev = null;

            // Traverse the list to find the appropriate position for insertion
            while (currNode != null && currNode.data.compareTo(data) < 0) {
                prev = currNode;
                currNode = currNode.next;
            }

            // Insert the new node at the correct position
            if (prev == null) {
                latestNode.next = head;
                head = latestNode;
            } else {
                latestNode.next = currNode;
                prev.next = latestNode;
            }
        }
    }
       /*

 @desc : delete the first element if it is not null.

 @param : no params.

 @return : returns the deleted value.

 */

    public T pop(){
        T data = null;
        if(head != null){
            data = (T) head.data;
            head = head.next;

        }
        return data;
    }

/*
 @desc : delete the last element if it is not null.

 @param : no params.

 @return : returns the deleted value.

 */

    public T popLast(){
        T data = null;
        if(head != null){
            Node<T> last = head;
            Node<T> curr = last;
            while(last.next != null){
                curr = last;
                last = last.next;

            }
            data = curr.next.data;
            curr.next = null;
        }
        return data;
    }

    /*
     @desc : delete the  element based on the key given if it is not null.

     @param : no params.

     @return : returns the deleted value.

     */
    public T popByKey( T key){
        T data = null;
        Node<T> currNode = head, prev = null;

        if (currNode != null && currNode.data == key) {
            data = (T)head.data;
            head = currNode.next;
        }
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            data = (T)currNode.data;
            prev.next = currNode.next;
        }

        if (currNode == null) {
            System.out.println(key + " not found");
        }
        return data;

    }

    /*

    @desc :  This method traverses the linked list and find the node with given data key.

    @param :  Type T , val.

    @return :  It returns a node.
*/
    public Node<T> search(T val){
        Node<T> currNode = head;
        while ( currNode != null && currNode.data != val) {
            currNode = currNode.next;
        }
        return currNode;
    }



    /*
    @desc :  Inserts a new node with the given data after the specified node.
    @param node The node after which the new node will be inserted.
    @param data The data to be inserted into the new node.
    @return void
     */
     public void insertAfterNode(Node<T> node , T data){
         Node<T> latestNode = new Node<T>(data);
         latestNode.next = null;
        if(node != null){
            Node<T> currNode = head;
            while (currNode != node) {
                currNode = currNode.next;
            }
            latestNode.next = currNode.next;
            currNode.next = latestNode;
        }
     }
    /*

        @desc :  This method traverses the linked list and prints each element.

        @param :  None.

        @return :  No explicit return value.
 */
    public void printList()
    {
        Node<T> currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    /*
    @desc : it gives the size of the linkes list
    @param : no params
    @return : returns an integer
     */
    public int size(){
        int count =0;
        Node<T> currNode = head;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }


    public static void main(String[] args) {

        System.out.println("!!! Welcome the linked list generic problem !!!");

        //initialized a integer link list
        LinkedlistGeneric<Integer> newLinkedList = new LinkedlistGeneric<>();
        // usecase 3
        newLinkedList.insertAtBegin(70);
        newLinkedList.printList();
        newLinkedList.insertAtBegin(30);
        //30 -> 70
        newLinkedList.printList();
        newLinkedList.insertAtBegin(56);
        //56 -> 30 -> 70
        newLinkedList.printList();

        //use case 2
        newLinkedList.insertAtEnd(56);
        //56 -> 30 -> 70 -> 56
        newLinkedList.printList();
        newLinkedList.insertAtEnd(30);
        //56 -> 30 -> 70 -> 56-> 30
        newLinkedList.printList();
        newLinkedList.insertAtEnd(70);
        //56 -> 30 -> 70 -> 56 -> 30 -> 70
        newLinkedList.printList();

        //usecase 4
        newLinkedList.insertByPosition(100 , 3);
        //56 -> 30 -> 70 -> 100 -> 56 -> 30 -> 70
        newLinkedList.printList();
//usecase 5
        System.out.println("deleted item first is : " + newLinkedList.pop());
        //30 -> 70 -> 100 -> 56 -> 30 -> 70
        newLinkedList.printList();
        //usecase 6
        System.out.println("deleted item last is : " + newLinkedList.popLast());
        //30 -> 70 -> 100 -> 56 -> 30
        newLinkedList.printList();
        //usecase 7
        if(newLinkedList.search(100) != null){
            System.out.println("element is present in linked list");
        }
        //usecase 8
        LinkedlistGeneric<Integer>.Node<Integer>node = newLinkedList.search(100);
        newLinkedList.insertAfterNode(node , 57);
        newLinkedList.printList();
//usecase 9
        newLinkedList.popByKey(100);
        newLinkedList.printList();

        //usecase 10
        System.out.println("\nOrdered linkedlist : ");
        LinkedlistGeneric<Integer> newOrderedLinkedList = new LinkedlistGeneric<>();

        newOrderedLinkedList.insertByOrder(100);
        newOrderedLinkedList.insertByOrder(40);
        newOrderedLinkedList.printList();
        newOrderedLinkedList.insertByOrder(50);
        newOrderedLinkedList.printList();
        newOrderedLinkedList.insertByOrder(90);
        newOrderedLinkedList.printList();


    }

}

