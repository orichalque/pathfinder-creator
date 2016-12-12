package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

/**
 * Created by Vandorallen on 12/12/2016.
 * Species definition
 */
public class Species {
    private UUID id;
    private String name;
    private String description;
    private String size;
    private String speed;
    private String vision;

    /**
     * @return current id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return current name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return current description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return current size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return current speed
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * @return current vision
     */
    public String getVision() {
        return vision;
    }

    /**
     * @param vision the vision to set
     */
    public void setVision(String vision) {
        this.vision = vision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Species species = (Species) o;

        return new EqualsBuilder()
                .append(getId(), species.getId())
                .append(getName(), species.getName())
                .append(getDescription(), species.getDescription())
                .append(getSize(), species.getSize())
                .append(getSpeed(), species.getSpeed())
                .append(getVision(), species.getVision())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getName())
                .append(getDescription())
                .append(getSize())
                .append(getSpeed())
                .append(getVision())
                .toHashCode();
    }
}
