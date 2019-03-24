package recruitment.model;

import common.DateUtils;
import recruitment.use_case.CandidateData;
import recruitment.use_case.RecruiterData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Interview {
    private String status = "unscheduled";
    private String recruiter;

    public void plan(
            LocalDateTime today, CandidateData javaCandidate, List<RecruiterData> recruiters) {

        // Mettre dans un Value Object Recruiter
        if(recruiters.isEmpty()) {
            throw new AnyRecruiterAvailableException();
        }

        Optional<RecruiterData> availableRecruiter = recruiters.stream()
                .filter(recruiterData -> recruiterData.getAvailabilities().contains(DateUtils.TODAY))
                .findFirst();

        if(!availableRecruiter.isPresent()) {
            throw new AnyRecruiterAvailableException();
        }
        // End

        status = "scheduled";
        recruiter = "Thomas DUPONT";
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
