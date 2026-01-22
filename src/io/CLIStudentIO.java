package io;

import bst.*;
import student.*;
import exception.*;
import io.*;

public class CLIStudentIO extends StudentIO {

    @Override
    public void displayStudent(Student std) throws IllegalArgumentException{
        if(std == null)
            throw new IllegalArgumentException("null domain.Employee argument in displayEmployee");
        System.out.println(std);
    }
    @Override
    public void displayAllStudents(BST<Student> students) throws IllegalArgumentException{
        students.inorderTraversal();
    }
}
