package recruitment.use_case;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

public class InterviewPlannerShould {

    @Test
    public void schedule_an_interview() {
        Interview interview = Mockito.spy(new Interview());
        InterviewPlanner planner = new InterviewPlanner(interview);

        PlannerRequest request = new PlannerRequest();
        planner.scheduleInterview(request);

        Mockito.verify(interview).plan();
    }
}
