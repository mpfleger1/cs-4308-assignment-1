package bst;

import bst.*;
import student.*;
import exception.*;
import io.*;

public class Node<T extends Comparable<T>> {
    T value;
    Node<T> left, right;

    Node(T value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
