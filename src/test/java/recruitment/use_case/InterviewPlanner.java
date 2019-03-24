package recruitment.use_case;

import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;
import recruitment.model.Interview;

public class InterviewPlanner {
    private Interview interview;

    public InterviewPlanner(Interview interview) {
        this.interview = interview;
    }

    public PlannerResponse scheduleInterview(PlannerRequest request) {
        interview.plan();
        return null;
    }
}
