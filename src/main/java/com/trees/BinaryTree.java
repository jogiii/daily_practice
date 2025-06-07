package com.trees;

public class BinaryTree {


    public Node root;


    public void insert(int data){
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data){
        if(root == null){
            return new Node(data);
        }

        if(data< root.data){
            root.left = insertRec(root.left, data);
        }
        else if(data>root.data){
            root.right = insertRec(root.right, data);
        }

        return root;
    }

}
