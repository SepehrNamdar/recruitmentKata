package recruitment.use_case;

import recruitment.exposition.PlannerRequest;

public class PlanInterview {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;

    public PlanInterview(CandidateRepository candidateRepository, RecruitersReferential recruitersReferential) {
        this.candidateRepository = candidateRepository;
        this.recruitersReferential = recruitersReferential;
    }

    public void plan(PlannerRequest request) {
        candidateRepository.getCandidateById();
        recruitersReferential.getRecruitersOfTheMonth();
    }
}
