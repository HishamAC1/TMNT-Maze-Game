public class InteractableRoom extends Room implements Interactable {
    private boolean isInteracted;

    public InteractableRoom(String name) {
        super(name);
        this.isInteracted = false;
    }

    @Override
    public String getDescription() {
        return isInteracted ? "This room has already been interacted with." : "This is an interactable room.";
    }

    @Override
    public String interact(Player player) {
        if (!isInteracted) {
            if (!player.isWeaponLooted()) {
                player.addToInventory(player.getWeapon());
                player.addToScore(20); // Example score increment
                player.setWeaponLooted(true);
                isInteracted = true;
                return "Ninja Power! You searched the room and found your weapon: " + player.getWeapon() + ". Gained 20 points.";
            } else {
                return "You have already looted your weapon.";
            }
        } else {
            return "This room has already been interacted with.";
        }
    }
}