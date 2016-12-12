package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Vandorallen on 12/12/2016.
 * Character class. Its creation is the main goal of this application
 */
public class Character {

    private UUID id;

    private int force;
    private int intelligence;
    private int dexterity;
    private int wisdom;
    private int constitution;
    private int charisma;

    private Boolean genre;
    private int age;

    private Class aClass;
    private Species species;

    private List<Skill> skills;
    private List<Gift> gifts;
    private List<Equipment> equipments;

    /**
     * Constructor
     */
    public Character() {
        skills = new ArrayList<>();
        gifts = new ArrayList<>();
        equipments = new ArrayList<>();
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
     * @return current force
     */
    public int getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * @return current intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * @param intelligence the intelligence to set
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * @return current dexterity
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * @param dexterity the dexterity to set
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * @return current wisdom
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * @param wisdom the wisdom to set
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * @return current constitution
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * @param constitution the constitution to set
     */
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    /**
     * @return current charisma
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * @param charisma the charisma to set
     */
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    /**
     * @return current genre
     */
    public Boolean getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(Boolean genre) {
        this.genre = genre;
    }

    /**
     * @return current age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return current aClass
     */
    public Class getaClass() {
        return aClass;
    }

    /**
     * @param aClass the aClass to set
     */
    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    /**
     * @return current equipments
     */
    public List<Equipment> getEquipments() {
        return equipments;
    }

    /**
     * @param equipments the equipments to set
     */
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    /**
     * @return current species
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(Species species) {
        this.species = species;
    }

    /**
     * @return current skills
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * @return current gifts
     */
    public List<Gift> getGifts() {
        return gifts;
    }

    /**
     * @param gifts the gifts to set
     */
    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        return new EqualsBuilder()
                .append(getForce(), character.getForce())
                .append(getIntelligence(), character.getIntelligence())
                .append(getDexterity(), character.getDexterity())
                .append(getWisdom(), character.getWisdom())
                .append(getConstitution(), character.getConstitution())
                .append(getCharisma(), character.getCharisma())
                .append(getAge(), character.getAge())
                .append(getId(), character.getId())
                .append(getGenre(), character.getGenre())
                .append(getaClass(), character.getaClass())
                .append(getSpecies(), character.getSpecies())
                .append(getSkills(), character.getSkills())
                .append(getGifts(), character.getGifts())
                .append(getEquipments(), character.getEquipments())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getForce())
                .append(getIntelligence())
                .append(getDexterity())
                .append(getWisdom())
                .append(getConstitution())
                .append(getCharisma())
                .append(getGenre())
                .append(getAge())
                .append(getaClass())
                .append(getSpecies())
                .append(getSkills())
                .append(getGifts())
                .append(getEquipments())
                .toHashCode();
    }
}
