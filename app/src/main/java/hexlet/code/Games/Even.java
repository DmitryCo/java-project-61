package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static final int totalCorrectAnswersForWin = 3;
    private static int winCounter = 0;


    static void startEvenGame() {
        // Rules of the game
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (winCounter < totalCorrectAnswersForWin) {
            int randomNumber = randomize();
            System.out.println("Question: " + randomNumber);
            String correctAnswer = ((randomNumber % 2) == 0) ? "yes" : "no";
            String answer = getAnswer();
            System.out.println("Your answer: " + answer);
                if ((answer.equals("yes") && ((randomNumber % 2) == 0))) {
                    winCounter++;
                    System.out.println("Correct!");
                } else if ((answer.equals("no") && ((randomNumber % 2) != 0))) {
                    winCounter++;
                    System.out.println("Correct!");
                }
                else {
                    System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'.\n"
                            + "Let's try again, ");
                    break;
                }
            }

        System.out.println("Congratulations, " + Cli.userName + "!");
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
