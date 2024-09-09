import java.util.Random;

public class LootableRoom extends Room implements Lootable {
    private boolean isLooted;

    public LootableRoom(String name) {
        super(name);
        this.isLooted = false;
    }

    @Override
    public String getDescription() {
        return isLooted ? "This room has already been looted." : "This is a lootable room.";
    }

    @Override
    public String loot(Player player) {
        if (!isLooted) {
            String[] pizzas = {"Pepperoni Pizza", "Anchovie Pizza", "Pineapple Pizza"};
            String pizza = pizzas[new Random().nextInt(pizzas.length)];
            int points = 0;
            String message = "";

            switch (pizza) {
                case "Pepperoni Pizza":
                    points = 10;
                    message = "Cowabunga dude ! You looted the room and found " + pizza + ". Gained " + points + " points.";
                    break;
                case "Anchovie Pizza":
                    points = -5;
                    message = "Bummer dude, you found an " + pizza + ". Lost " + points + " points.";
                    break;
                case "Pineapple Pizza":
                    points = 5;
                    message = "Awesome! You looted the room and found " + pizza + ". Gained " + points + " points.";
                    break;
            }

            player.addToInventory(pizza);
            player.addToScore(points);
            isLooted = true;
            return message;
        } else {
            return "This room has already been looted.";
        }
    }
}