

package com.bridgelabz.datastructuregeneric;

/*

@desc :
Node Class:

A generic inner class Node<T> represents a node in the linked list.
Each node contains data of type T and a reference to the next node.
Insertion Methods:

insertAtEnd(T val): Inserts a new element with the specified value at the end of the linked list.
insertByPosition(T val, int position): Inserts a new element with the specified value at the specified position in the linked list.
insertAtBegin(T val): Inserts a new element with the specified value at the beginning of the linked list.
insertByOrder(T data): Inserts a new element with the specified data in ascending order.
Deletion Methods:

pop(): Deletes the first element of the linked list.
popLast(): Deletes the last element of the linked list.
popByKey(T key): Deletes the element with the specified key from the linked list.
Search Method:

search(T val): Traverses the linked list to find and return the node with the given data value.
Other Methods:

insertAfterNode(Node<T> node, T data): Inserts a new node with the given data after the specified node.
printList(): Traverses and prints each element in the linked list.
size(): Returns the size (number of elements) in the linked list.
Main Method:

The main method demonstrates the usage of the generic linked list with various use cases, including insertion at different positions, deletion, searching, and ordered insertion.
 */
public class LinkedlistGeneric<T extends Comparable<T>> {

    Node<T> head;
    //initialization of a node


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
            if(last == curr){
                data = last.data;
            }
            if(curr.next != null) {
                data = curr.next.data;
            }
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


}

