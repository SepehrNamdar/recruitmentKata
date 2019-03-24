package recruitment.use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlanInterviewShould {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;
    private PlannerRequest request;
    private PlanInterview planInterview;

    @BeforeEach
    void init() {
        candidateRepository = mock(CandidateRepository.class);
        recruitersReferential = mock(RecruitersReferential.class);
        InterviewRepository interviewrepository = mock(InterviewRepository.class);

        request = new PlannerRequest();
        planInterview = new PlanInterview(candidateRepository, recruitersReferential, interviewrepository);
    }

    @Test
    void call_candidate_repository_to_find_candidate_by_candidate_id() {
        planInterview.plan(request);

        verify(candidateRepository).getCandidateById(request.getCandidateId());
    }

    @Test
    void call_recruiter_referential_to_find_recruiters_list() {
        planInterview.plan(request);

        verify(recruitersReferential).getRecruitersOfTheMonth();
    }

}
