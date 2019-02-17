package recruitment.exposition;

import common.DateUtils;
import common.ExceptionMessages;
import common.StringUtils;
import recruitment.RecruitmentPlanner;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RecruitmentPlannerImpl implements RecruitmentPlanner {
    @Override
    public PlannerResponse plan(PlannerRequest interviewRequest) {
        validateRequestParams(interviewRequest);
        validateInterviewDateFormat(interviewRequest);

        return new PlannerResponse();
    }

    private void validateInterviewDateFormat(PlannerRequest interviewRequest) {
        try {
            LocalDate.parse(interviewRequest.getInterviewDay(), DateUtils.FORMATTER);
        } catch (DateTimeParseException exception) {
            throw new InvalidRequestException(ExceptionMessages.DATE_FORMAT);
        }
    }

    private void validateRequestParams(PlannerRequest interviewRequest) {
        if (requestParametersAreEmpty(interviewRequest)) {
            throw new InvalidRequestException(ExceptionMessages.EMPTY_REQUEST);
        }
    }

    private boolean requestParametersAreEmpty(PlannerRequest interviewRequest) {
        return StringUtils.isNullOrEmpty(interviewRequest.getCandidateId()) ||
                StringUtils.isNullOrEmpty(interviewRequest.getInterviewDay());
    }

}
