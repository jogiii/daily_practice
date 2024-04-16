package com.datastrucutres.list.singleLinkedList;

public class SinglyLinkedList {
    private Node head; //head of the list

    //Linked List node
    //This inner class is made static
    //so that main class can access it
    public static class Node{
        int data;
        Node next;

        Node(int d){
            data =d;
            next=null;
        }
    }

    public void insert( int data){

        Node new_node = new Node(data);

        if(head == null){
            head = new_node;
        }else{
            Node last = head;

            while(last.next != null){
                last = last.next;
            }

            last.next = new_node;
        }


    }

    public void printList() {
        Node current = head;

        System.out.print("LinkedList: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
// TODO: implement delete method
//    public void delete(int data){
//
//        Node current = head;
//        Node prev = null;
//        //if node to be deleted is head node
//        if(current != null && current.data == data) {
//            current.next = head;
//        }
//
//        //search for node and delete
//        while(current != null && current.data ){
//
//        }
//        // node not found
//    }
}
