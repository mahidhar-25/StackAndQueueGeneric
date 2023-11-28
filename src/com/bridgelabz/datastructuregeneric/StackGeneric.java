package com.bridgelabz.datastructuregeneric;
/*
@desc : this class represents a stack where it has ons sided link list you can insert from one end you can pop from
        same end , you have peek method to see the top element inside statck
 */
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

}
