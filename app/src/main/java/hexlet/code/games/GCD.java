package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static final String RULE_OF_GCD_GAME = "Find the greatest common divisor of given numbers.";
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startGCDGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int firstRandomNumber = Engine.numberRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondRandomNumber = Engine.numberRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] =
                    firstRandomNumber + " " + secondRandomNumber;
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] =
                    defineGCD(firstRandomNumber, secondRandomNumber);
        }
        Engine.runGame(RULE_OF_GCD_GAME, gameQuestionsAndAnswers);
    }

    public static String defineGCD(int firstRandomNumber, int secondRandomNumber) {
        if (secondRandomNumber == 0) {
            return Integer.toString(firstRandomNumber);
        }
        return defineGCD(secondRandomNumber, firstRandomNumber % secondRandomNumber);
    }
}
