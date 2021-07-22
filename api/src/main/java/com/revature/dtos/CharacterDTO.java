package com.revature.dtos;

public class CharacterDTO
{
    private String name;
    private String email;

    public CharacterDTO(String name, String email)
    {
        this.name = name;
        this.email = email;
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

    @Override
    public String toString()
    {
        return "UserDTO{" +
                       "name='" + name + '\'' +
                       ", email='" + email + '\'' +
                       '}';
    }
}
