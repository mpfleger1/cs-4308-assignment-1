package bst;

import bst.*;
import student.*;
import exception.*;
import io.*;

public class BST <T extends Comparable<T>>{
    private Node<T> root;

    public BST(){
        this.root = null;
    }

    public void insert(T value){
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> root, T value){
        if(root == null){
            return new Node<>(value);
        }

        int comparison = value.compareTo(root.value);
        if(comparison < 0){
            root.left = insertRecursive(root.left, value);
        }
        else if(comparison > 0){
            root.right = insertRecursive(root.right, value);
        }

        return root;
    }

    public boolean contains(T value){
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node<T> root, T value){
        if(root == null){
            return false;
        }

        int comparison = value.compareTo(root.value);
        if(comparison == 0){
            return true;
        }
        else if(comparison < 0){
            return containsRecursive(root.left, value);
        }
        else{
            return containsRecursive(root.right, value);
        }
    }

    public void inorderTraversal(){
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node<T> root){
        if(root != null){
            inorderRecursive(root.left);
            System.out.println(root.value + " ");
            inorderRecursive(root.right);

        }
    }
}
