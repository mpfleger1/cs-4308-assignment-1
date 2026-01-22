
public abstract class Student {
    private String name;
    private String student_number;
    private String birthday;
    private String major;
    protected double gpa;
    /*
    constructor for Student
    @param name - name of the student
        @pre name is not null
    @param student_number - unique student identification number
        @pre student_number is not null and is exactly 9 digits long
    @param birthday - student birthday
    @param major - student major of study
        @pre major is one of the valid majors
    @param gpa - student grade point average
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
    public static boolean isValidName(String name){
        return name != null && !name.isEmpty();
    }

    public static boolean isValidStudentNumber(String id){
        return id.length() == 9;
    }

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

    public static boolean isValidGPA(double gpa){
        return gpa >= 0.0 && gpa <= 4.0;
    }

    @Override
    public String toString(){
        return name + " " + student_number + " " + isOnProbation();
    }

    public abstract boolean isOnProbation();
}