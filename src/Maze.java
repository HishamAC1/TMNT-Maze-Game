import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished;
    private List<Room> rooms;

    public Maze(String character, String weapon) {
        this.player = new Player(character, weapon);
        this.isFinished = false;
        this.rooms = new ArrayList<>();

        // Create rooms
        rooms.add(new LootableRoom("Room 1"));
        rooms.add(new InteractableRoom("Room 2"));
        rooms.add(new ExitableRoom("Room 3"));
        rooms.add(new LootableRoom("Room 4"));
        rooms.add(new InteractableRoom("Room 5"));
        rooms.add(new LootableRoom("Room 6"));

        // Shuffle rooms to randomize the maze layout
        Collections.shuffle(rooms, new Random());

        // Set adjoining rooms
        for (int i = 0; i < rooms.size() - 1; i++) {
            rooms.get(i).setAdjoiningRoom(Direction.EAST, rooms.get(i + 1));
            rooms.get(i + 1).setAdjoiningRoom(Direction.WEST, rooms.get(i));
        }

        this.currentRoom = rooms.get(0);
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable) {
            String exitMessage = ((Exitable) currentRoom).exit(player);
            if (exitMessage.contains("escaped the Technodrome")) {
                isFinished = true;
            }
            return exitMessage;
        }
        return "This room is not exitable.";
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            return ((Interactable) currentRoom).interact(player);
        }
        return "No interactions possible.";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            return ((Lootable) currentRoom).loot(player);
        }
        return "This room is not lootable.";
    }

    public boolean move(Direction direction) {
        Room nextRoom = currentRoom.getAdjoiningRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public boolean isFinished() {
        return isFinished;
    }
}