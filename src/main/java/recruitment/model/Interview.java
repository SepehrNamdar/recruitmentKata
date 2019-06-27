package recruitment.model;

import common.DateUtils;
import common.dto.CandidateData;
import common.dto.RecruiterData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Interview {
    private String status = "unscheduled";
    private String recruiterName;

    public void plan(
            LocalDateTime requestedDate, CandidateData javaCandidate, List<RecruiterData> recruiters) {

        Recruiter recruiter = new Recruiter();
        List<RecruiterData> availableRecruiters = recruiter.findAvailable(recruiters, requestedDate);
        if(availableRecruiters.isEmpty()) {
            throw new AnyRecruiterAvailableException();
        }
        Optional<RecruiterData> firstAvailableRecruiter = availableRecruiters.stream().findFirst();
        recruiterName = firstAvailableRecruiter.get().getName();

        status = "scheduled";
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
        return recruiterName;
    }

}
