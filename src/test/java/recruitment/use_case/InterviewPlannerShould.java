package recruitment.use_case;

import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

import static org.mockito.Mockito.*;

class InterviewPlannerShould {

    @Test
    void schedule_an_interview() {
        Interview interview = spy(new Interview());
        CandidateRepository candidates = mock(CandidateRepository.class);
        InterviewPlanner planner = new InterviewPlanner(interview, candidates);

        PlannerRequest request = new PlannerRequest();
        CandidateData javaCandidate = new CandidateData();
        when(candidates.findCandidateById(request.getCandidateId())).thenReturn(javaCandidate);
        planner.scheduleInterview(request);

        verify(interview).plan(javaCandidate);
    }
}
