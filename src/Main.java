/*
Matthew Pfleger
CS
 */

import bst.*;
import student.*;
import exception.*;
import io.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.err.println("expected data file name and error file name command line arguments");
            System.exit(1);
        }
        try
        {
            StudentIO stdIO = new CLIStudentIO();
            BST<Student> stds = stdIO.getStudents(args[0], args[1]);
            stdIO.displayAllStudents(stds);
        }
        catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
        catch (FileNotFoundException e)
        {
            System.err.println("data file not found");
        }
        catch (IOException e)
        {
            System.err.println("problem creating error file");
        }
        catch (Exception e)
        {
            System.err.println("unexpected error occurred - terminating");
        }
    }

}