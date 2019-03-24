package recruitment.exposition;

import java.time.LocalDateTime;
import java.util.UUID;

public class PlannerRequest {

    private LocalDateTime date;

    private UUID candidateId;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public UUID getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(UUID candidateId) {
        this.candidateId = candidateId;
    }
}
