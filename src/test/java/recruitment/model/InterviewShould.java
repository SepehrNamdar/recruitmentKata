package recruitment.model;

import common.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recruitment.use_case.CandidateData;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InterviewShould {

    private static final LocalDateTime TODAY = DateUtils.TODAY;

    private Interview interview;

    @BeforeEach
    void init() {
        interview = new Interview();
    }

    @Test
    void find_an_available_recruiter() {
        interview.plan(
                TODAY, new CandidateData(), InterviewDataFactory.getAvailableRecruiters());

        assertThat(interview.getRecruiterName()).isEqualTo("Antoine LEPERSE");
    }

    @Test
    void find_an_available_recruiter_between_many_recruiters() {
        interview.plan(TODAY, new CandidateData(), InterviewDataFactory.getRecruiters());

        assertThat(interview.getRecruiterName()).isEqualTo("Antoine LEPERSE");
    }

    @Test
    void throw_an_exception_when_any_available_recruiter_in_this_month() {
        assertThatExceptionOfType(AnyRecruiterAvailableException.class)
                .isThrownBy(() ->
                        interview.plan(TODAY, new CandidateData(), new ArrayList<>()));
    }

    @Test
    void throw_an_exception_when_any_available_recruiter_for_requested_date() {
        assertThatExceptionOfType(AnyRecruiterAvailableException.class)
                .isThrownBy(() ->
                        interview.plan(
                                TODAY, new CandidateData(), InterviewDataFactory.getUnavailableRecruiters()));
    }

}