package main.java.com.revature.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "user")
    private Set<Character> characters;

    public User() {    }

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

    public Set<Character> getCharacters()
    {
        return characters;
    }

    public void setCharacters(Set<Character> characters)
    {
        this.characters = characters;
    }

    @Override
    public String toString()
    {
        return "User{" +
                       "id=" + id +
                       ", username='" + username + '\'' +
                       ", password='" + password + '\'' +
                       ", characters=" + characters +
                       '}';
    }
}