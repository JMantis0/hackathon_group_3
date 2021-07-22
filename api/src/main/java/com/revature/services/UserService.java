
package com.revature.services;

import com.revature.entities.User;
import com.revature.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }
}