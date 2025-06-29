package ac.cr.ucr.hoVim.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaId;

    private String areaName;

    private int totalBeds;

    private int totalRooms;

    private String visitingRequirements;

    private String weekdayVisitingHours;

    private String weekendVisitingHours;

    public Area() {
    }

    public Area(Integer areaId, String areaName, Integer totalRooms, Integer totalBeds, String weekdayVisitingHours, String weekendVisitingHours, String visitingRequirements) {

        this.areaId = areaId;
        this.areaName = areaName;
        this.totalRooms = totalRooms;
        this.totalBeds = totalBeds;
        this.weekdayVisitingHours = weekdayVisitingHours;
        this.weekendVisitingHours = weekendVisitingHours;
        this.visitingRequirements = visitingRequirements;

    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Integer getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(Integer totalBeds) {
        this.totalBeds = totalBeds;
    }

    public String getWeekdayVisitingHours() {
        return weekdayVisitingHours;
    }

    public void setWeekdayVisitingHours(String weekdayVisitingHours) {
        this.weekdayVisitingHours = weekdayVisitingHours;
    }

    public String getWeekendVisitingHours() {
        return weekendVisitingHours;
    }

    public void setWeekendVisitingHours(String weekendVisitingHours) {
        this.weekendVisitingHours = weekendVisitingHours;
    }

    public String getVisitingRequirements() {
        return visitingRequirements;
    }

    public void setVisitingRequirements(String visitingRequirements) {
        this.visitingRequirements = visitingRequirements;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", totalRooms=" + totalRooms +
                ", totalBeds=" + totalBeds +
                ", weekdayVisitingHours='" + weekdayVisitingHours + '\'' +
                ", weekendVisitingHours='" + weekendVisitingHours + '\'' +
                ", visitingRequirements='" + visitingRequirements + '\'' +
                '}';
    }
}
