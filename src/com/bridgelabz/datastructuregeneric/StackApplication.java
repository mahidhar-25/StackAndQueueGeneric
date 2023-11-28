package com.bridgelabz.datastructuregeneric;

/*
@desc : this class is used for testing and implementing stack class and testing it out all the operations
 */
public class StackApplication {
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
