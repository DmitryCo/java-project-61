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
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");

        Scanner scanner = new Scanner(System.in);
        int userChoice;
        System.out.print("Your choice: ");
        userChoice = Integer.parseInt(scanner.next());
        selectGames(userChoice);
    }

    static void selectGames(int userChoice) {
        switch (userChoice) {
            case 1:
                Cli.getUserName();
                break;
            case 2:
                Even.startEvenGame();
                break;
            case 3:
                Calc.startCalcGame();
                break;
            case 4:
                GCD.startGCDGame();
                break;
            case 5:
                Progression.startProgressionGame();
                break;
            case 6:
                Prime.startPrimeGame();
                break;
            case 0:
                System.out.println("0 - Exit");
                break;
            default:
                System.out.println("Wrong number entered. Please try again.");
        }
    }
}
