package recruitment.model;

public class Interview {

    private String status = "unscheduled";

    public void plan() {
        status  = "scheduled";
    }

    public String getStatus() {
        return status;
    }
}
