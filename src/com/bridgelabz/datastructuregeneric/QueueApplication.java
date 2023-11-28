package com.bridgelabz.datastructuregeneric;

/*
@desc : this class is used for testing and implementing stack class and testing it out all the operations
 */
public class QueueApplication {
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
