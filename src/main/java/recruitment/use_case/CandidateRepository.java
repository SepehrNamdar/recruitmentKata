package recruitment.use_case;

import common.dto.CandidateData;

import java.util.UUID;

interface CandidateRepository {
    CandidateData findCandidateById(UUID candidateId);
}
