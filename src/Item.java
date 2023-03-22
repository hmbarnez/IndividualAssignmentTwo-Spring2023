public class Item {
    private int itemId;
    private String itemName;
    private String itemDesc;
    private int itemLocation;

    public Item(int itemId, String itemName, String itemDesc, int itemLocation) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemLocation = itemLocation;
    }

    //getters setters toString
    //need to clean up
    @Override
    public String toString() {
        return this.itemName;
    }

    public int getItemLocation() {
        return itemLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemId() {
        return itemId;
    }
}
