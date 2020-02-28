package recruitment.exposition;

import java.time.LocalDateTime;
import java.util.UUID;

public class PlannerRequest {

    UUID candidateId;
    LocalDateTime today;

    public PlannerRequest(UUID candidateId, LocalDateTime date) {
        this.candidateId = candidateId;
        this.today = date;
    }

    public LocalDateTime getDate() {
        return today;
    }

    public UUID getCandidateId() {
        return candidateId;
    }
}
