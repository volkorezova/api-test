package com.api.domaine;


import com.api.domaine.ResetPassword.DataResetPass;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "data"
})
public class ResetPass {

    @JsonProperty("code")
    private String code;
    @JsonProperty("data")
    private DataResetPass data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public ResetPass() {
    }

    /**
     *
     * @param data
     * @param code
     */
    public ResetPass(String code, DataResetPass data) {
        super();
        this.code = code;
        this.data = data;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("data")
    public DataResetPass getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(DataResetPass data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}