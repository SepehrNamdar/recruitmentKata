package recruitment.model;

import common.DateUtils;
import common.dto.RecruiterData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class InterviewDataFactory {

    static List<RecruiterData> getRecruiters() {
        ArrayList<RecruiterData> recruiters = new ArrayList<>();

        recruiters.addAll(getUnavailableRecruiters());
        recruiters.addAll(getAvailableRecruiters());

        return recruiters;
    }

    static List<RecruiterData> getUnavailableRecruiters() {
        ArrayList<RecruiterData> recruiters = new ArrayList<>();

        recruiters.add(anUnavailableRecruiter());

        return recruiters;
    }

    private static RecruiterData anUnavailableRecruiter() {
        RecruiterData availableRecruiter = new RecruiterData();

        List<LocalDateTime> availabilities = new ArrayList<>();
        availabilities.add(LocalDateTime.now().plusDays(1));
        availableRecruiter.setAvailabilities(availabilities);
        availableRecruiter.setId("132");
        availableRecruiter.setFirstName("Thomas");
        availableRecruiter.setLastName("DUPONT");

        return availableRecruiter;
    }

    static ArrayList<RecruiterData> getAvailableRecruiters() {
        ArrayList<RecruiterData> recruiters = new ArrayList<>();

        recruiters.add(firstAvailableRecruiter());
        recruiters.add(secondAvailableRecruiter());

        return recruiters;
    }

    private static RecruiterData firstAvailableRecruiter() {
        RecruiterData availableRecruiter = new RecruiterData();

        List<LocalDateTime> availabilities = new ArrayList<>();
        availabilities.add(DateUtils.TODAY);
        availableRecruiter.setAvailabilities(availabilities);
        availableRecruiter.setId("133");
        availableRecruiter.setFirstName("Antoine");
        availableRecruiter.setLastName("LEPERSE");

        return availableRecruiter;
    }

    private static RecruiterData secondAvailableRecruiter() {
        RecruiterData availableRecruiter = new RecruiterData();

        List<LocalDateTime> availabilities = new ArrayList<>();
        availabilities.add(DateUtils.TODAY);
        availableRecruiter.setAvailabilities(availabilities);
        availableRecruiter.setId("132");
        availableRecruiter.setFirstName("Thomas");
        availableRecruiter.setLastName("DUPONT");

        return availableRecruiter;
    }
}
