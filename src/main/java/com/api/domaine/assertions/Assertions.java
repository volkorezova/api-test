package com.api.domaine.assertions;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class Assertions {

  /**
   * Creates a new instance of <code>{@link com.api.domaine.assertions.CurrentUserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.assertions.CurrentUserAssert assertThat(com.api.domaine.CurrentUser actual) {
    return new com.api.domaine.assertions.CurrentUserAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.assertions.TeamAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.assertions.TeamAssert assertThat(com.api.domaine.Team actual) {
    return new com.api.domaine.assertions.TeamAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.assertions.UserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.assertions.UserAssert assertThat(com.api.domaine.User actual) {
    return new com.api.domaine.assertions.UserAssert(actual);
  }

  /**
   * Creates a new <code>{@link Assertions}</code>.
   */
  protected Assertions() {
    // empty
  }
}
