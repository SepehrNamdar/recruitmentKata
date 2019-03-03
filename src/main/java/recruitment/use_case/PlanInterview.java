package recruitment.use_case;

public class PlanInterview {

    private CandidateRepository candidateRepository;
    private RecruitersReferential recruitersReferential;

    public PlanInterview(CandidateRepository candidateRepository, RecruitersReferential recruitersReferential) {
        this.candidateRepository = candidateRepository;
        this.recruitersReferential = recruitersReferential;
    }

    public void plan() {
        candidateRepository.getCandidateById();
        recruitersReferential.getRecruitersOfTheMonth();
    }
}
