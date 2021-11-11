package money.heist.utils;

public class HeistNotFoundException extends RuntimeException {
  public HeistNotFoundException(Long id) {
    super("Could not find element with " + id);
  }
}
