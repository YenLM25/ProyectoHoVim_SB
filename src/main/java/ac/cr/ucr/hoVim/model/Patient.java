package ac.cr.ucr.hoVim.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    private String patientName;
    private String area;
    private Integer floorNumber;
    private Integer rooms;
    private Integer bedNumber;

    public Patient() {
        this.patientId = 0;
    }

    public Patient(Integer patientId, String patientName, String area, Integer floorNumber, Integer rooms, Integer bedNumber) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.area = area;
        this.floorNumber = floorNumber;
        this.rooms = rooms;
        this.bedNumber = bedNumber;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }
}