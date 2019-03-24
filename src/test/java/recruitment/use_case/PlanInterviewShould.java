package recruitment.use_case;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class PlanInterviewShould {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;
    private PlannerRequest request;
    private Interview interview;
    private InterviewRepository interviewrepository;

    @BeforeEach
    void init() {
        candidateRepository = mock(CandidateRepository.class);
        recruitersReferential = mock(RecruitersReferential.class);
        interview = spy(new Interview());
        interviewrepository = mock(InterviewRepository.class);

        request = new PlannerRequest();
        PlanInterview planInterview = new PlanInterview(candidateRepository, recruitersReferential, interviewrepository);

        planInterview.plan(request, interview);
    }

    @Test
    void call_candidate_repository_to_find_candidate_by_candidate_id() {
        verify(candidateRepository).getCandidateById(request.getCandidateId());
    }

    @Test
    void call_recruiter_referential_to_find_recruiters_list() {
        verify(recruitersReferential).getRecruitersOfTheMonth();
    }

    @Test
    void call_interview_aggregate() {
        verify(interview).plan();
    }

    @Test
    void call_interview_repository_to_add_new_interview() {
        verify(interviewrepository).add(interview);
    }

    @Test
    void return_a_scheduled_interview_when_interview_planned() {
         assertThat(interview.getStatus()).isEqualTo("scheduled");
    }
}
