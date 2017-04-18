package com.api.domaine.Credentials;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialsForResetPass{


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("email")
    private String email;


    public CredentialsForResetPass(String email) {
        this.email = email;

    }



}
