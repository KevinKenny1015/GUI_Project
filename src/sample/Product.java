package sample;

/**
 * @author Kevin product objects are created here
 */

/**
 * abstract class Product implements interface Item
 */
public abstract class Product implements Item {

  // Fields that my Product will use
  private int id;
  private String manufacturer;
  private String name;
  private ItemType itemType;

  /**
   * @param name         pass a string
   * @param manufacturer pass a string
   * @param itemType     send ItemType or Product
   */
  public Product(String name, String manufacturer, ItemType itemType) {

    this.name = name;
    this.manufacturer = manufacturer;
    this.itemType = itemType;
  }

  /**
   * getter for ItemType
   *
   * @return
   */
  public ItemType getItemType() {
    return this.itemType;
  }

  /**
   * setter for the type of item for ItemType
   *
   * @param itemType
   */
  public void setItemType(ItemType itemType) {
    this.itemType = itemType;
  }

  /**
   * getter for id
   *
   * @return return int
   */
  public int getId() {
    return id;
  }

  /**
   * setter for id
   *
   * @param id sends int to id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * getter for string name
   *
   * @return return String
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * setter for name
   *
   * @param name is passed as argument
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * setter for manufacturer
   *
   * @param manufacturer passes sting as argument
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * getter for manufacturer
   *
   * @return String
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * getter for ItemType
   *
   * @return object ItemType
   */
  public ItemType getType() {
    return itemType;
  }

  /**
   * setter for ItemType
   *
   * @param type passes value for ItemType
   */
  public void setType(ItemType type) {
    this.itemType = type;
  }

  /**
   * used for formatting the toString Method
   *
   * @return return a String
   */
  @Override
  public String toString() {
    String str =
        String.format("Name: %s\nManufacturer: %s\ntype: %s", this.name,
            this.manufacturer, this.itemType);
    return str;
  }
}

/**
 * class Widget extends to the abstract class Product
 */
class Widget extends Product {

  Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}

