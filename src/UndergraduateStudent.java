public class UndergraduateStudent extends Student {
    private String classification;


    public UndergraduateStudent(String name, String student_number, String major, String birthday, double gpa, String classification) {
        super(name, student_number, birthday, major, gpa);
        this.classification = classification;
    }

    public String getClassification() {
        return this.classification;
    }

    public void setClassification(String classification){
        this.classification = classification;
    }

    public static int getNumFields(){
        return 6;
    }

    @Override
    public boolean isOnProbation(){
        return this.gpa < 2.0;
    }
}
