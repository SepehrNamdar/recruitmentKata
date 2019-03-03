package recruitment;

import common.DateUtils;
import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;
import recruitment.exposition.RecruitmentPlannerImpl;
import recruitment.infra.CandidateRepositoryImpl;
import recruitment.model.Interview;
import recruitment.use_case.PlanInterview;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class RecruitmentPlannerIT {

    private static final String RECRUITER = "Sepehr NAMDAR";
    private static final String CANDIDATE = "Ali DUPONT";
    private static final String TODAY = DateUtils.TODAY;
    private static final String CANDIDATE_ID = String.valueOf(UUID.randomUUID());

    @Test
    void should_plan_an_interview() {
        RecruitmentPlanner planner = new RecruitmentPlannerImpl(
                new PlanInterview(new CandidateRepositoryImpl(), new RecruitersReferentialImpl()),
                new Interview());
        PlannerRequest request = createPlannerRequest();

        PlannerResponse response = planner.plan(request);

        assertThat(response.getRecruiter()).isEqualTo(RECRUITER);
        assertThat(response.getCandidate()).isEqualTo(CANDIDATE);
        assertThat(response.getDate()).isEqualTo(TODAY);
    }

    private PlannerRequest createPlannerRequest() {
        PlannerRequest request = new PlannerRequest();
        request.setInterviewDay(TODAY);
        request.setCandidateId(CANDIDATE_ID);
        return request;
    }
}
