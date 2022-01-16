package com.epicwin.prohub.model.authentication;

import java.io.Serializable;

/**
 * Entity class for holding JWT token information.
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwtToken;
    private final User user;

    public JwtResponse(String jwtToken, User user) {
        this.jwtToken = jwtToken;
        this.user = user;
    }

    public String getJwtToken(){
        return this.jwtToken;
    }
}
