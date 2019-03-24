package recruitment.model;

import common.DateUtils;
import org.junit.jupiter.api.Test;
import recruitment.use_case.CandidateData;
import recruitment.use_case.RecruiterData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InterviewShould {

    @Test
    void find_an_available_recruiter() {
        Interview interview = new Interview();

        interview.plan(DateUtils.TODAY, new CandidateData(), getAvailableRecruiters());

        assertThat(interview.getRecruiterName()).isEqualTo("Thomas DUPONT");
    }

    @Test
    void throw_an_exception_when_any_available_recruiter_in_this_month() {
        Interview interview = new Interview();

        assertThatExceptionOfType(AnyRecruiterAvilableException.class)
                .isThrownBy(() -> {
                    interview.plan(DateUtils.TODAY, new CandidateData(), new ArrayList<>());
                });
    }

    @Test
    void throw_an_exception_when_any_available_recruiter_for_requested_date() {
        Interview interview = new Interview();
    }

    private ArrayList<RecruiterData> getAvailableRecruiters() {
        ArrayList<RecruiterData> recruiters = new ArrayList<>();

        recruiters.add(anAvailableRecruiter());

        return recruiters;
    }

    private RecruiterData anAvailableRecruiter() {
        RecruiterData availableRecruiter = new RecruiterData();

        List<LocalDateTime> availabilities = new ArrayList<>();
        availabilities.add(DateUtils.TODAY);
        availableRecruiter.setAvailabilities(availabilities);
        availableRecruiter.setId("132");
        availableRecruiter.setFirstName("Thomas");
        availableRecruiter.setLastName("DUPONT");

        return availableRecruiter;
    }

}