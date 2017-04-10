package com.api.domaine;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"token", "user", "team", "rosterPositions"})
public class CurrentUser {
    @JsonProperty("token")
    private String token;
    @JsonProperty("user")
    private User user;
    @JsonProperty("team")
    private Team team;
    @JsonProperty("rosterPositions")
    private List<String> rosterPositions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public CurrentUser() {
    }

    public CurrentUser(String token, User user, Team team, List<String> rosterPositions) {
        this.token = token;
        this.user = user;
        this.team = team;
        this.rosterPositions = rosterPositions;
    }

    @JsonProperty("token")
    public String getToken() {
        return this.token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("user")
    public User getUser() {
        return this.user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("team")
    public Team getTeam() {
        return this.team;
    }

    @JsonProperty("team")
    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonProperty("rosterPositions")
    public List<String> getRosterPositions() {
        return this.rosterPositions;
    }

    @JsonProperty("rosterPositions")
    public void setRosterPositions(List<String> rosterPositions) {
        this.rosterPositions = rosterPositions;
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
        return "CurrentUser{" +
                "token='" + token + '\'' +
                ", user=" + user +
                ", team=" + team +
                ", rosterPositions=" + rosterPositions +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
