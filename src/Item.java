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

    @Override
    public String toString() {
        return "Item{" +this.itemName+'}';
    }

    public int getItemLocation() {
        return itemLocation;
    }

}
