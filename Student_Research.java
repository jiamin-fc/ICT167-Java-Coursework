import java.util.ArrayList;

public class Student_Research extends Student {

    private String enrollmentType = "R"; // instance variable
    // the enrollment type is "R" because this is a research unit
    public Research unit;

    public Student_Research() {
    }

    public Student_Research(String firstName, String lastName, long studentNumber, int proposalMark, int dissertationMark) {
        super(firstName, lastName, studentNumber);
        unit = new Research(proposalMark, dissertationMark);
    }

    @Override
    public int getOverallMark() {
        return unit.getOverallMark();
    }

    @Override
    public int getProposalMark() {
        return unit.getProposalMark();
    }

    @Override
    public int getDissertationMark() {
        return unit.getDissertationMark();
    }

    @Override
    public String toString() {
        return "Student_Research{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", studentNumber=" + this.getStudentNumber() + 
                ", enrollmentType='" + enrollmentType + '\'' +
                '}';
    }

    @Override
    public void reportGrade() { 
        // this method is used to print the student's grade
        System.out.println("\nEnrollment Type: R" + "\nFirst Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() + "\nStudent ID: " + this.getStudentNumber() + "\nOverall Marks: " + unit.getOverallMark() + "\nGrade: " + unit.reportGrade()+"\n");
    }
}
