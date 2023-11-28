package DataStructureGeneric;

public class QueueGeneric<T extends Comparable<T>> extends LinkedlistGeneric<T>{
    Node<T> rear;
    /*
@desc : this function inserts a new node in the begin of linked list
@params : T- value to be inserted
@return : no return
 */
    public void enqueue(T val){
        insertAtEnd(val);
    }

    /*
@desc : this function gives the top value in linked list
@params : no params
@return : data will return
*/
    public T peek(){
        T data = null;
        if(head != null){
            data = head.data;
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println("!!! welcome to queue !!!");
        QueueGeneric<Integer> newStack = new QueueGeneric<>();
        newStack.enqueue(70);
        newStack.printList();
        newStack.enqueue(36);
        newStack.printList();
        newStack.enqueue(50);
        newStack.printList();
    }
}
