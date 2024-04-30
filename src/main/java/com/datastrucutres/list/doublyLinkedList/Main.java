package com.datastrucutres.list.doublyLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        // Inserting elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insertAtStart(50);

        // Displaying the list
        System.out.print("List: ");

        list.display();
    }
}
