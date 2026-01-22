import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class CLIStudentIO extends StudentIO{

    @Override
    public void displayStudent(Student std) throws IllegalArgumentException{
        if(std == null)
            throw new IllegalArgumentException("null domain.Employee argument in displayEmployee");
        System.out.println(std);
    }
    @Override
    public void displayAllStudents(List<Student> stds) throws IllegalArgumentException{
        System.out.println("NAME: STUDENT NUMBER: PROBATION:");
        System.out.println("*********************************");
        for (Student std : stds) displayStudent(std);
    }
}
