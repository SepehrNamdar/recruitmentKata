package recruitment.model;

import common.DateUtils;
import recruitment.use_case.CandidateData;
import recruitment.use_case.RecruiterData;

import java.time.LocalDateTime;
import java.util.List;

public class Interview {
    private String status = "unscheduled";

    public void plan(
            LocalDateTime today, CandidateData javaCandidate, List<RecruiterData> recruiters) {
        status = "scheduled";
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return DateUtils.TODAY;
    }
}
