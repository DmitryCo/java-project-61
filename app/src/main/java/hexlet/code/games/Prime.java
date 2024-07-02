package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final String RULE_OF_EVEN_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startPrimeGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int questionNumber = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] = Integer.toString(questionNumber);
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] = isPrime(questionNumber) ? "yes" : "no";
        }
        Engine.runGame(RULE_OF_EVEN_GAME, gameQuestionsAndAnswers);
    }

    public static boolean isPrime(int questionNumber) {
        if (questionNumber == 1) {
            return false;
        }
        boolean answer = true;
        for (int i = 2; i <= Math.sqrt(questionNumber); i++) {
            if ((questionNumber % i) == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
