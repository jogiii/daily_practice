package com.datastrucutres.binaryTrees;

import java.util.Stack;

public class BinaryTree {

    Node root;

    BinaryTree(int key){
        root = new Node(key);
    }

    BinaryTree(){
        root = null;
    }

    public void preOrder(Node root){ /* 1) first visit the node 2) left sub tree 3) right sub tree*/
        if(root == null){
            //System.out.println("tree is empty");
            return;
        }


        System.out.println(root.key);
        preOrder(root.left);
        preOrder(root.right);
    }


    public void preOrderWithoutRecurssion(Node root){
        if(root == null){
            return;
        }

        Stack<Node> stack  = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){


            Node temp = stack.pop();
            System.out.println(temp.key);

            if(temp.right != null){     /* right first because stack will use LIFO so in order to process left first we push right then left */
                stack.push(temp.right);
            }
            if(temp.left !=null){
                stack.push(temp.left);
            }
        }


    }


    public void inOrder(Node root){ /* 1) first left sub tree 2) then visit the node 3) then right sub tree*/
        if(root ==null){
            return;
        }

        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }

    public void inOrderWithouRecurssion(Node root){

        if(root ==null){
            return;
        }


        Stack<Node> stack = new Stack<>();
        Node temp = root;


        while(!stack.isEmpty()  || temp != null){

            if(temp !=null){
                stack.push(temp);
                temp = temp.left;
            }else{

                temp =stack.pop();
                System.out.println(temp.key);
                temp = temp.right;
            }

        }



    }



    public void postOrder(Node root){ /*1) first left sub tree 2) then right sub tree 3) visit the node  */


        if(root ==null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.key);
    }


    public void postOrderWithoutRecurssion(Node root){
        if(root ==null){
            return;
        }


        Stack<Node> stack = new Stack<>();
        Node current = root;


        while(current !=null || !stack.isEmpty()){
            if(current !=null){
                stack.push(current);
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp =stack.pop();
                    System.out.println(temp.key);


                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.println(temp.key);
                    }
                }
                else{
                    current = temp;
                }



            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);

        tree.postOrderWithoutRecurssion(tree.root);
    }

}
