package ac.cr.ucr.hoVim.model;

import jakarta.persistence.*;

@Entity
@Table(name= "tbVisit")

public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer visitId;

    private Integer patientId;
    private String status;
    private String date;

    public Visit() {

    }

    public Visit(Integer visitId, Integer patientId, String status, String date) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.status = status;
        this.date = date;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

