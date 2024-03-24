package edu.matc.entity;

/**
 * class represents a  region.
 */
public class Region {

    private int regionID;
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
}
