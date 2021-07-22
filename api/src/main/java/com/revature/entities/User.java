package main.java.com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "users")
public class User
{
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    public User()
    {
    }

    public User(String username, int id, String password)
    {
        this.username = username;
        this.id = id;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String name)
    {
        this.username = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "User{" + "name='" + username + '\'' +
                       ", id=" + id +
                       '}';
    }
}