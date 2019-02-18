package recruitment.exposition;

public class PlannerRequest {

    private String interviewDay;
    private String candidateId;

    String getInterviewDay() {
        return interviewDay;
    }

    public void setInterviewDay(String interviewDay) {
        this.interviewDay = interviewDay;
    }

    String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
}
