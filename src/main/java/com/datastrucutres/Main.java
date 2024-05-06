package com.datastrucutres;

import com.datastrucutres.list.singleLinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SinglyLinkedList myList = new SinglyLinkedList();

        myList.insert(1);
        myList.insert(1);
        myList.insert(2);
        myList.insert(2);
        myList.insert(3);
        myList.insert(3);
        myList.insert(9);



        //  myList.printList();

       // myList.delete(5);

        myList.printList();
        myList.length();

        //myList.reverse();
        myList.printList();

        //myList.findNodeFromEnd(1);
        myList.removeDuplicate();
        myList.printList();

        myList.insertNodeSortedList(2);
        myList.printList();

    }
}