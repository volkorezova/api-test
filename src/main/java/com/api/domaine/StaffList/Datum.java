package com.api.domaine.StaffList;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_id",
        "username",
        "email",
        "firstName",
        "lastName",
        "client",
        "rosterPosition",
        "__v",
        "accessLevel",
        "phoneNumber",
        "photo",
        "type",
        "neverUpdated",
        "role"
})
public class Datum {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("client")
    private String client;
    @JsonProperty("rosterPosition")
    private String rosterPosition;
    @JsonProperty("__v")
    private Integer v;
    @JsonProperty("accessLevel")
    private Integer accessLevel;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("type")
    private String type;
    @JsonProperty("neverUpdated")
    private Boolean neverUpdated;
    @JsonProperty("role")
    private String role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Datum() {
    }

    /**
     * @param id
     * @param v
     * @param lastName
     * @param username
     * @param phoneNumber
     * @param client
     * @param email
     * @param rosterPosition
     * @param role
     * @param type
     * @param firstName
     * @param photo
     * @param accessLevel
     * @param neverUpdated
     */
    public Datum(String id, String username, String email, String firstName, String lastName, String client, String rosterPosition, Integer v, Integer accessLevel, String phoneNumber, String photo, String type, Boolean neverUpdated, String role) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.client = client;
        this.rosterPosition = rosterPosition;
        this.v = v;
        this.accessLevel = accessLevel;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
        this.type = type;
        this.neverUpdated = neverUpdated;
        this.role = role;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("client")
    public String getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(String client) {
        this.client = client;
    }

    @JsonProperty("rosterPosition")
    public String getRosterPosition() {
        return rosterPosition;
    }

    @JsonProperty("rosterPosition")
    public void setRosterPosition(String rosterPosition) {
        this.rosterPosition = rosterPosition;
    }

    @JsonProperty("__v")
    public Integer getV() {
        return v;
    }

    @JsonProperty("__v")
    public void setV(Integer v) {
        this.v = v;
    }

    @JsonProperty("accessLevel")
    public Integer getAccessLevel() {
        return accessLevel;
    }

    @JsonProperty("accessLevel")
    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("neverUpdated")
    public Boolean getNeverUpdated() {
        return neverUpdated;
    }

    @JsonProperty("neverUpdated")
    public void setNeverUpdated(Boolean neverUpdated) {
        this.neverUpdated = neverUpdated;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
