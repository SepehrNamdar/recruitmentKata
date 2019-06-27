package recruitment.use_case;

import common.dto.RecruiterData;

import java.util.List;

interface RecruitersReferential {
    List<RecruiterData> findCurrentMonthRecruiters();
}
