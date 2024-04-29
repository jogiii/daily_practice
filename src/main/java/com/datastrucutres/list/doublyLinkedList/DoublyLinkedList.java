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
}
