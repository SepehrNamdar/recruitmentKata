package recruitment;

import common.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;
import recruitment.exposition.RecruitmentPlannerImpl;
import recruitment.model.Interviews;
import recruitment.infra.InterviewsRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class RecruitmentPlannerIT {

    private static final LocalDateTime TODAY = DateUtils.TODAY;
    private static final String RECRUITER = "Sepehr NAMDAR";
    private static final String CANDIDATE = "Ali DUPONT";
    private static final UUID CANDIDATE_ID = UUID.randomUUID();

    Interviews interviews;

    @BeforeEach
    public void init() {
        interviews = new InterviewsRepository();
    }

    @Test
    public void should_plan_an_interview() {
        RecruitmentPlanner planner = new RecruitmentPlannerImpl();
        PlannerRequest request = new PlannerRequest(CANDIDATE_ID, TODAY);

        try {
            planner.plan(request);
        } catch (Exception e) {
            fail("Should not thrown any exception");
        }
    }

    @Test
    public void should_retrieve_a_planned_interview_for_a_candidate() {
        PlannerResponse response = interviews.getInterview(CANDIDATE_ID);

        assertThat(response.getRecruiter()).isEqualTo(RECRUITER);
        assertThat(response.getCandidate()).isEqualTo(CANDIDATE);
        assertThat(response.getDate()).isEqualTo(TODAY.format(DateUtils.FORMATTER));
    }

}
