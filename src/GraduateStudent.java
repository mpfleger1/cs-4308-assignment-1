public class GraduateStudent extends Student{
    private String thesis_title;
    private String faculty_advisor;

    public GraduateStudent(String name, String student_number, String major, String birthday, double gpa, String thesis_title, String faculty_advisor) {
        super(name, student_number, birthday, major, gpa);
        this.faculty_advisor = faculty_advisor;
        this.thesis_title = thesis_title;
    }

    public String getFaculty_advisor() {
        return this.faculty_advisor;
    }

    public String getThesis_title(){
        return this.thesis_title;
    }

    public void setFaculty_advisor(String faculty_advisor){
        this.faculty_advisor = faculty_advisor;
    }

    public void setThesis_title(String thesis_title){
        this.thesis_title = thesis_title;
    }

    public static int getNumFields(){
        return 7;
    }

    @Override
    public boolean isOnProbation(){
        return this.gpa < 3.0;
    }
}
