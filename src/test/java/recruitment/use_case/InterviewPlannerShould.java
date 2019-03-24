package recruitment.use_case;

import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

class InterviewPlannerShould {

    @Test
    void schedule_an_interview() {
        Interview interview = spy(new Interview());
        CandidateRepository candidates = mock(CandidateRepository.class);
        RecruitersReferential recruitersReferential = mock(RecruitersReferential.class);
        InterviewPlanner planner = new InterviewPlanner(interview, candidates, recruitersReferential);
        PlannerRequest request = new PlannerRequest();
        LocalDateTime today = LocalDateTime.now();
        request.setDate(today);
        CandidateData javaCandidate = new CandidateData();
        when(candidates.findCandidateById(request.getCandidateId())).thenReturn(javaCandidate);
        List<RecruiterData> recruiters = new ArrayList<>();
        when(recruitersReferential.findCurrentMonthRecruiters()).thenReturn(recruiters);

        planner.scheduleInterview(request);

        verify(interview).plan(today, javaCandidate, recruiters);
    }
}
