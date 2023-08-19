import java.util.*;

public class Student {

    private String firstName;
    private String lastName;
    private long studentNumber;

    public Student() {
    }

    public Student(String firstName, String lastName, long studentNumber) {
        // constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void reportGrade() {
        System.out.println("There is no grade here.");
    }

    public int getLevel() { // this method is used to get the level of the student
        if (this instanceof Student_Course) {
            return ((Student_Course) this).getLevel();
        } else {
            return 0;
        }
    }

    public String getUnitID() { // this method is used to get the unit ID of the student
        if (this instanceof Student_Course) {
            return ((Student_Course) this).getUnitID();
        } else {
            return "NA";
        }
    }

    public int getOverallMark() {
        return 0;
    }

    public boolean equals(Object o) {
        // this method is used to check if two students are the same
        // two students are the same if they have the same student number
        if (o instanceof Student) {
            Student otherStudent = (Student) o;
            return this.studentNumber == otherStudent.studentNumber;
        } else {
            return false;
        }
    }

    public int getAssignment1Mark() {
        if (this instanceof Student_Course) {
            return ((Student_Course) this).unit.getAssignment1Mark();
        } else {
            return 0;
        }
    }

    public int getAssignment2Mark() {
        if (this instanceof Student_Course) {
            return ((Student_Course) this).unit.getAssignment2Mark();
        } else {
            return 0;
        }
    }

    public int getFinalExamMark() {
        if (this instanceof Student_Course) {
            return ((Student_Course) this).unit.getFinalExamMark();
        } else {
            return 0;
        }
    }

    public int getProposalMark() {
        if (this instanceof Student_Research) {
            return ((Student_Research) this).unit.getProposalMark();
        } else {
            return 0;
        }
    }

    public int getDissertationMark() {
        if (this instanceof Student_Research) {
            return ((Student_Research) this).unit.getDissertationMark();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }

}
