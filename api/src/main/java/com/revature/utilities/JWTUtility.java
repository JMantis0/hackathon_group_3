package com.revature.utilities;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.revature.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Component
public class JWTUtility
{
    Logger logger = LoggerFactory.getLogger("root");
    private static final String ISSUER = "auth0";
    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;

    public JWTUtility()
    {
        this.algorithm = Algorithm.HMAC256("this-is-a-long-and-secure-secret-for-jwt-creation");
        this.jwtVerifier = JWT.require(algorithm).withIssuer(ISSUER).acceptLeeway(1).acceptExpiresAt(5).build();
    }

    public String getToken(User user)
    {
        try
        {
           return  JWT.create()
                                          .withIssuer(ISSUER)
                                          .withClaim("id", user.getId())
                                          .withClaim("username", user.getUsername())
                                          .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                                          .sign(algorithm);
        } catch (JWTCreationException e)
        {
            logger.warn("Invalid signing configuration");
            return null;
        }
    }
    public Optional<User> parseToken(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String token = request.getHeader("Authorization");
            if (token == null) throw new JWTVerificationException("No token present!");
            DecodedJWT jwt = JWT.decode(token.substring(7));
            jwtVerifier.verify(jwt);
            if(!jwt.getIssuer().equals(ISSUER)) throw new JWTVerificationException("Incorrect issuer");
            Map<String, Claim> claims = jwt.getClaims();
            if (claims.size() < 4) throw new JWTVerificationException("Incorrect claims");
            User user = new User(claims.get("username").asString(), "",claims.get("id").asInt());
            logger.info("Authorization succeeded for user: {}", user);
            return Optional.of(user);
        } catch (JWTVerificationException e)
        {
            logger.warn(e.getMessage());
            response.setStatus(401);
            response.addHeader("Error", e.getMessage());
            return Optional.empty();
        }

    }


}
