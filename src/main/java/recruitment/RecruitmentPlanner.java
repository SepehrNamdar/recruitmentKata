package recruitment;

import recruitment.exposition.PlannerRequest;
import recruitment.exposition.PlannerResponse;

public interface RecruitmentPlanner {

    PlannerResponse plan(PlannerRequest request);

}
