package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * implements software that will make it easy to keep track of products.
 *
 * @author Kevin being produced.
 */
public class Main extends Application {


  /**
   * First Stage.
   * @param primaryStage user sees this stage first.
   * @throws Exception tells compiler that something that cant be accepted is
   *                   happening.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 550, 450));
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
