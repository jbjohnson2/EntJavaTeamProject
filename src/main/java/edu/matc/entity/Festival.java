package edu.matc.entity;

import edu.matc.entity.Region;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


import java.time.LocalDate;


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
    private int festivalID;

    /**
     * The Festival name.
     */
    @Column(name = "festival_name")
    private String festivalName;


    /**
     * The Region
     */

    @Column(name="region_id")
    private int regionID;

    /**
     * The Type id.
     */

    @Column(name = "type_id")
    private int typeID;
    /**
     * The Festival start date.
     */
    @Column(name = "festival_start_date")
    private LocalDate festivalStartDate;

    /**
     * Instantiates a new Festival.
     */
    public Festival() {
    }

    /**
     * Instantiates a new Festival.
     *
     * @param festivalName      the festival name
     * @param regionID           the region id
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


    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
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
                ", region=" + regionID +
                ", typeID=" + typeID +
                ", festivalStartDate=" + festivalStartDate +
                '}';
    }
}
