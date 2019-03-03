package recruitment.exposition;

import common.DateUtils;
import common.ExceptionMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recruitment.model.Interview;
import recruitment.use_case.PlanInterview;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlannerShould {

    private static final String CANDIDATE_ID = String.valueOf(UUID.randomUUID());
    private static final String TODAY = DateUtils.TODAY;

    private PlanInterview planInterview;
    private RecruitmentPlannerImpl planner;
    private PlannerRequest interviewRequest;
    private Interview interview;

    @BeforeEach
    void init() {
        planInterview = mock(PlanInterview.class);
        interview = new Interview();
        planner = new RecruitmentPlannerImpl(planInterview, interview);
        interviewRequest = new PlannerRequest();
    }

    @Test
    void check_Request_is_not_empty() {
        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.EMPTY_REQUEST);
    }

    @Test
    void check_candidateId_is_not_empty() {
        interviewRequest.setInterviewDay(TODAY);

        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.EMPTY_REQUEST);
    }

    @Test
    void check_request_date_is_not_empty() {
        interviewRequest.setCandidateId(CANDIDATE_ID);

        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.EMPTY_REQUEST);
    }

    @Test
    void check_request_date_format() {
        interviewRequest.setCandidateId(CANDIDATE_ID);
        interviewRequest.setInterviewDay("bad-day-format");

        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.DATE_FORMAT);
    }

    @Test
    void call_plan_interview_use_case() {
        interviewRequest.setCandidateId(CANDIDATE_ID);
        interviewRequest.setInterviewDay(TODAY);

        planner.plan(interviewRequest);

        verify(planInterview).plan(interviewRequest, interview);
    }
}