
package com.revature.services;

import com.revature.entities.User;
import com.revature.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }
}

