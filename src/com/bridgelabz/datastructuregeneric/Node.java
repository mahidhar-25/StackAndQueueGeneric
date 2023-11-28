package com.bridgelabz.datastructuregeneric;
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
