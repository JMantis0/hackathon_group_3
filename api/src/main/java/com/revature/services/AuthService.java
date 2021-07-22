package main.java.com.revature.services;

import main.java.com.revature.dtos.LoginDTO;
import main.java.com.revature.entities.User;
import main.java.com.revature.exceptions.UserNotFoundException;
import main.java.com.revature.repos.UserRepository;
import main.java.com.revature.utilities.JWTUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class AuthService
{
    Logger logger = LoggerFactory.getLogger("root");

    private final UserRepository repository;
    private final JWTUtility jwtUtility;

    public AuthService(UserRepository repository, JWTUtility jwtUtility)
    {
        this.repository = repository;
        this.jwtUtility = jwtUtility;
    }

    public LoginDTO authenticate(LoginDTO credentials, HttpServletResponse response)
    {
        Optional<User> user = repository.getByUsername(credentials.getUsername());
        try
        {
            if(user.orElseThrow(UserNotFoundException::new).getPassword().equals(credentials.getPassword()))
            {
                String token = jwtUtility.getToken(user.get());
                logger.info("{} successfully authenticated. Token: {} was created and delivered.", user.get(),token);
                //user.get().setToken(token);
                credentials.setId(user.get().getId());
                credentials.setToken(token);
                return credentials;
            } else
            {
                logger.warn("Authentication failed due to incorrect password. username: {}, password: {}", credentials.getUsername(),credentials.getPassword());
                response.setStatus(401);
                response.addHeader("Error", "Authentication failed due to incorrect password.");
                return null;
            }
        } catch (UserNotFoundException e)
        {
            logger.warn(e.getMessage());
            response.setStatus(404);
            response.addHeader("Error", "Username not found.");
            return null;
        }
    }
}
