package sample;

/**
 * Interface for ScreenSpec.
 *
 * @author Kevin
 */
public interface ScreenSpec {

  /**
   * Method Call getter for the resolution.
   *
   * @return string
   */
  public String getResolution();

  /**
   * Method Call for refreshRate.
   *
   * @return int
   */
  public int getRefreshRate();

  /**
   * Method Call for responseTime.
   *
   * @return int
   */
  public int getResponseTime();
}
