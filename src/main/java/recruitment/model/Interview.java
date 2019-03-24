package recruitment.model;

import common.DateUtils;
import recruitment.use_case.CandidateData;
import recruitment.use_case.RecruiterData;

import java.time.LocalDateTime;
import java.util.List;

public class Interview {
    private String status = "unscheduled";
    private String recruiter;

    public void plan(
            LocalDateTime requestedDate, CandidateData javaCandidate, List<RecruiterData> recruiters) {

        Recruiter recruiter = new Recruiter();
        recruiter.findAvailable(recruiters, requestedDate);

        status = "scheduled";
        this.recruiter = "Thomas DUPONT";
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return DateUtils.TODAY;
    }

    public String getCandidateName() {
        return null;
    }

    public String getRecruiterName() {
        return recruiter;
    }

}
