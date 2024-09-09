import java.util.EnumMap;
import java.util.Map;

public abstract class Room {
    protected String name;
    protected Map<Direction, Room> adjoiningRooms = new EnumMap<>(Direction.class);
    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public Room getAdjoiningRoom(Direction direction) {
        return adjoiningRooms.get(direction);
    }

    public String getExits() {
        StringBuilder exits = new StringBuilder();
        for (Direction direction : adjoiningRooms.keySet()) {
            if (exits.length() > 0) {
                exits.append(" or ");
            }
            exits.append(direction.name().toLowerCase());
        }
        return exits.toString().trim();
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(Direction direction) {
        return adjoiningRooms.containsKey(direction);
    }

    public void setAdjoiningRoom(Direction direction, Room room) {
        adjoiningRooms.put(direction, room);
    }
}