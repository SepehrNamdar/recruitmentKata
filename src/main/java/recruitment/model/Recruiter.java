package recruitment.model;

import common.dto.RecruiterData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

class Recruiter {
    List<RecruiterData> findAvailable(List<RecruiterData> recruiters, LocalDateTime requestedDate) {
        if(recruiters.isEmpty()) {
            throw new AnyRecruiterAvailableException();
        }

        return recruiters.stream()
                .filter(recruiterData -> recruiterData.getAvailabilities().contains(requestedDate))
                .collect(Collectors.toList());
    }
}
