package com.api.domaine;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link Team} specific assertions - Generated by CustomAssertionGenerator.
 */
public class TeamAssert extends AbstractAssert<TeamAssert, Team> {

  /**
   * Creates a new <code>{@link TeamAssert}</code> to make assertions on actual Team.
   * @param actual the Team we want to make assertions on.
   */
  public TeamAssert(Team actual) { super (actual, TeamAssert.class);
  }

  /**
   * An entry point for TeamAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myTeam)</code> and get specific assertion with code completion.
   * @param actual the Team we want to make assertions on.
   * @return a new <code>{@link TeamAssert}</code>
   */
  public static TeamAssert assertThat(Team actual) {
    return new TeamAssert(actual);
  }

  /**
   * Verifies that the actual Team's additionalProperties is equal to the given one.
   * @param additionalProperties the given additionalProperties to compare the actual Team's additionalProperties to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Team's additionalProperties is not equal to the given one.
   */
  public TeamAssert hasAdditionalProperties(java.util.HashMap additionalProperties) {
    // check that actual Team we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting additionalProperties of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    java.util.HashMap actualAdditionalProperties = actual.getAdditionalProperties();
    if (!Objects.areEqual(actualAdditionalProperties, additionalProperties)) {
      failWithMessage(assertjErrorMessage, actual, additionalProperties, actualAdditionalProperties);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Team's athleteCount is equal to the given one.
   * @param athleteCount the given athleteCount to compare the actual Team's athleteCount to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Team's athleteCount is not equal to the given one.
   */
  public TeamAssert hasAthleteCount(Integer athleteCount) {
    // check that actual Team we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting athleteCount of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Integer actualAthleteCount = actual.getAthleteCount();
    if (!Objects.areEqual(actualAthleteCount, athleteCount)) {
      failWithMessage(assertjErrorMessage, actual, athleteCount, actualAthleteCount);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Team's mascot is equal to the given one.
   * @param mascot the given mascot to compare the actual Team's mascot to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Team's mascot is not equal to the given one.
   */
  public TeamAssert hasMascot(String mascot) {
    // check that actual Team we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting mascot of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualMascot = actual.getMascot();
    if (!Objects.areEqual(actualMascot, mascot)) {
      failWithMessage(assertjErrorMessage, actual, mascot, actualMascot);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual Team's name is equal to the given one.
   * @param name the given name to compare the actual Team's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual Team's name is not equal to the given one.
   */
  public TeamAssert hasName(String name) {
    // check that actual Team we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting name of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualName = actual.getName();
    if (!Objects.areEqual(actualName, name)) {
      failWithMessage(assertjErrorMessage, actual, name, actualName);
    }

    // return the current assertion for method chaining
    return this;
  }

}
