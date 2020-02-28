package recruitment.infra;

import common.DateUtils;
import recruitment.exposition.PlannerResponse;
import recruitment.model.Interviews;

import java.util.UUID;

public class InterviewsRepository implements Interviews {

    @Override
    public PlannerResponse getInterview(UUID candidateId) {
        return new PlannerResponse();
    }

}
