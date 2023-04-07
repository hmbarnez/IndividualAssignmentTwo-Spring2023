public class Monster {
    private String name;
    private int health;
    private int attackDmg;
    private boolean isAlive;
    private String dialogue;
    private int puzzleId;

    public Monster(String name, int health, int attackDmg, boolean isAlive, String dialogue, int puzzleId) {
        this.name = name;
        this.health = health;
        this.attackDmg = attackDmg;
        this.isAlive = isAlive;
        this.dialogue = dialogue;
        this.puzzleId = puzzleId;
    }



}
