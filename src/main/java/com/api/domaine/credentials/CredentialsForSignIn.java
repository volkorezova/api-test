package com.api.domaine.credentials;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CredentialsForSignIn {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("email")
        private String email;
        @JsonProperty("password")
        private String password;

        public CredentialsForSignIn(String email, String password) {
            this.email = email;
            this.password = password;
        }

}

