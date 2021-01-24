public class Item {
    public String getItem_name() {
        return name;
    }

    public void setItem_name(String item_name) {
        this.name = item_name;
    }



    public String getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(String quantity_unit) {
        this.quantity_unit = quantity_unit;
    }

    public String getPrice_for_quantity() {
        return price_for_quantity;
    }

    public void setPrice_for_quantity(String price_for_quantity) {
        this.price_for_quantity = price_for_quantity;
    }

    private String name;
    private String quantity_unit;
    private String price_for_quantity;

}
