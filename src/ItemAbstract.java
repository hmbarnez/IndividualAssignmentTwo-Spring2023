import java.io.Serializable;

public abstract class ItemAbstract {
    private int itemId;
    private String itemName;
    private String itemDesc;
    private int itemLocation;

    public ItemAbstract(int itemId, String itemName, String itemDesc, int itemLocation) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemLocation = itemLocation;
    }


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
