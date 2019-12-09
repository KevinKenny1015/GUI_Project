package sample;

/**
 * @author Kevin
 * holds ItemType
 */
public enum ItemType {
    AUDIO("AU"),

    VISUAL("VI"),

    AUDIO_MOBILE("AM"),

    VISUAL_MOBILE("VM");

    public String productType;

    /**
     *  ItemType Constructor
     * @param productType
     */
    ItemType(String productType) {
        this.productType = productType;
    }

    /**
     * Receives code
     * @return
     */
    public String getProductType() {

        return productType;
    }

    /**
     * Sets code
     * @return
     */
    public String setProductType() {
        return productType;
    }
}

