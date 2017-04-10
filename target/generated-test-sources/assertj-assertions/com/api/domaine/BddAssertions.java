package com.api.domaine;

/**
 * Entry point for BDD assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class BddAssertions {

  /**
   * Creates a new instance of <code>{@link com.api.domaine.CurrentUserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.CurrentUserAssert then(com.api.domaine.CurrentUser actual) {
    return new com.api.domaine.CurrentUserAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.TeamAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.TeamAssert then(com.api.domaine.Team actual) {
    return new com.api.domaine.TeamAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.UserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.UserAssert then(com.api.domaine.User actual) {
    return new com.api.domaine.UserAssert(actual);
  }

  /**
   * Creates a new <code>{@link BddAssertions}</code>.
   */
  protected BddAssertions() {
    // empty
  }
}
