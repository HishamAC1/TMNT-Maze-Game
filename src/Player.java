import java.util.ArrayList;
import java.util.List;

public class Player {
    private String character;
    private String weapon;
    private int score;
    private List<String> inventory;
    private boolean weaponLooted;

    public Player(String character, String weapon) {
        this.character = character;
        this.weapon = weapon;
        this.score = 0;
        this.inventory = new ArrayList<>();
        this.weaponLooted = false;
    }

    public String getCharacter() {
        return character;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int points) {
        score += points;
    }

    public String getInventory() {
        return String.join(", ", inventory);
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public boolean isWeaponLooted() {
        return weaponLooted;
    }

    public void setWeaponLooted(boolean weaponLooted) {
        this.weaponLooted = weaponLooted;
    }

    public boolean hasWeapon() {
        return weaponLooted;
    }
}