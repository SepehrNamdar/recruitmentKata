package recruitment.model;

import recruitment.exposition.PlannerResponse;

import java.util.UUID;

public interface Interviews {

    PlannerResponse getInterview(UUID candidateId);

}
