package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String RULE_OF_EVEN_GAME = "What is the result of the expression?";
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final String[] MATH_OPERATIONS = {" + ", " - ", " * "};
    private static final int START_ARRAY = 0;

    public static void startCalcGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int firstRandNum = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondRandNum = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String mathOperator =
                    MATH_OPERATIONS[Utils.numRandomize(START_ARRAY, MATH_OPERATIONS.length)];
            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] =
                    firstRandNum + mathOperator + secondRandNum;
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] =
                    Integer.toString(calcExpression(mathOperator, firstRandNum, secondRandNum));
        }
        Engine.runGame(RULE_OF_EVEN_GAME, gameQuestionsAndAnswers);
    }

    private static int calcExpression(String mathOperator, int firstRandNum, int secondRandNum) {
        return switch (mathOperator) {
            case " + " -> firstRandNum + secondRandNum;
            case " - " -> firstRandNum - secondRandNum;
            case " * " -> firstRandNum * secondRandNum;
            default -> throw new IllegalArgumentException("Unknown operator!");
        };
    }
}
