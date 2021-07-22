package com.revature.entities;

import javax.persistence.*;

@Entity
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    private String name;
    private double luck;
    private double strength;
    private double speed;
    private double health;
    private double armor;
    private double magic_damage;
    private double physical_damage;
    private double height;
    private double weight;

    public CharacterEntity(String name, double luck, double strength, double speed, double health, double armor,
                           double magic_damage, double physical_damage, double height, double weight, User user) {

        this.name = name;
        this.luck = luck;
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

    public CharacterEntity()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLuck() { return luck; }

    public void setLuck(double luck) { this.luck = luck; }

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

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", luck=" + luck +
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
