package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TOTAL_CORRECT_ANSWERS_FOR_WIN = 3;
    public static final int NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY = 2;
    public static final int INDEX_OF_QUESTION_IN_ARRAY = 0;
    public static final int INDEX_OF_CORRECT_ANSWER_IN_ARRAY = 1;

    public static void runGame(String ruleOfGame, String[][] gameQuestionsAndAnswers) {
        System.out.println("\nWelcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + '!');
        System.out.println(ruleOfGame);

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            String question = gameQuestionAndAnswer[INDEX_OF_QUESTION_IN_ARRAY];
            String answer = gameQuestionAndAnswer[INDEX_OF_CORRECT_ANSWER_IN_ARRAY];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'"
                        + answer + "'.\n" + "Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
