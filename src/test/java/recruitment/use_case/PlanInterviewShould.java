package recruitment.use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlanInterviewShould {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;

    @BeforeEach
    void init() {
        candidateRepository = mock(CandidateRepository.class);
        recruitersReferential = mock(RecruitersReferential.class);
    }

    @Test
    void call_candidate_repository_to_find_candidate_by_candidate_id() {
        PlanInterview planInterview = new PlanInterview(candidateRepository, recruitersReferential);

        planInterview.plan();

        verify(candidateRepository).getCandidateById();
    }

    @Test
    void call_recruiter_referential_to_find_recruiters_list() {
        PlanInterview planInterview = new PlanInterview(candidateRepository, recruitersReferential);

        planInterview.plan();

        verify(recruitersReferential).getRecruitersOfTheMonth();
    }
}
