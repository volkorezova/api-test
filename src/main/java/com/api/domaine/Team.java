package com.api.domaine;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"mascot", "name", "athlete_count"})
public class Team {
    @JsonProperty("mascot")
    private String mascot;
    @JsonProperty("name")
    private String name;
    @JsonProperty("athlete_count")
    private Integer athleteCount;
    @JsonIgnore
    private HashMap additionalProperties = new HashMap();

    public Team() {
    }

    public Team(String mascot, String name, Integer athleteCount) {
        this.mascot = mascot;
        this.name = name;
        this.athleteCount = athleteCount;
    }

    @JsonProperty("mascot")
    public String getMascot() {
        return this.mascot;
    }

    @JsonProperty("mascot")
    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("athlete_count")
    public Integer getAthleteCount() {
        return this.athleteCount;
    }

    @JsonProperty("athlete_count")
    public void setAthleteCount(Integer athleteCount) {
        this.athleteCount = athleteCount;
    }

    @JsonAnyGetter
    public HashMap getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Team{" +
                "mascot='" + mascot + '\'' +
                ", name='" + name + '\'' +
                ", athleteCount=" + athleteCount +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
