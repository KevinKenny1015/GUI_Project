package sample;

/**
 * @author Kevin
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Button btn_Add_Product;

    @FXML
    private Button btn_Record_Production;

    @FXML
    private ChoiceBox<ItemType> drop_down_type;

    @FXML
    private TextField Prodname_user_input;

    @FXML
    private TextField Manu_user_input;


    @FXML
    private TableColumn<String, Product> productType;

    @FXML
    private ListView<Product> prod_list_view;

    @FXML
    private ComboBox<ItemType> Choose_Quant;

    @FXML
    private TextArea Prod_log;

    @FXML
    private TableView<Product> prod_tableview;

    @FXML
    private TableColumn<?, ?> ProdID;

    @FXML
    private TableColumn<?, ?> ProdName;

    @FXML
    private TableColumn<?, ?> listtype;

    @FXML
    private TableColumn<?, ?> listman;

    //private ArrayList<RecordProduction>ProductionRecordArray;
    //private Employee EmployeeDetails;

    //Class Fields
    Statement stmt = null;
    Connection conn = null;
    private ObservableList<Product> productLine;

    @FXML
    public void initialize() {

    }

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
            String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( '" + type_from_user + "', '" + man_user + "', '" + device_name + "' );";

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

    /**
     * Columns for production line table
     */
    private void ProductionLineTable() {
        productLine = FXCollections.observableArrayList();
        ProdID.setCellValueFactory(new PropertyValueFactory("ID"));
        ProdName.setCellValueFactory(new PropertyValueFactory("name"));
        listtype.setCellValueFactory(new PropertyValueFactory("manufacturer"));
        listman.setCellValueFactory(new PropertyValueFactory("type"));
        prod_tableview.setItems(productLine);
    }

    /**
     * @throws SQLException
     */
    @FXML
    public void TextAreaLog() throws SQLException {
        Product prodProduced = prod_tableview.getSelectionModel().getSelectedItem();
//        int numProduced = Integer.parseInt(Choose_Quant.getValue());
        String quantity = String.valueOf(Choose_Quant.getValue());
        ArrayList<ProductionRecord> pr = new ArrayList();
//        for (int productionRunProduct = 0; productionRunProduct < numProduced; productionRunProduct++) {
//            ProductionRecord prodRecord = new ProductionRecord(prodProduced, productionRunProduct);
    }

    /**
     * Initializes ComboBox and add number 1-10
     */
    @FXML
    private void initializingComboBox() {
        ObservableList<String> data = FXCollections.observableArrayList();
        for (int i = 1; i <= 10; i++) {
            data.add(Integer.toString(i));
            Choose_Quant.setEditable(true);
            Choose_Quant.getSelectionModel().selectFirst();
            Choose_Quant.getItems().addAll(ItemType.values());
        }

    }

    /**
     * @param event
     */
    @FXML
    void Record_Production(ActionEvent event) {
        System.out.println("Record Production");
    }
}
