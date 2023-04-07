public class Armor extends ItemAbstract {

    private int armorPoints;

    public Armor(int itemId, String itemName, String itemDesc, int itemLocation,int armorPoints) {
        super(itemId, itemName, itemDesc, itemLocation);
        this.armorPoints = armorPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

}
