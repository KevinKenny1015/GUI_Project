package sample;

import java.util.Date;

/**
 * @author Kevin class ProductionRecord stores data in database
 */
public class ProductionRecord {

  int prodNumber;
  int prodID;
  String serialNum;
  Date prodDate;
  String prodName;

  /**
   * Class constructor
   *
   * @param prodID int prodID
   */
  public ProductionRecord(int prodID) {
    this.prodID = prodID;
    this.prodNumber = 0;
    this.serialNum = "0";
    this.prodDate = new Date();
  }

  /**
   * Class constructor
   *
   * @param prodNumber  int number
   * @param productName String name
   * @param serialNum   String serialNum
   * @param prodDate    Date
   */
  public ProductionRecord(int prodNumber, String productName, String serialNum,
      Date prodDate) {
    this.prodNumber = prodNumber;
    this.prodName = productName;
    this.serialNum = serialNum;
    this.prodDate = prodDate;
  }

  /**
   * Class construtor
   *
   * @param product object is passed as an argument
   * @param count   integer value passed as argument
   */
  public ProductionRecord(Product product, int count) {
    String IDNumber = String.format("%05d", count);
    this.serialNum =
        product.getManufacturer().substring(0, 3) + product.getItemType()
            + IDNumber;
    this.prodName = product.getName();
    this.prodDate = new Date();
  }

  /**
   * getter for ProdName
   *
   * @return string
   */
  public String getProdName() {
    return prodName;
  }

  /**
   * getter for ProdNumber
   *
   * @return int
   */
  public int getProdNumber() {
    return prodNumber;
  }

  /**
   * geter for ProdID
   *
   * @return int
   */
  public int getProdID() {
    return prodID;
  }

  /**
   * getter for serialNum
   *
   * @return string
   */
  public String getSerialNum() {
    return serialNum;
  }

  /**
   * getter for prodDate
   *
   * @return date of prodDate
   */
  public Date getProdDate() {
    return prodDate;
  }

  // Setters

  /**
   * setter for prodName
   *
   * @param prodName string
   */
  public void setProdName(String prodName) {
    this.prodName = prodName;
  }

  /**
   * setter for prodNumber
   *
   * @param prodNumber int
   */
  public void setProdNumber(int prodNumber) {
    this.prodNumber = prodNumber;
  }

  /**
   * setter for prodID
   *
   * @param prodID int
   */
  public void setProdID(int prodID) {
    this.prodID = prodID;
  }

  /**
   * setter for serialNum
   *
   * @param serialNumber Sting
   */
  public void setSerialNum(String serialNumber) {
    this.serialNum = serialNum;
  }

  /**
   * setter for prodDate
   *
   * @param prodDate date for prodDate
   */
  public void setProdDate(Date prodDate) {
    this.prodDate = prodDate;
  }

  /**
   * Method to format the String toString
   *
   * @return formatted String
   */
  @Override
  public String toString() {
    String str = String.format(
        "Prod. Num: %s Product ID: %s Serial Num: %s Date: %s",
        prodNumber, prodID, serialNum, prodDate);
    return str;
  }
}