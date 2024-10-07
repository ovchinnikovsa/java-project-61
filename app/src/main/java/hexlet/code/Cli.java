package hexlet.code;

import java.util.Scanner;

// TODO: for each damn static method i need to create a new Scanner instance
public class Cli {
    private static Scanner scanner = new Scanner(System.in);

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!\n" + "May I have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }

    public static void entrance() {
        System.out.println("Please enter the game number and press Enter.");
        for (EntranceOptions option : EntranceOptions.values()) {
            if (option.getId() == null) {
                continue;
            }
            System.out.println(option.getId() + " - " + option.getTitle());
        }
        System.out.println("Your choice: ");
//        int choice = scanner.nextInt();
        int choice = 1;

        if (choice == EntranceOptions.GREET.getId()) {
            greeting();
        }
        if (choice == EntranceOptions.EXIT.getId()) {
            exit();
        }
        exit();
    }

    public static void exit() {
        scanner.close();
        System.exit(0);
    }
}
