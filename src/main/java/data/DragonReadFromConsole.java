package data;

import commandsLogic.CollectionManager;

import java.time.ZonedDateTime;
import java.util.Scanner;

import static data.DragonID.getId;

public class DragonReadFromConsole {
    static int i = 0;
    static CollectionManager collectionManager;


    public static Dragon readDragon(){
        Scanner scanner = new Scanner(System.in);
        try {
            // Read input from the console
            System.out.print("Введите имя дракона: ");
            String name = scanner.nextLine();

            System.out.print("Введите возраст дракона: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите вес дракона: ");
            int weight = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите цвет дракона: (GREEN, BLACK, YELLOW, BROWN): ");
            Color color = Color.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Введите характер дракона: (CUNNING, WISE, CHAOTIC, CHAOTIC_EVIL or FICKLE): ");
            DragonCharacter character = DragonCharacter.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Введите размер головы дракона: ");
            int headSize = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите количество зубов дракона: ");
            int toothCount = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите координаты дракона: (x, y): ");
            System.out.print("x = ");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("y = ");
            int y = Integer.parseInt(scanner.nextLine());
            //scanner.nextLine(); // consume the newline character
            Coordinates coordinates = new Coordinates(x, y);
            // Create a new dragon and add it to the list
            Dragon dragon = new Dragon(getId(),
                    name,
                    age,
                    weight,
                    coordinates,
                    color,
                    character,
                    new DragonHead(headSize, toothCount),
                    ZonedDateTime.now());

            return dragon;
        } catch (IllegalArgumentException e) {
            // Catch exceptions if the user inputs invalid values
            System.out.println("Invalid input. Please try again.");

        } catch (Exception e) {
            // Catch all other exceptions
            System.out.println("An error occurred. Please try again.");
            System.out.println(e.getMessage());

        }
        return null;
    }
}
