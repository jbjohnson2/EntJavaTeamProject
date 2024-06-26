package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * This class' purpose is to be the Javabean of type Region.
 */
@Entity
@Table(name="Region")
public class Region {

    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int regionID;
    @Column (name = "region_name")
    private String regionName;

    /**
     * Instantiates a new Region.
     */
    public Region() {
    }

    /**
     * Instantiates a new Region.
     *
     * @param regionName the region name
     */
    public Region(String regionName) {
        this.regionName = regionName;
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
     * Gets region name.
     *
     * @return the region name
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * Sets region name.
     *
     * @param regionName the region name
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionID=" + regionID +
                ", regionName='" + regionName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionID == region.regionID && Objects.equals(regionName, region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionID, regionName);
    }
}
