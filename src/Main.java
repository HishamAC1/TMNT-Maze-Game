import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // Print instructions
            System.out.println("Teenage Mutant Ninja Turtles in: Escape from the Technodrome");
            System.out.println("(A Maze Game by Hisham Chaudhry)");
            System.out.println(" ");
            System.out.println("Commands:");
            System.out.println("'n' - Move North");
            System.out.println("'s' - Move South");
            System.out.println("'e' - Move East");
            System.out.println("'w' - Move West");
            System.out.println("'u' - Move Up");
            System.out.println("'d' - Move Down");
            System.out.println("'i' - Interact with the room");
            System.out.println("'l' - Loot the room");
            System.out.println("'x' - Exit the room");
            System.out.println("'v' - View inventory");
            System.out.println();

            // Character selection
            System.out.println("Choose your character:");
            System.out.println("1. Leonardo");
            System.out.println("2. Michelangelo");
            System.out.println("3. Raphael");
            System.out.println("4. Donatello");
            System.out.print("Enter the number of your choice: ");
            int choice = scanner.nextInt();
            String character = "";
            String weapon = "";
            switch (choice) {
                case 1:
                    character = "Leonardo";
                    weapon = "Katanas";
                    break;
                case 2:
                    character = "Michelangelo";
                    weapon = "Nunchuks";
                    break;
                case 3:
                    character = "Raphael";
                    weapon = "Sai";
                    break;
                case 4:
                    character = "Donatello";
                    weapon = "Bo";
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Leonardo.");
                    character = "Leonardo";
                    weapon = "Katanas";
            }

            Maze maze = new Maze(character, weapon);

            while (!maze.isFinished()) {
                System.out.println(maze.getCurrentRoomDescription());
                System.out.println("Exits: " + maze.getCurrentRoomExits());
                System.out.print("Enter command: ");
                char command = scanner.next().charAt(0);

                Direction direction = null;
                switch (command) {
                    case 'n': direction = Direction.NORTH; break;
                    case 's': direction = Direction.SOUTH; break;
                    case 'e': direction = Direction.EAST; break;
                    case 'w': direction = Direction.WEST; break;
                    case 'u': direction = Direction.UP; break;
                    case 'd': direction = Direction.DOWN; break;
                    case 'i':
                        System.out.println(maze.interactWithCurrentRoom());
                        continue;
                    case 'l':
                        System.out.println(maze.lootCurrentRoom());
                        continue;
                    case 'x':
                        System.out.println(maze.exitCurrentRoom());
                        continue;
                    case 'v':
                        System.out.println(maze.getPlayerInventory());
                        continue;
                    default:
                        System.out.println("Invalid command.");
                        continue;
                }

                if (direction != null && !maze.move(direction)) {
                    System.out.println("Invalid move.");
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
    }
}