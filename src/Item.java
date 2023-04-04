import java.io.Serializable;

public class Item implements Serializable {
    private final int itemId;
    private final String itemName;
    private final String itemDesc;
    private final int itemLocation;

    public Item(int itemId, String itemName, String itemDesc, int itemLocation) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemLocation = itemLocation;
    }

    //getters and toString
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

    public String getItemDesc() {
        return itemDesc;
    }

    public int getItemId() {
        return itemId;
    }
}
