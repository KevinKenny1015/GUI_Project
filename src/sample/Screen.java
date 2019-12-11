package sample;

/**
 * @author Kevin class Screen implements ScreenSpec
 */
public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * Constructor for Screen
   *
   * @param resolution   String value
   * @param refreshrate  int value
   * @param responsetime int value
   */
  public Screen(String resolution, int refreshrate, int responsetime) {
    this.resolution = resolution;
    this.refreshRate = refreshrate;
    this.responseTime = responsetime;
  }

  /**
   * getter for resolution of screen
   *
   * @return String resolution
   */
  public String getResolution() {
    return this.resolution;
  }

  /**
   * setter for resolution
   *
   * @param resolution String
   */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  /**
   * getter for refreshRate
   *
   * @return int refreshRate
   */
  public int getRefreshRate() {
    return this.refreshRate;
  }

  /**
   * setter for refreshRate
   *
   * @param refreshRate int
   */
  public void setRefreshRate(int refreshRate) {
    this.refreshRate = refreshRate;
  }

  /**
   * getter for responseTime
   *
   * @return int responseTime
   */
  public int getResponseTime() {
    return this.responseTime;
  }

  /**
   * setter for responseTime
   *
   * @param responseTime int
   */
  public void setResponseTime(int responseTime) {
    this.responseTime = responseTime;
  }

  /**
   * String format
   *
   * @return String resolution, int refreshRate, int responseTime in correct
   * format
   */
  public String toString() {
    return String.format(
        "\nResolution: %s\nRefresh rate: %d\nResponse time: %d",
        this.resolution, this.refreshRate, this.responseTime);
  }
}
