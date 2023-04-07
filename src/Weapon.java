public class Weapon extends ItemAbstract {
    private int weaponDmg;

    public Weapon(int itemId, String itemName, String itemDesc, int itemLocation, int weaponDmg) {
        super(itemId, itemName, itemDesc, itemLocation);
        this.weaponDmg = weaponDmg;
    }
    public int getWeaponDmg() {
        return this.weaponDmg;
    }

}
