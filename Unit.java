import java.util.ArrayList;

public abstract class Unit { // abstract class

    private String enrolmentType; // instance variable

    protected Unit() { // default constructor
    }

    public Unit(String enrolmentType) {
        this.enrolmentType = enrolmentType; // constructor
    }

    public String getEnrolmentType() {
        return enrolmentType;
    }

    public void setEnrolmentType(String enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    public String reportGrade() {
        return "NA";
    }
    
}
