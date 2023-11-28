package DataStructureGeneric;

public class StackGeneric<T extends Comparable<T>> extends LinkedlistGeneric<T> {

    /*
    @desc : this function inserts a new node in the begin of linked list
    @params : T- value to be inserted
    @return : no return
     */
    public void push(T val){
        insertAtBegin(val);
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
    /*
 @desc : this function removes the top element
 @params : no params
 @return : data will return
  */
    public T pop(){
        T data = super.pop();
        if(data != null){
            System.out.println("first element deleted successfully");
        }

        return data;
    }
    public static void main(String[] args) {
        System.out.println("!!! welcome to stack !!!");
        StackGeneric<Integer> newStack = new StackGeneric<>();
        newStack.push(70);
        newStack.printList();
        newStack.push(36);
        newStack.printList();
        newStack.push(50);
        newStack.printList();
        System.out.println("top element in stack is : " + newStack.peek());
        newStack.pop();
        newStack.printList();
        System.out.println("top element in stack is : " + newStack.peek());
        newStack.pop();
        newStack.printList();
    }
}
