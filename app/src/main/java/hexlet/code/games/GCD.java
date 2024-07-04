package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String RULE_OF_GCD_GAME = "Find the greatest common divisor of given numbers.";
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void startGCDGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int firstRandNum = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondRandNum = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] =
                    firstRandNum + " " + secondRandNum;
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] =
                    Integer.toString(defineGCD(firstRandNum, secondRandNum));
        }
        Engine.runGame(RULE_OF_GCD_GAME, gameQuestionsAndAnswers);
    }

    private static int defineGCD(int firstRandNum, int secondRandNum) {
        if (secondRandNum == 0) {
            return firstRandNum;
        }
        return defineGCD(secondRandNum, firstRandNum % secondRandNum);
    }
}
