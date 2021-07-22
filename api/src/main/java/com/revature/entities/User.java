package com.revature.entities;

import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User
{
    @Column
    private String name;

    @Column
    private String email;

    @Id
    @GeneratedValue
    private int id;

    public User()
    {
    }
    public User(int id){
        this.id = id;
    }
    public User(String name, String email, int id)
    {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
