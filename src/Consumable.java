public class Consumable extends ItemAbstract  {

    private int hitPointsAdded;

    public Consumable(int itemId, String itemName, String itemDesc, int itemLocation) {
        super(itemId, itemName, itemDesc, itemLocation);
    }

    public int getHitPointsAdded() {
        return hitPointsAdded;
    }
}
