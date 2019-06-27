package common.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RecruiterData {
    private List<LocalDateTime> availabilities;
    private String firstName;
    private String lastName;

    public List<LocalDateTime> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<LocalDateTime> availabilities) {
        this.availabilities = availabilities;
    }

    public void setId(String s) {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
