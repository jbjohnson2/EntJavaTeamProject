package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


import javax.ejb.Local;
import java.time.LocalDate;
import java.util.Date;


/**
 * The type Festival.
 */
@Entity
@Table(name="Festival")
public class Festival {
    /**
     * The Festival id.
     */
    @Id
    @Column(name = "festival_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    int festivalID;

    /**
     * The Festival name.
     */
    @Column(name = "festival_name")
    String festivalName;

    /**
     * The Region id.
     */
    @Column(name = "region_id")
    int regionID;

    /**
     * The Type id.
     */
    @Column(name = "type_id")
    int typeID;
    /**
     * The Festival start date.
     */
    @Column(name = "festival_start_date")
    LocalDate festivalStartDate;

    /**
     * Instantiates a new Festival.
     */
    public Festival() {
    }

    /**
     * Instantiates a new Festival.
     *
     * @param festivalName      the festival name
     * @param regionID          the region id
     * @param typeID            the type id
     * @param festivalStartDate the festival start date
     */
    public Festival(String festivalName, int regionID, int typeID, LocalDate festivalStartDate) {
        this.festivalName = festivalName;
        this.regionID = regionID;
        this.typeID = typeID;
        this.festivalStartDate = festivalStartDate;
    }

    /**
     * Gets festival id.
     *
     * @return the festival id
     */
    public int getFestivalID() {
        return festivalID;
    }

    /**
     * Sets festival id.
     *
     * @param festivalID the festival id
     */
    public void setFestivalID(int festivalID) {
        this.festivalID = festivalID;
    }

    /**
     * Gets festival name.
     *
     * @return the festival name
     */
    public String getFestivalName() {
        return festivalName;
    }

    /**
     * Sets festival name.
     *
     * @param festivalName the festival name
     */
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    /**
     * Gets region id.
     *
     * @return the region id
     */
    public int getRegionID() {
        return regionID;
    }

    /**
     * Sets region id.
     *
     * @param regionID the region id
     */
    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    /**
     * Gets type id.
     *
     * @return the type id
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Sets type id.
     *
     * @param typeID the type id
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    /**
     * Gets festival start date.
     *
     * @return the festival start date
     */
    public LocalDate getFestivalStartDate() {
        return festivalStartDate;
    }

    /**
     * Sets festival start date.
     *
     * @param festivalStartDate the festival start date
     */
    public void setFestivalStartDate(LocalDate festivalStartDate) {
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
