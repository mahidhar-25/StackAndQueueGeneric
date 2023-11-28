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
        updateRear();
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

    public void updateRear(){
        if(head != null){
            Node<T> root = head;
            while(root.next != null){
                root = root.next;
            }
            rear = root;
        }
    }

    /*
@desc : this function gives the top value in linked list
@params : no params
@return : data will return
*/
    public T lastData(){
        T data = null;
        if(rear != null){
            data = rear.data;
        }
        return data;
    }
    /*
  @desc : this function removes the top element
  @params : no params
  @return : data will return
   */
    public T dequeue(){
        T data = super.popLast();
        if(data != null){
            System.out.println("first element deleted successfully");
        }
        updateRear();

        return data;
    }
    public static void main(String[] args) {
        System.out.println("!!! welcome to queue !!!");
        QueueGeneric<Integer> newQueue= new QueueGeneric<>();
        newQueue.enqueue(70);
        newQueue.printList();
        newQueue.enqueue(36);
        newQueue.printList();
        newQueue.enqueue(50);
        newQueue.printList();
        System.out.println("top element in queue is : " + newQueue.lastData());
        newQueue.dequeue();
        newQueue.printList();
        System.out.println("top element in queue is : " + newQueue.lastData());
        newQueue.dequeue();
        newQueue.printList();
    }
}
