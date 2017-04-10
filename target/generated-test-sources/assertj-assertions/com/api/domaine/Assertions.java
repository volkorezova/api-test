package com.api.domaine;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class Assertions {

  /**
   * Creates a new instance of <code>{@link com.api.domaine.CurrentUserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.CurrentUserAssert assertThat(com.api.domaine.CurrentUser actual) {
    return new com.api.domaine.CurrentUserAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.TeamAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.TeamAssert assertThat(com.api.domaine.Team actual) {
    return new com.api.domaine.TeamAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link com.api.domaine.UserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static com.api.domaine.UserAssert assertThat(com.api.domaine.User actual) {
    return new com.api.domaine.UserAssert(actual);
  }

  /**
   * Creates a new <code>{@link Assertions}</code>.
   */
  protected Assertions() {
    // empty
  }
}
