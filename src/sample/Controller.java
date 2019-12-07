package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    @FXML
    private Button btn_Add_Product;

    @FXML
    private Button btn_Record_Production;

    @FXML
    private ChoiceBox<?> drop_down_type;

    @FXML
    private TextField Prodname_user_input;

    @FXML
    private TextField Manu_user_input;

    @FXML
    void Add_Product(ActionEvent event) {
    System.out.println("Add_Product");

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/GUI_db";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            String type_from_user = "AUDIO";
            String man_user = Manu_user_input.getText();
            String device_name = Prodname_user_input.getText();
            String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( '"+type_from_user+"', '"+man_user+"', '"+device_name+"' );";

            stmt.executeUpdate(sql);

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void Record_Production(ActionEvent event) {
        System.out.println("Record Production");
    }
}
