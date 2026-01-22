package io;

import bst.*;
import student.*;
import exception.*;

/**
 *
 * CLIStudentIO class defines functions used for reading in arguments from CLI and displaying desired info
 *
 */

public class CLIStudentIO extends StudentIO {

    /**
     * Used to print single instance of Student class info
     * @param std - Instance of Student class
     * @throws IllegalArgumentException
     */

    @Override
    public void displayStudent(Student std) throws IllegalArgumentException{
        if(std == null)
            throw new IllegalArgumentException("null domain.Employee argument in displayEmployee");
        System.out.println(std);
    }

    /**
     * Used to print the instances of Student class contained in BST via inorder traversal
     * @param students - BST containing instances of Student class
     * @throws IllegalArgumentException
     */

    @Override
    public void displayAllStudents(BST<Student> students) throws IllegalArgumentException{
        students.inorderTraversal();
    }
}
