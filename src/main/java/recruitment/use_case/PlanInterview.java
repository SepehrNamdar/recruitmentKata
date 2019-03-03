package recruitment.use_case;

import recruitment.exposition.PlannerRequest;
import recruitment.model.Interview;

public class PlanInterview {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;

    public PlanInterview(CandidateRepository candidateRepository, RecruitersReferential recruitersReferential) {
        this.candidateRepository = candidateRepository;
        this.recruitersReferential = recruitersReferential;
    }

    public void plan(PlannerRequest request, Interview interview) {
        candidateRepository.getCandidateById(request.getCandidateId());
        recruitersReferential.getRecruitersOfTheMonth();

        interview.plan();
    }
}
