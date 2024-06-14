package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;

    public static void runGame() {
        System.out.println("\nWelcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + '!');
    }

    public static String getUserName() {
        return userName;
    }
}
