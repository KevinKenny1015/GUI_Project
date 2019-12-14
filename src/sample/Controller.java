package sample;

/**
 * @author Kevin
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;



public class Controller {

  @FXML
  private Button btnAddProduct;

  @FXML
  private Button btnRecordProduction;

  @FXML
  private ChoiceBox<ItemType> dropDownType;

  @FXML
  private ComboBox<Integer> chooseQuant;

  @FXML
  private TextField prodnameUserInput;

  @FXML
  private TextField manuUserInput;

  @FXML
  private TableColumn<String, Product> productType;

  @FXML
  private ListView<Product> prodListView;

  @FXML
  private TextArea prodLog;

  @FXML
  private TableView<Product> prodTableview;
  @FXML
  private TableColumn<?, ?> prodID;

  @FXML
  private TableColumn<?, ?> prodName;
  @FXML
  private TableColumn<?, ?> prodMan;
  @FXML
  private TableColumn<?, ?> prodType;


  //Class Fields
  Statement stmt = null;
  Connection conn = null;
  private ObservableList<Product> productLine;
  private ArrayList<ProductionRecord> prodRecordArray;


  public Controller() {
  }

  /**
   * The initialize method fills the combobox and choice box  while calling other functions.
   */
  @FXML
  public void initialize() throws SQLException {
    for (ItemType item : ItemType.values()) {
      dropDownType.getItems().add(item);
    }
    chooseQuant.setEditable(true);
    for (int i = 1; i <= 10; i++) {
      chooseQuant.getItems();
      ///addi
    }
    chooseQuant.getSelectionModel().selectFirst();

    connection();
    setupProductLineTable();
    loadProductList();
    loadProductionLog();
    showProduction();
  }

  private void connection() {
    try {
      String jdbcDriver = "org.h2.Driver";
      Class.forName(jdbcDriver);
      String dbUrl = "jdbc:h2:./res/GUI_db";
      String user = "";
      String pass = "";
      try {
        Properties prop = new Properties();
        prop.load(new FileInputStream("res/properties"));
        pass = prop.getProperty("password");
      } catch (Exception e) {
        System.out.println("Database password error.");
      }
      conn = DriverManager.getConnection(dbUrl, user, pass);
      stmt = conn.createStatement();
      System.out.println("Database Connection Established.");

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

  }

  ////////////////////////
  private void setupProductLineTable() {
    productLine = FXCollections.observableArrayList();
    prodID.setCellValueFactory(new PropertyValueFactory("ID"));
    prodName.setCellValueFactory(new PropertyValueFactory("name"));
    prodType.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    prodMan.setCellValueFactory(new PropertyValueFactory("type"));
    prodTableview.setItems(productLine);
  }

  /**
   * The loadProductList method gets product items from the database and adds
   * them to the productline observable list.
   *
   * @throws SQLException Checks if the sql statement is valid.
   */
  private void loadProductList() throws SQLException {
    String sql = "SELECT * FROM PRODUCT";
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      // these lines correspond to the database table columns
      String nameFromDb = rs.getString(2);
      ItemType typeFromDb = ItemType.valueOf(rs.getString(3));
      //emType convertStringToType = typeFromDb.getClass().getGenericSuperclass();
      String manFromDb = rs.getString(4);
      // create object
      Product productFromDB = new Widget(nameFromDb, manFromDb, typeFromDb);
      // save to observable list
      productLine.add(productFromDB);
      prodListView.getItems().clear();
      for (Product products : productLine) {
        prodListView.getItems().add(products);
      }
    }
    rs.close();
  }

  /**
   * loadProductionLog method stores record production objects from the database
   * into a record production array.
   *
   * @throws SQLException Checks if the sql statement is valid.
   */
  private void loadProductionLog() throws SQLException {
    prodRecordArray = new ArrayList<>();
    String sql = "SELECT * FROM PRODUCTIONRECORD";
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
      // corresponds to database table columns
      int productNumDB = rs.getInt(1);
      String prodNameDB = rs.getString(2);
      String serialNumDB = rs.getString(3);
      Date dateProducedDB = new Date(rs.getTimestamp(4).getTime());
      // create object
      ProductionRecord prodLogFromDB = new ProductionRecord(productNumDB,
          prodNameDB, serialNumDB,
          dateProducedDB);
      // save to observable list
      prodRecordArray.add(prodLogFromDB);
    }
    rs.close();
  }

  /**
   * showProduction method outputs record production items from the database to
   * the production log text area.
   */
  private void showProduction() {
    prodLog.clear();
    for (ProductionRecord production : prodRecordArray) {
      prodLog.setWrapText(true);
      prodLog
          .appendText(production.toString() + "\n");
    }
  }

  /**
   * addProduct method adds a new product into the product database table.
   *
   * @throws SQLException Checks if sql statement is valid
   */
  @FXML
  public void addProduct() throws SQLException {
    String name = prodnameUserInput.getText();
    String manufacturer = manuUserInput.getText();
    ItemType type = dropDownType
        .getValue(); // itemtypeChoice.getSelectionModel().toString();
    if (name != null && manufacturer != null && type != null) {
      String query = "INSERT INTO PRODUCT (NAME, TYPE,  MANUFACTURER) VALUES(?, ?, ?)";
      PreparedStatement prodToDB = conn.prepareStatement(query);
      prodToDB.setString(1, name);
      prodToDB.setString(2, type.toString());
      prodToDB.setString(3, manufacturer);
      prodToDB.executeUpdate();
      prodnameUserInput.clear();
      manuUserInput.clear();
      dropDownType.getSelectionModel().clearSelection();
      loadProductList();
    } else {
      Alert b = new Alert(Alert.AlertType.ERROR);
      b.setAlertType(Alert.AlertType.ERROR);
      b.setContentText("INVALID INPUT");
      b.show();
    }
  }

  /**
   * Columns for production line table.
   */
  private void productionLineTable() {
    productLine = FXCollections.observableArrayList();
    prodID.setCellValueFactory(new PropertyValueFactory("ID"));
    prodName.setCellValueFactory(new PropertyValueFactory("name"));
    prodMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    prodType.setCellValueFactory(new PropertyValueFactory("type"));
    prodTableview.setItems(productLine);
  }

  /**
   * text area is viewable.
   */
  @FXML
  public void textAreaLog() throws SQLException {
    Product prodProduced = prodTableview.getSelectionModel().getSelectedItem();
    String quantity = String.valueOf(chooseQuant.getValue());
    ArrayList<ProductionRecord> pr = new ArrayList();

  }


  /**
   * Initializes ComboBox and add number 1-10.
   */
  @FXML
  private void comboBox() {
    ObservableList<Integer> data = chooseQuant.getItems();
    for (int i = 1; i <= 10; i++) {
      // compute values rom 1 to 10
      data.add(i);
    }
  }

  @FXML
  void recordProduction(ActionEvent event) {

  }
}



