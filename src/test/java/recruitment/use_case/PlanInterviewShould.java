package recruitment.use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlanInterviewShould {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;
    private PlannerRequest request;
    private PlanInterview planInterview;
    private Interview interview;

    @BeforeEach
    void init() {
        candidateRepository = mock(CandidateRepository.class);
        recruitersReferential = mock(RecruitersReferential.class);
        interview = mock(Interview.class);

        request = new PlannerRequest();
        planInterview = new PlanInterview(candidateRepository, recruitersReferential);
    }

    @Test
    void call_candidate_repository_to_find_candidate_by_candidate_id() {
        planInterview.plan(request, interview);

        verify(candidateRepository).getCandidateById(request.getCandidateId());
    }

    @Test
    void call_recruiter_referential_to_find_recruiters_list() {
        planInterview.plan(request, interview);

        verify(recruitersReferential).getRecruitersOfTheMonth();
    }

    @Test
    void call_interview_aggregate() {
        planInterview.plan(request, interview);

        verify(interview).plan();
    }
}
