import java.util.ArrayList;

public class Research extends Unit { // subclass of Unit 

    private String enrolmentType = "R";
    // the enrolment type is "R" because this is a research unit    
    private int proposalMark;
    private int dissertationMark;
    private int overallMark;
    private String finalGrade;

    public Research() {
    }

    public Research(int proposalMark, int dissertationMark) {
        super("R"); //   this is the constructor of the superclass
        // enrolmentType = "R" because this is a research unit
        this.proposalMark = proposalMark;
        this.dissertationMark = dissertationMark;
        calculateOverallMark();//  this method is used to calculate the overall mark using the weighed average of the proposal mark and the dissertation mark
        calculateFinalGrade(); // this method is used to calculate the final grade
    }

    public void calculateOverallMark() {
        overallMark = ((proposalMark*35)/100)+((dissertationMark*65)/100);
    }

    public int getProposalMark() {
        return proposalMark;
    }

    public void setProposalMark(int proposalMark) {
        this.proposalMark = proposalMark;
    }

    public int getOverallMark() {
        return overallMark;
    }

    public int getDissertationMark() {
        return dissertationMark;
    }

    public void setDissertationMark(int dissertationMark) {
        this.dissertationMark = dissertationMark;
    }

    @Override
    public String reportGrade() {
        return finalGrade;
    }

    public void calculateFinalGrade() {
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
    public String toString() {
        return "Research{" +
                ", enrolmentType='" + enrolmentType + '\'' +
                ", proposalMark=" + proposalMark +
                ", dissertationMark=" + dissertationMark +
                ", finalGrade='" + finalGrade + '\'' +
                '}';
    }
}
