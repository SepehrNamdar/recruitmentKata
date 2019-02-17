package recruitment.exposition;

import common.DateUtils;
import common.ExceptionMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlannerShould {

    private RecruitmentPlannerImpl planner;
    private PlannerRequest interviewRequest;

    @BeforeEach
    public void init() {
        planner = new RecruitmentPlannerImpl();
        interviewRequest = new PlannerRequest();
    }

    @Test
    public void check_Request_is_not_empty() {
        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.EMPTY_REQUEST);
    }

    @Test
    public void check_candidateId_is_not_empty() {
        interviewRequest.setInterviewDay(String.valueOf(DateUtils.TODAY));

        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.EMPTY_REQUEST);
    }

    @Test
    public void check_request_date_is_not_empty() {
        interviewRequest.setCandidateId(String.valueOf(UUID.randomUUID()));

        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.EMPTY_REQUEST);
    }

    @Test
    public void check_request_date_format() {
        interviewRequest.setCandidateId(String.valueOf(UUID.randomUUID()));
        interviewRequest.setInterviewDay("bad-day-format");

        assertThatExceptionOfType(InvalidRequestException.class)
                .isThrownBy(() -> planner.plan(interviewRequest))
                .withMessage(ExceptionMessages.DATE_FORMAT);
    }
}
