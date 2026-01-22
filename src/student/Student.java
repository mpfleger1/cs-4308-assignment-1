package student;

import bst.*;
import exception.*;
import io.*;

/**
 *
 * Student class implements the variables and methods for a basic student
 *
 */

public abstract class Student implements Comparable<Student> {
    private String name;
    private String student_number;
    private String birthday;
    private String major;
    protected double gpa;
    /**
    constructor for Student
    @param name - name of the student
        @pre name is not null
    @param student_number - unique student identification number
        @pre student_number is not null and is exactly 9 digits long
    @param major - student major of study
        @pre major is one of the valid majors
    @param birthday - student birthday
    @param gpa - student grade point average
        @pre gpa domain [0.0, 4.0]
     */
    public Student(String name, String student_number,
                   String major, String birthday, double gpa) throws IllegalArgumentException{
        this.name = name;
        this.student_number = student_number;
        this.birthday = birthday;
        this.major = major;
        this.gpa = gpa;
    }

    // getter methods

    public String getName(){
        return this.name;
    }

    public String getStudent_number(){
        return this.student_number;
    }

    public String getBirthday(){
        return this.birthday;
    }

    public String getMajor() {
        return this.major;
    }

    public double getGpa(){
        return this.gpa;
    }

    // setter methods

    public void setName(String name){
        this.name = name;
    }

    public void setStudent_number(String student_number){
        this.student_number = student_number;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    // helper methods

    /**
     * Helper method to check for a valid name
     * @param name - student name
     * @return boolean check for non-null name input
     */

    public static boolean isValidName(String name){
        return name != null && !name.isEmpty();
    }

    /**
     * Helper method to check for valid student number (exactly 9 digits)
     * @param id - student_number input
     * @return boolean check for 9 digit student number
     */

    public static boolean isValidStudentNumber(String id){
        return id.length() == 9;
    }

    /**
     * Helper method to check for valid major
     * @param major - students major of study
     * @return - boolean check for a valid major
     */

    public static boolean isValidMajor(String major){
        boolean valid = false;
        String [] acceptable_majors = {"CS", "CE", "SE", "AI", "COMP_SCI", "COMP_SEC", "FAST_FOOD"};

        for (String acceptableMajor : acceptable_majors) {
            if (acceptableMajor.equals(major.toUpperCase())) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    /**
     * Helper method to check for valid gpa
     * @param gpa - students gpa
     * @return boolean check gpa inside domain [0.0, 4.0]
     */

    public static boolean isValidGPA(double gpa){
        return gpa >= 0.0 && gpa <= 4.0;
    }

    /**
     * Method to print the desired information
     * @return - print statement of student name, student number, and probation status
     */

    @Override
    public String toString(){
        return name + " " + student_number + " " + isOnProbation();
    }

    /**
     * Checks probation status of student
     * implementation of this method must define the gpa threshold for
     * probation
     * @return boolean probation status for student
     */

    public abstract boolean isOnProbation();
}