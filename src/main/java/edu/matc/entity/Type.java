package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * This class' purpose is to be the Javabean of type Type.
 */
@Entity
@Table(name="Type")
public class Type {

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int typeID;
    @Column(name = "type")
    private String type;

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
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeID=" + typeID +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        return typeID == type1.typeID && Objects.equals(type, type1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeID, type);
    }
}
