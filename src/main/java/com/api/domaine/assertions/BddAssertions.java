package com.api.domaine.assertions;

/**
 * Entry point for BDD assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class BddAssertions {

  /**
   * Creates a new instance of <code>{@link com.api.domaine.assertions.CurrentUserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.assertions.CurrentUserAssert then(com.api.domaine.CurrentUser actual) {
    return new com.api.domaine.assertions.CurrentUserAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.assertions.TeamAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.assertions.TeamAssert then(com.api.domaine.Team actual) {
    return new com.api.domaine.assertions.TeamAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.assertions.UserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.assertions.UserAssert then(com.api.domaine.User actual) {
    return new com.api.domaine.assertions.UserAssert(actual);
  }

  /**
   * Creates a new <code>{@link BddAssertions}</code>.
   */
  protected BddAssertions() {
    // empty
  }
}
