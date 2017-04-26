package com.api.domaine.assertions.StaffList;

import com.api.domaine.StaffList.Datum;
import com.api.domaine.StaffList.StaffList;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link StaffList} specific assertions - Generated by CustomAssertionGenerator.
 */
public class StaffListAssert extends AbstractAssert<StaffListAssert, StaffList> {

  /**
   * Creates a new <code>{@link StaffListAssert}</code> to make assertions on actual StaffList.
   * @param actual the StaffList we want to make assertions on.
   */
  public StaffListAssert(StaffList actual) {
    super(actual, StaffListAssert.class);
  }

  /**
   * An entry point for StaffListAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myStaffList)</code> and get specific assertion with code completion.
   * @param actual the StaffList we want to make assertions on.
   * @return a new <code>{@link StaffListAssert}</code>
   */
  public static StaffListAssert assertThat(StaffList actual) {
    return new StaffListAssert(actual);
  }

  /**
   * Verifies that the actual StaffList's additionalProperties is equal to the given one.
   * @param additionalProperties the given additionalProperties to compare the actual StaffList's additionalProperties to.
   * @return this assertion object.
   * @throws AssertionError - if the actual StaffList's additionalProperties is not equal to the given one.
   */
  public StaffListAssert hasAdditionalProperties(java.util.Map additionalProperties) {
    // check that actual StaffList we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting additionalProperties of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    java.util.Map actualAdditionalProperties = actual.getAdditionalProperties();
    if (!Objects.areEqual(actualAdditionalProperties, additionalProperties)) {
      failWithMessage(assertjErrorMessage, actual, additionalProperties, actualAdditionalProperties);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual StaffList's code is equal to the given one.
   * @param code the given code to compare the actual StaffList's code to.
   * @return this assertion object.
   * @throws AssertionError - if the actual StaffList's code is not equal to the given one.
   */
  public StaffListAssert hasCode(String code) {
    // check that actual StaffList we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting code of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualCode = actual.getCode();
    if (!Objects.areEqual(actualCode, code)) {
      failWithMessage(assertjErrorMessage, actual, code, actualCode);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual StaffList's data contains the given Datum elements.
   * @param data the given elements that should be contained in actual StaffList's data.
   * @return this assertion object.
   * @throws AssertionError if the actual StaffList's data does not contain all given Datum elements.
   */
  public StaffListAssert hasData(Datum... data) {
    // check that actual StaffList we want to make assertions on is not null.
    isNotNull();

    // check that given Datum varargs is not null.
    if (data == null) failWithMessage("Expecting data parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getData(), data);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual StaffList's data contains <b>only<b> the given Datum elements and nothing else in whatever order.
   * @param data the given elements that should be contained in actual StaffList's data.
   * @return this assertion object.
   * @throws AssertionError if the actual StaffList's data does not contain all given Datum elements.
   */
  public StaffListAssert hasOnlyData(Datum... data) {
    // check that actual StaffList we want to make assertions on is not null.
    isNotNull();

    // check that given Datum varargs is not null.
    if (data == null) failWithMessage("Expecting data parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getData(), data);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual StaffList's data does not contain the given Datum elements.
   *
   * @param data the given elements that should not be in actual StaffList's data.
   * @return this assertion object.
   * @throws AssertionError if the actual StaffList's data contains any given Datum elements.
   */
  public StaffListAssert doesNotHaveData(Datum... data) {
    // check that actual StaffList we want to make assertions on is not null.
    isNotNull();

    // check that given Datum varargs is not null.
    if (data == null) failWithMessage("Expecting data parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getData(), data);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual StaffList has no data.
   * @return this assertion object.
   * @throws AssertionError if the actual StaffList's data is not empty.
   */
  public StaffListAssert hasNoData() {
    // check that actual StaffList we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have data but had :\n  <%s>";
    
    // check
    if (actual.getData().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getData());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

}
