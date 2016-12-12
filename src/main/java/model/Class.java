package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Vandorallen on 12/12/2016.
 * Class definition, Warrior, Wizard for example ...
 */
public class Class {
    private UUID id;
    private String name;
    private String description;
    private int skillsByLevel;
    private int bonusGift;

    private List<Skill> classSkills;

    public Class() {
        classSkills = new ArrayList<>();
    }

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
     * @return current skillsByLevel
     */
    public int getSkillsByLevel() {
        return skillsByLevel;
    }

    /**
     * @param skillsByLevel the skillsByLevel to set
     */
    public void setSkillsByLevel(int skillsByLevel) {
        this.skillsByLevel = skillsByLevel;
    }

    /**
     * @return current bonusGift
     */
    public int getBonusGift() {
        return bonusGift;
    }

    /**
     * @param bonusGift the bonusGift to set
     */
    public void setBonusGift(int bonusGift) {
        this.bonusGift = bonusGift;
    }

    /**
     * @return current classSkills
     */
    public List<Skill> getClassSkills() {
        return classSkills;
    }

    /**
     * @param classSkills the classSkills to set
     */
    public void setClassSkills(List<Skill> classSkills) {
        this.classSkills = classSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Class aClass = (Class) o;

        return new EqualsBuilder()
                .append(getSkillsByLevel(), aClass.getSkillsByLevel())
                .append(getBonusGift(), aClass.getBonusGift())
                .append(getId(), aClass.getId())
                .append(getName(), aClass.getName())
                .append(getDescription(), aClass.getDescription())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getName())
                .append(getDescription())
                .append(getSkillsByLevel())
                .append(getBonusGift())
                .toHashCode();
    }
}
