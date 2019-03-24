package recruitment;

import common.DateUtils;
import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;
import recruitment.exposition.RecruitmentPlannerImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class RecruitmentPlannerIT {

    private static final LocalDateTime TODAY = DateUtils.TODAY;
    private static final String RECRUITER = "Sepehr NAMDAR";
    private static final String CANDIDATE = "Ali DUPONT";

    @Test
    void should_plan_an_interview() {
        RecruitmentPlanner planner = new RecruitmentPlannerImpl();
        PlannerRequest request = newRequest();

        PlannerResponse response = planner.plan(request);

        assertThat(response.getRecruiter()).isEqualTo(RECRUITER);
        assertThat(response.getCandidate()).isEqualTo(CANDIDATE);
        assertThat(response.getDate()).isEqualTo(TODAY.format(DateUtils.FORMATTER));
    }

    private PlannerRequest newRequest() {
        PlannerRequest request = new PlannerRequest();

        request.setDate(TODAY);
        UUID candidateId = UUID.randomUUID();
        request.setCandidateId(candidateId);

        return request;
    }

}
