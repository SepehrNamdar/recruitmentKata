package recruitment.use_case;

import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;
import recruitment.model.Interview;

import java.util.List;

class InterviewPlanner {
    private Interview interview;
    private CandidateRepository candidates;
    private RecruitersReferential recruitersReferential;

    InterviewPlanner(
            Interview interview,
            CandidateRepository candidates,
            RecruitersReferential recruitersReferential) {
        this.interview = interview;
        this.candidates = candidates;
        this.recruitersReferential = recruitersReferential;
    }

    PlannerResponse scheduleInterview(PlannerRequest request) {
        CandidateData javaCandidate = candidates.findCandidateById(request.getCandidateId());
        List<RecruiterData> recruiters = recruitersReferential.findCurrentMonthRecruiters();
        interview.plan(request.getDate(), javaCandidate, recruiters);
        return null;
    }
}
