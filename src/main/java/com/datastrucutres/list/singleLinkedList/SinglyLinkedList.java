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

    public void delete(int data) {
        // Case 1: If the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Case 2: If the node to be deleted is the head node
        if (head.data == data) {
            head = head.next;
            System.out.println(data + " found and deleted");
            return;
        }

        // Case 3: Search for the node to be deleted
        Node current = head;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        // Case 4: If the node was not found
        if (current == null) {
            System.out.println(data + " not found");
            return;
        }

        // Case 5: Node found in the middle or end of the list
        prev.next = current.next;
        System.out.println(data + " found and deleted");
    }

    public int length(){
        ;
        Node current = head;
        int count =0;

        while(current != null){
            count++;
            current = current.next;
        }
        System.out.println("length is "+ count);
        return count;
    }
}
