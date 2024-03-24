package edu.matc.entity;

/**
 * This class represents a type
 */
public class Type {
    private int typeID;

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Instantiates a new Type.
     */
    public Type() {
    }

    /**
     * Instantiates a new Type.
     *
     * @param type the type
     */
    public Type(String type) {
        this.type = type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    private String type;

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

    @Override
    public String toString() {
        return "Type{" +
                "typeID=" + typeID +
                ", type='" + type + '\'' +
                '}';
    }
}
