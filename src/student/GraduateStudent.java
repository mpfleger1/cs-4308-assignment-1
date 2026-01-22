package student;

import bst.*;
import exception.*;
import io.*;

/**
 *
 * GraduateStudent class extends the Student class
 * GraduateStudent adds the faculty_advisor and the thesis_title variables
 *
 */

public class GraduateStudent extends Student{
    private String thesis_title;
    private String faculty_advisor;

    public GraduateStudent(String name, String student_number, String major, String birthday, double gpa, String thesis_title, String faculty_advisor) {
        super(name, student_number, birthday, major, gpa);
        this.faculty_advisor = faculty_advisor;
        this.thesis_title = thesis_title;
    }

    // getter methods

    public String getFaculty_advisor() {
        return this.faculty_advisor;
    }

    public String getThesis_title(){
        return this.thesis_title;
    }

    // setter methods

    public void setFaculty_advisor(String faculty_advisor){
        this.faculty_advisor = faculty_advisor;
    }

    public void setThesis_title(String thesis_title){
        this.thesis_title = thesis_title;
    }

    /**
     * Helper method for StudentIO class
     * @return 7 (the number of lines for graduate students in the input file)
     */

    public static int getNumFields(){
        return 7;
    }

    /**
     * Check for graduate student probation
     * @return boolean checking for graduate student probation (gpa less than 3.0)
     */

    @Override
    public boolean isOnProbation(){
        return this.gpa < 3.0;
    }

    /**
     * @param o the object to be compared.
     * @return integer of student number for comparison
     */

    @Override
    public int compareTo(Student o) { return Integer.parseInt(o.getStudent_number()); }
}
