package recruitment.use_case;

import common.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InterviewPlannerShould {
    @Spy Interview interview;
    @Mock CandidateRepository candidates;
    @Mock RecruitersReferential recruitersReferential;

    private static final LocalDateTime TODAY = DateUtils.TODAY;

    @Test
    void schedule_an_interview() {
        PlannerRequest request = createPlannerRequest();
        CandidateData javaCandidate = getCandidate(request);
        List<RecruiterData> recruiters = getRecruiters();

        InterviewPlanner planner = new InterviewPlanner(interview, candidates, recruitersReferential);
        planner.scheduleInterview(request);

        verify(interview).plan(TODAY, javaCandidate, recruiters);
    }

    private List<RecruiterData> getRecruiters() {
        List<RecruiterData> recruiters = new ArrayList<>();
        when(recruitersReferential.findCurrentMonthRecruiters()).thenReturn(recruiters);
        return recruiters;
    }

    private CandidateData getCandidate(PlannerRequest request) {
        CandidateData javaCandidate = new CandidateData();
        when(candidates.findCandidateById(request.getCandidateId())).thenReturn(javaCandidate);
        return javaCandidate;
    }

    private PlannerRequest createPlannerRequest() {
        PlannerRequest request = new PlannerRequest();
        request.setDate(TODAY);
        return request;
    }
}
