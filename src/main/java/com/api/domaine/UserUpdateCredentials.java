package com.api.domaine;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tatyanavolkorezova on 12.04.17.
 */
public class UserUpdateCredentials {


        @JsonInclude(JsonInclude.Include.NON_NULL)

        @JsonProperty("neverUpdated")
        private Boolean neverUpdated;

    public UserUpdateCredentials(Boolean neverUpdated) {
        this.neverUpdated = neverUpdated;
    }
}






