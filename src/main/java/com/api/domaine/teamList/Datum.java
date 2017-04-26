package com.api.domaine.teamList;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_id",
        "username",
        "email",
        "firstName",
        "lastName",
        "accessLevel",
        "birthDate",
        "height",
        "weight",
        "client",
        "rosterPosition",
        "__v",
        "type",
        "neverUpdated",
        "photo",
        "age"
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
    @JsonProperty("type")
    private String type;
    @JsonProperty("neverUpdated")
    private Boolean neverUpdated;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("age")
    private Integer age;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param lastName
     * @param weight
     * @param client
     * @param type
     * @param photo
     * @param accessLevel
     * @param neverUpdated
     * @param id
     * @param v
     * @param username
     * @param height
     * @param email
     * @param age
     * @param rosterPosition
     * @param birthDate
     * @param firstName
     */

    public Datum(String id, String username, String email, String firstName, String lastName, Integer accessLevel, String birthDate, Integer height, Integer weight, String client, String rosterPosition, Integer v, String type, Boolean neverUpdated, String photo, Integer age) {

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
        this.type = type;
        this.neverUpdated = neverUpdated;
        this.photo = photo;
        this.age = age;
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

    @JsonProperty("accessLevel")
    public Integer getAccessLevel() {
        return accessLevel;
    }

    @JsonProperty("accessLevel")
    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
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

    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
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
