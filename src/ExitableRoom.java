public class ExitableRoom extends Room implements Exitable {
    public ExitableRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "This is an exitable room. Prepare yourself to face a powerful familiar foe!";
    }

    @Override
    public String exit(Player player) {
        if (player.hasWeapon()) {
            return "You fought Shredder and escaped the Technodrome! Your final score is: " + player.getScore();
        } else {
            return "You need your weapon to fight Shredder and escape! Go back and search for it.";
        }
    }
}