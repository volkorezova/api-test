package com.api.domaine;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"_id", "username", "email", "firstName", "lastName", "accessLevel", "birthDate", "height", "weight", "client", "rosterPosition", "__v", "photo", "type", "neverUpdated"})
public class User {
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
    @JsonProperty("accessLevel")
    private Integer accessLevel;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("client")
    private String client;
    @JsonProperty("rosterPosition")
    private String rosterPosition;
    @JsonProperty("__v")
    private Integer v;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("type")
    private String type;
    @JsonProperty("neverUpdated")
    private Boolean neverUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public User() {
    }

    public User(String id, String username, String email, String firstName, String lastName, Integer accessLevel, String birthDate, Integer height, Integer weight, String client, String rosterPosition, Integer v, String photo, String type, Boolean neverUpdated) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessLevel = accessLevel;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.client = client;
        this.rosterPosition = rosterPosition;
        this.v = v;
        this.photo = photo;
        this.type = type;
        this.neverUpdated = neverUpdated;
    }

    @JsonProperty("_id")
    public String getId() {
        return this.id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return this.username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return this.firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return this.lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("accessLevel")
    public Integer getAccessLevel() {
        return this.accessLevel;
    }

    @JsonProperty("accessLevel")
    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return this.birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return this.height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return this.weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonProperty("client")
    public String getClient() {
        return this.client;
    }

    @JsonProperty("client")
    public void setClient(String client) {
        this.client = client;
    }

    @JsonProperty("rosterPosition")
    public String getRosterPosition() {
        return this.rosterPosition;
    }

    @JsonProperty("rosterPosition")
    public void setRosterPosition(String rosterPosition) {
        this.rosterPosition = rosterPosition;
    }

    @JsonProperty("__v")
    public Integer getV() {
        return this.v;
    }

    @JsonProperty("__v")
    public void setV(Integer v) {
        this.v = v;
    }

    @JsonProperty("photo")
    public String getPhoto() {
        return this.photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("neverUpdated")
    public Boolean getNeverUpdated() {
        return this.neverUpdated;
    }

    @JsonProperty("neverUpdated")
    public void setNeverUpdated(Boolean neverUpdated) {
        this.neverUpdated = neverUpdated;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accessLevel=" + accessLevel +
                ", birthDate='" + birthDate + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", client='" + client + '\'' +
                ", rosterPosition='" + rosterPosition + '\'' +
                ", v=" + v +
                ", photo='" + photo + '\'' +
                ", type='" + type + '\'' +
                ", neverUpdated=" + neverUpdated +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
