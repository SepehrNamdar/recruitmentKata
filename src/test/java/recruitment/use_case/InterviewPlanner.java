package recruitment.use_case;

import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;
import recruitment.model.Interview;

class InterviewPlanner {
    private Interview interview;
    private CandidateRepository candidates;

    InterviewPlanner(Interview interview, CandidateRepository candidates) {
        this.interview = interview;
        this.candidates = candidates;
    }

    PlannerResponse scheduleInterview(PlannerRequest request) {
        candidates.findCandidateById(request.getCandidateId());
        interview.plan();
        return null;
    }
}
