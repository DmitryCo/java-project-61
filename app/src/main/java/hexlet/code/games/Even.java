package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static final int TOTAL_CORRECT_ANSWERS_FOR_WIN = 3;
    // Starting win counter
    private static int winCounter = 0;

    public static void startEvenGame() {
        // Rules of the game
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (winCounter < TOTAL_CORRECT_ANSWERS_FOR_WIN) {
            int randomNumber = randomize();
            System.out.println("Question: " + randomNumber);
            String correctAnswer = ((randomNumber % 2) == 0) ? "yes" : "no";

            String userAnswer;
            System.out.print("Your answer: ");
            userAnswer = getAnswer();

            if ((userAnswer.equals("yes") && ((randomNumber % 2) == 0))) {
                winCounter++;
                System.out.println("Correct!");
            } else if ((userAnswer.equals("no") && ((randomNumber % 2) != 0))) {
                winCounter++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'"
                        + correctAnswer + "'.\n" + "Let's try again, " + Engine.getUserName() + "!");
                break;
            }
        }

        if (winCounter == 3) {
            System.out.println("Congratulations, " + Engine.getUserName() + "!");
        }
    }

    static int randomize() {
        Random random = new Random();
        int minRandomNumber = 1;
        int maxRandomNumber = 100;

        return random.nextInt(minRandomNumber, maxRandomNumber);
    }

    static String getAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
