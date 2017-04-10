package com.api.domaine;

import static org.assertj.core.groups.Properties.extractProperty;

import java.util.List;
import org.assertj.core.internal.cglib.proxy.Enhancer;

import org.assertj.core.api.ErrorCollector;
import org.assertj.core.api.SoftAssertionError;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class SoftAssertions {

  /** Collects error messages of all AssertionErrors thrown by the proxied method. */
  protected final ErrorCollector collector = new ErrorCollector();

  /** Creates a new </code>{@link SoftAssertions}</code>. */
  public SoftAssertions() {
  }

  /**
   * Verifies that no proxied assertion methods have failed.
   *
   * @throws SoftAssertionError if any proxied assertion objects threw
   */
  public void assertAll() {
    List<Throwable> errors = collector.errors();
    if (!errors.isEmpty()) {
      throw new SoftAssertionError(extractProperty("message", String.class).from(errors));
    }
  }

  @SuppressWarnings("unchecked")
  protected <T, V> V proxy(Class<V> assertClass, Class<T> actualClass, T actual) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(assertClass);
    enhancer.setCallback(collector);
    return (V) enhancer.create(new Class[] { actualClass }, new Object[] { actual });
  }

  /**
   * Creates a new "soft" instance of <code>{@link com.api.domaine.CurrentUserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public com.api.domaine.CurrentUserAssert assertThat(com.api.domaine.CurrentUser actual) {
    return proxy(com.api.domaine.CurrentUserAssert.class, com.api.domaine.CurrentUser.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link com.api.domaine.TeamAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public com.api.domaine.TeamAssert assertThat(com.api.domaine.Team actual) {
    return proxy(com.api.domaine.TeamAssert.class, com.api.domaine.Team.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link com.api.domaine.UserAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public com.api.domaine.UserAssert assertThat(com.api.domaine.User actual) {
    return proxy(com.api.domaine.UserAssert.class, com.api.domaine.User.class, actual);
  }

}
