package recruitment.use_case;

import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

public class PlanInterview {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;
    private InterviewRepository interviewRepository;

    public PlanInterview(
            CandidateRepository candidateRepository,
            RecruitersReferential recruitersReferential,
            InterviewRepository interviewRepository) {
        this.candidateRepository = candidateRepository;
        this.recruitersReferential = recruitersReferential;
        this.interviewRepository = interviewRepository;
    }

    public void plan(PlannerRequest request, Interview interview) {
        candidateRepository.getCandidateById(request.getCandidateId());
        recruitersReferential.getRecruitersOfTheMonth();

        interview.plan();

        interviewRepository.add(interview);
    }
}
