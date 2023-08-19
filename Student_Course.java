import java.util.ArrayList;

public class Student_Course extends Student {

    private String enrollmentType = "C";
    // the enrollment type is "C" because this is a course unit
    public Unit_Course unit;

    public Student_Course() {
    }

    public Student_Course(String firstName, String lastName, long studentNumber, String unitID, int level, int assignment1Mark, int assignment2Mark, int finalExamMark) {
        super(firstName, lastName, studentNumber); // constructor of the superclass
        unit = new Unit_Course(unitID, level, assignment1Mark, assignment2Mark, finalExamMark);
        // this is the constructor of the subclass
    }
    
    @Override
    public String getUnitID() {
        return this.unit.getUnitID();
    }

    @Override
    public int getLevel() {
        return unit.getLevel();
    }

    @Override
    public int getOverallMark() {
        return unit.getOverallMark();
    }

    @Override
    public int getAssignment1Mark() {
        return unit.getAssignment1Mark();
    }

    @Override
    public int getAssignment2Mark() {
        return unit.getAssignment2Mark();
    }

    @Override
    public int getFinalExamMark() {
        return unit.getFinalExamMark();
    }


    @Override
    public String toString() {
        return "Student_Course{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", studentNumber=" + this.getStudentNumber() +
                ", enrollmentType='" + enrollmentType + '\'' +
                '}';
    }

    @Override
    public void reportGrade() {
        // this method is used to print the student's grade
        System.out.println("Enrollment Type: " + "C," + "\nFirst Name: "+ this.getFirstName() + "\nLast Name: " + this.getLastName() + "\n Student ID: " + this.getStudentNumber() + "\nUnit ID: " + this.getUnitID() + "\nOverall Marks: " + unit.getOverallMark() + "\nGrade: " + unit.reportGrade() + "\n\n");
    }
}
