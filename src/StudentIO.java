import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public abstract class StudentIO {

    public StudentIO(){}

    public List<Student> getStudents(String dataFileName, String errFileName) throws IllegalArgumentException, IOException
    {
        if (dataFileName == null)
            throw new IllegalArgumentException("null file name argument in getEmployees");
        List<Student> employees = new ArrayList<>();
        Scanner input = new Scanner(new File(dataFileName));
        FileWriter errFile = new FileWriter(errFileName);
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            try
            {
                Student e = getStudent(line);
                employees.add(e);
            }
            catch (FileFormatException e)
            {
                errFile.write(e.getMessage() + " " + line);
                errFile.write("\n");
            }
        }
        input.close();
        errFile.close();
        return employees;
    }

    private Student getStudent(String line) throws IllegalArgumentException, FileFormatException
    {
        if (line == null)
            throw new IllegalArgumentException("null line argument in io.CLIEmployeeIO.getEmployee");
        Student std = null;
        String[] tokens = line.split(" ");
        int numTokens = tokens.length;
        if (numTokens == UndergraduateStudent.getNumFields())
            std = getUndergraduateStudent(tokens);
        else if (numTokens == GraduateStudent.getNumFields())
            std = getGraduateStudent(tokens);
        else
            throw new FileFormatException("invalid number of fields in file");
        return std;
    }

    private Student getUndergraduateStudent(String[] tokens) throws IllegalArgumentException, FileFormatException
    {
        if (tokens == null)
            throw new IllegalArgumentException("null string argument int getUndergraduateStudent");
        if (tokens.length != UndergraduateStudent.getNumFields())
            throw new IllegalArgumentException("invalid number of fields in string array argument in getUndergraduateStudent");
        String name = tokens[0];
        if (!Student.isValidName(name))
            throw new FileFormatException("invalid name");
        String student_number = tokens[1];
        if (!Student.isValidStudentNumber(student_number))
            throw new FileFormatException("invalid student_number format in file");
        String major = tokens[2];
        if (!Student.isValidMajor(major))
            throw new FileFormatException("invalid major in file");
        String birthday = tokens[3];
        double gpa = Double.valueOf(tokens[4]);
        if (!Student.isValidGPA(gpa))
            throw new FileFormatException("invalid gpa in file");
        String classification = tokens[5];

        return new UndergraduateStudent(name, student_number, major, birthday, gpa, classification);
    }

    private Student getGraduateStudent(String[] tokens) throws IllegalArgumentException, FileFormatException
    {
        if (tokens == null)
            throw new IllegalArgumentException("null string argument int getGraduateStudent");
        if (tokens.length != GraduateStudent.getNumFields())
            throw new IllegalArgumentException("invalid number of fields in string array argument in getGraduateStudent");
        String name = tokens[0];
        if (!Student.isValidName(name))
            throw new FileFormatException("invalid name");
        String student_number = tokens[1];
        if (!Student.isValidStudentNumber(student_number))
            throw new FileFormatException("invalid student_number format in file");
        String major = tokens[2];
        if (!Student.isValidMajor(major))
            throw new FileFormatException("invalid major in file");
        String birthday = tokens[3];
        double gpa = Double.valueOf(tokens[4]);
        if (!Student.isValidGPA(gpa))
            throw new FileFormatException("invalid gpa in file");
        String faculty_advisor = tokens[5];
        String thesis_title = tokens[6];


        return new GraduateStudent(name, student_number, major, birthday, gpa, faculty_advisor, thesis_title);
    }

    public abstract void displayStudent(Student std) throws IllegalArgumentException;
    public abstract void displayAllStudents(List<Student> stds) throws IllegalArgumentException;


}
