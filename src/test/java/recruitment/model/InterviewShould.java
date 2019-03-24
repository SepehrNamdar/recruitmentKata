package recruitment.model;

import common.DateUtils;
import org.junit.jupiter.api.Test;
import recruitment.use_case.CandidateData;
import recruitment.use_case.RecruiterData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InterviewShould {

    @Test
    void find_the_first_available_recruiter() {
        Interview interview = new Interview();

        ArrayList<RecruiterData> recruiters = new ArrayList<>();
        RecruiterData availableRecruiter = new RecruiterData();
        List<LocalDateTime> availabilities = new ArrayList<>();
        availabilities.add(DateUtils.TODAY);
        availableRecruiter.setAvailabilities(availabilities);
        availableRecruiter.setId("132");
        availableRecruiter.setFirstName("Thomas");
        availableRecruiter.setLastName("DUPONT");
        recruiters.add(availableRecruiter);

        interview.plan(DateUtils.TODAY, new CandidateData(), recruiters);

        assertThat(interview.getRecruiterName()).isEqualTo("Thomas DUPONT");
    }

}