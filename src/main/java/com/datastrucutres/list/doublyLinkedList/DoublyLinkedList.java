package com.datastrucutres.list.doublyLinkedList;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;

    }


    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void insert(int data){

        Node new_node = new Node(data);
        // head
        if(head ==  null){
            head = new_node;
            tail = new_node;
        }else{
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;

        }

    }

    public void insertAtStart(int data){
        Node new_node = new Node(data);

        if(head == null){
            head = new_node;
            tail = new_node;
        }else{
            new_node.next = head;
            new_node.prev = head.prev;
            head.prev = new_node;
            head = new_node;


        }
    }

    public void deleteAtStart(int data){
        if(head.data != data){
            System.out.println(data+" is not present");
        }else{

           head = head.next;
           head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (tail == null) {
            // List is empty, nothing to delete
            return;
        } else if (head == tail) {
            // List has only one node
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
}
