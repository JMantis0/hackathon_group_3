package main.java.com.revature.controllers;

import main.java.com.revature.dtos.LoginDTO;
import main.java.com.revature.entities.User;
import main.java.com.revature.exceptions.AuthorizationFailedException;
import main.java.com.revature.services.AuthService;
import main.java.com.revature.utilities.JWTUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class AuthController
{
    Logger logger = LoggerFactory.getLogger("root");
    private AuthService authService;
    private JWTUtility jwtUtility;

    public AuthController(AuthService authService, JWTUtility jwtUtility)
    {
        this.authService = authService;
        this.jwtUtility = jwtUtility;
    }

    @PostMapping(produces = "application/json")
    public LoginDTO processLogin(@RequestBody LoginDTO loginDTO, HttpServletResponse response)
    {
        logger.info("Login DTO: {}",loginDTO);
        return authService.authenticate(loginDTO,response);
    }

    @PostMapping("/test")
    public LoginDTO accessTest(@RequestBody LoginDTO messageDTO, HttpServletRequest request, HttpServletResponse response)
    {
        logger.info("Test received: {}", messageDTO);
        try
        {
            Optional<User> user = jwtUtility.parseToken(request, response);
            logger.info(user.toString());
            return new LoginDTO(user.get().getId(), user.get().getUsername(), user.get().getPassword(), "");
        } catch (AuthorizationFailedException e)
        {
            logger.warn("Authorization via token failed!");
            response.setStatus(401);
            return null;
        }
    }
}
