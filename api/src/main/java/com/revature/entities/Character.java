package com.revature.entities;

import javax.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String name;
    private String description;
    private double strength;
    private double speed;
    private double health;
    private double armor;
    private double magic_damage;
    private double physical_damage;
    private double height;
    private double weight;

    public Character(String name, String description, double strength, double speed, double health, double armor,
                     double magic_damage, double physical_damage, double height, double weight, User user) {

        this.name = name;
        this.description = description;
        this.strength = strength;
        this.speed = speed;
        this.health = health;
        this.armor = armor;
        this.magic_damage = magic_damage;
        this.physical_damage = physical_damage;
        this.height = height;
        this.weight = weight;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getMagic_damage() {
        return magic_damage;
    }

    public void setMagic_damage(double magic_damage) {
        this.magic_damage = magic_damage;
    }

    public double getPhysical_damage() {
        return physical_damage;
    }

    public void setPhysical_damage(double physical_damage) {
        this.physical_damage = physical_damage;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", strength=" + strength +
                ", speed=" + speed +
                ", health=" + health +
                ", armor=" + armor +
                ", magic_damage=" + magic_damage +
                ", physical_damage=" + physical_damage +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
