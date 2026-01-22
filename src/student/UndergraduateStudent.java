package student;

import bst.*;
import exception.*;
import io.*;

/**
 *
 * UndergraduateStudent class extends Student class
 * UndergraduateStudent adds the classification variable which represents their class seniority (freshman, sophomore, junior, senior)
 *
 */

public class UndergraduateStudent extends Student {
    private String classification;


    public UndergraduateStudent(String name, String student_number, String major, String birthday, double gpa, String classification) {
        super(name, student_number, birthday, major, gpa);
        this.classification = classification;
    }

    // getter method

    public String getClassification() {
        return this.classification;
    }

    // setter method

    public void setClassification(String classification){
        this.classification = classification;
    }

    /**
     * Helper method for StudentIO class
     * @return 6 (the number of lines for graduate students in the input file)
     */

    public static int getNumFields(){
        return 6;
    }

    /**
     * Check for undergraduate student probation
     * @return boolean checking for undergraduate student probation (gpa less than 3.0)
     */

    @Override
    public boolean isOnProbation(){
        return this.gpa < 2.0;
    }

    /**
     * @param o the object to be compared.
     * @return integer of student number for comparison
     */

    @Override
    public int compareTo(Student o) { return Integer.parseInt(o.getStudent_number()); }
}
