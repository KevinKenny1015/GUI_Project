package sample;


/**
 * @author Kevin
 */
public class MoviePlayer extends Product implements MultimediaControl {

  private Screen screen;
  private MonitorType monitorType;

  /**
   * @param name         pass String
   * @param manufacturer pass String
   * @param screen       send screen
   * @param monitorType  send monitortype
   */
  public MoviePlayer(String name, String manufacturer, Screen screen,
      MonitorType monitorType) {

    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  public void play() {
    System.out.println("Playing movie");
  }

  public void stop() {
    System.out.println("Stopping movie");
  }

  public void previous() {
    System.out.println("Previous movie");
  }

  public void next() {
    System.out.println("Next movie");
  }

  /**
   * @return string toString
   */
  @Override
  public String toString() {
    return String
        .format("%s\nScreen: %s\nMonitorType: %s", super.toString(), screen,
            monitorType);
  }
}

