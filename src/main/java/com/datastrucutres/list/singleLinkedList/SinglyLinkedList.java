package com.datastrucutres.list.singleLinkedList;

import java.util.List;

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

    public void reverse(){
                Node current = head;
                Node prev = null;
                Node next = null;


                while(current != null) {
                    next = current.next;
                    current.next = prev;

                    prev = current;
                    current = next;
                }

                head = prev;

        System.out.println("list reversed");

        }


        public Node findNodeFromEnd(int n){

        Node mainPtr = head;
        Node refPtr = head;
        int count  =0;
        while(count < n){
            if(refPtr == null){
                System.out.println("list is empty");
                return null;
            }
            refPtr = refPtr.next;
            count++;
        }

        // now iterate both of them simultaneously


            while(refPtr !=null){
                mainPtr = mainPtr.next;
                refPtr = refPtr.next;
            }
            System.out.println(mainPtr.data + " is the element");
            return mainPtr;


        }


        public void removeDuplicate(){
            Node current = head;

            while(current != null && current.next != null){
                if(current.data == current.next.data){
                    System.out.println("duplicate found");
                    current.next = current.next.next;
                }else {
                    current = current.next;
                }
            }

        }

        public void insertNodeSortedList(int data){

            Node newNode = new Node(data);

            // Case 1: If the list is empty or the new node should be inserted at the beginning
            if (head == null || head.data >= data) {
                newNode.next = head;
                head = newNode;
                System.out.println(data + " inserted at the beginning");
                return;
            }

            // Traverse the list to find the correct position for insertion
            Node current = head;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }

            // Insert the new node
            newNode.next = current.next;
            current.next = newNode;


        }


    public Boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public  Node findTheStartOfLoop(Node head){


        Node slow = head;
        Node fast = head;


        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        Node prev = null;

        while (slow !=fast){

            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Detect the loop
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // If there's no loop
        if (fast == null || fast.next == null) {
            return;
        }

        // Reset slow to head and move both pointers until they meet
        slow = head;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Set the next pointer of the node causing the loop to null
        prev.next = null;
    }

    public Node mergeTwoSortedList(Node list1, Node list2){

        Node tempList = new Node(0);
        Node current= tempList;

        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2=list2.next;
            }
            current = current.next;

        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return tempList.next;


    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        SinglyLinkedList l = new SinglyLinkedList();
        boolean hasCycle = l.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + l.findTheStartOfLoop(head).data);
        l.removeLoop(head);

        System.out.print("LinkedList: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();

    }

}
