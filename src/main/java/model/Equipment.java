package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

/**
 * Created by Vandorallen on 12/12/2016.
 * Equipment class definition. Characters own a stack of equipment they have to buy at the beginning of an adventure
 */
public class Equipment {
    private UUID id;
    private String name;
    private String description;
    private int price;

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
     * @return current price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        return new EqualsBuilder()
                .append(getPrice(), equipment.getPrice())
                .append(getId(), equipment.getId())
                .append(getName(), equipment.getName())
                .append(getDescription(), equipment.getDescription())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getName())
                .append(getDescription())
                .append(getPrice())
                .toHashCode();
    }
}
