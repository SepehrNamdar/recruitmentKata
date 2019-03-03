package recruitment.use_case;

public class PlanInterview {

    private CandidateRepository candidateRepository;

    public PlanInterview(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public void plan() {
        candidateRepository.getCandidateById();
    }
}
