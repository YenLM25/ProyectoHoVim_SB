package ac.cr.ucr.hoVim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tbVisit")

public class Visit {
    @Id
    private Integer patientId;
    private Integer visitId;
    private String status;
    private String date;

    public Visit() {
    }

    public Visit(Integer patientId, Integer visitId, String status, String date) {
        this.patientId = patientId;
        this.visitId = visitId;
        this.status = status;
        this.date = date;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
