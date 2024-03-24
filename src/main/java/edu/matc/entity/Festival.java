package edu.matc.entity;

import java.util.Date;

public class Festival {
    int festivalID;
    String festivalName;
    int regionID;
    int typeID;
    Date festivalStartDate;

    public Festival() {
    }

    public Festival(String festivalName, int regionID, int typeID, Date festivalStartDate) {
        this.festivalName = festivalName;
        this.regionID = regionID;
        this.typeID = typeID;
        this.festivalStartDate = festivalStartDate;
    }

    public int getFestivalID() {
        return festivalID;
    }

    public void setFestivalID(int festivalID) {
        this.festivalID = festivalID;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public Date getFestivalStartDate() {
        return festivalStartDate;
    }

    public void setFestivalStartDate(Date festivalStartDate) {
        this.festivalStartDate = festivalStartDate;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "festivalID=" + festivalID +
                ", festivalName='" + festivalName + '\'' +
                ", regionID=" + regionID +
                ", typeID=" + typeID +
                ", festivalStartDate=" + festivalStartDate +
                '}';
    }
}
