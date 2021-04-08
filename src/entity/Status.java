package entity;

import java.util.Date;

public class Status {
    private int statusId;
    private String status;
    private Date statusDate;

    public Status(int statusId, String status, Date statusDate){
        this.statusId = statusId;
        this.status = status;
        this.statusDate = statusDate;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
