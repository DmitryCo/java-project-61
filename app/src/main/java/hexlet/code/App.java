package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit
            """);

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        System.out.print("Your choice: ");
        userChoice = scanner.next();
        selectGames(userChoice);
    }

    private static void selectGames(String userChoice) {
        switch (userChoice) {
            case "1" -> Cli.getUserName();
            case "2" -> Even.startEvenGame();
            case "3" -> Calc.startCalcGame();
            case "4" -> GCD.startGCDGame();
            case "5" -> Progression.startProgressionGame();
            case "6" -> Prime.startPrimeGame();
            case "0" -> System.out.println("Goodbye! See you later!");
            default -> throw new IllegalArgumentException("Wrong number entered. Please try again.");
        }
    }
}
