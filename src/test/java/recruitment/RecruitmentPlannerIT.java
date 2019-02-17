package recruitment;

import common.DateUtils;
import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;
import recruitment.exposition.RecruitmentPlannerImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentPlannerIT {

    private static final LocalDateTime TODAY = DateUtils.TODAY;
    private static final String TODAY_FORMATTED = TODAY.format(DateUtils.FORMATTER);
    private static final String RECRUITER = "Sepehr NAMDAR";
    private static final String CANDIDATE = "Ali DUPONT";

    @Test
    public void should_plan_an_interview() {
        RecruitmentPlanner planner = new RecruitmentPlannerImpl();
        PlannerRequest request = createPlannerRequest();

        PlannerResponse response = planner.plan(request);

        assertThat(response.getRecruiter()).isEqualTo(RECRUITER);
        assertThat(response.getCandidate()).isEqualTo(CANDIDATE);
        assertThat(response.getDate()).isEqualTo(TODAY_FORMATTED);
    }

    private PlannerRequest createPlannerRequest() {
        PlannerRequest request = newRequest();
        request.setInterviewDay(String.valueOf(TODAY_FORMATTED));
        request.setCandidateId(String.valueOf(UUID.randomUUID()));
        return request;
    }

    private PlannerRequest newRequest() {
        PlannerRequest request = new PlannerRequest();

        request.setInterviewDay(String.valueOf(TODAY));
        request.setCandidateId(String.valueOf(UUID.randomUUID()));

        return request;
    }

}
