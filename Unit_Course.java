import java.util.ArrayList;

public class Unit_Course extends Unit {

    private String unitID;
    private int level;
    private int assignment1Mark;
    private int assignment2Mark;
    private int finalExamMark;
    private String finalGrade;
    private int overallMark;

    public Unit_Course() {
    }

    public Unit_Course(String unitID, int level, int assignment1Mark, int assignment2Mark, int finalExamMark) {
        // constructor
        super("C"); // this is the constructor of the superclass
        // enrolmentType = "C" because this is a course unit
        this.unitID = unitID;
        this.level = level;
        this.assignment1Mark = assignment1Mark;
        this.assignment2Mark = assignment2Mark;
        this.finalExamMark = finalExamMark;
        calculateOverallMark();
        calculateFinalGrade();
    }

    // getters and setters

    public String getUnitID(){
        return unitID;
    }

    public void calculateOverallMark() { // this method is used to calculate the overall mark using the weighed average of the assignment marks and the final exam mark
        overallMark = ((assignment1Mark*25)/100)+((assignment2Mark*25)/100)+((finalExamMark*50)/100);
    }
    
    public int getLevel() {
        return level;
    }

    public int getAssignment1Mark() {
        return assignment1Mark;
    }

    public int getOverallMark() {
        return overallMark;
    }

    public void setAssignment1Mark(int assignment1Mark) {
        this.assignment1Mark = assignment1Mark;
    }

    public int getAssignment2Mark() {
        return assignment2Mark;
    }

    public void setAssignment2Mark(int assignment2Mark) {
        this.assignment2Mark = assignment2Mark;
    }

    public int getFinalExamMark() {
        return finalExamMark;
    }

    public void setFinalExamMark(int finalExamMark) {
        this.finalExamMark = finalExamMark;
    }

    @Override
    public String reportGrade() {
        return finalGrade;
    }

    public void calculateFinalGrade() { // this method is used to calculate the final grade

        if (overallMark >= 80) {
            finalGrade = "HD";
        } else if (overallMark >= 70) {
            finalGrade = "D";
        } else if (overallMark >= 60) {
            finalGrade = "C";
        } else if (overallMark >= 50) {
            finalGrade = "P";
        } else {
            finalGrade = "N";
        }
    }

    @Override
    public String toString() { // this method is used to print the object
        return "Unit_Course{" +
                "unitID='" + unitID + '\'' +
                ", level=" + level +
                ", enrolmentType='" + getEnrolmentType() + '\'' +
                ", assignment1Mark=" + assignment1Mark +
                ", assignment2Mark=" + assignment2Mark +
                ", finalExamMark=" + finalExamMark +
                ", finalGrade='" + finalGrade + '\'' +
                '}';
    }
}
