package recruitment.use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlanInterviewShould {

    private CandidateRepository candidateRepository;

    @BeforeEach
    void init() {
        candidateRepository = mock(CandidateRepository.class);
    }

    @Test
    void call_candidate_repository_to_find_candidate_by_candidate_id() {
        PlanInterview planInterview = new PlanInterview(candidateRepository);

        planInterview.plan();

        verify(candidateRepository).getCandidateById();
    }

}
