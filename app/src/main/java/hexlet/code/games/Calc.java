package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static final String RULE_OF_EVEN_GAME = "What is the result of the expression?";
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final String[] MATH_OPERATIONS = {" + ", " - ", " * "};

    public static void startCalcGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int firstRandomNumber = Engine.numberRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int secondRandomNumber = Engine.numberRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String mathOperator = Engine.mathOperationRandomize(MATH_OPERATIONS);
            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] =
                    firstRandomNumber + mathOperator + secondRandomNumber;
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] =
                    calcExpression(mathOperator, firstRandomNumber, secondRandomNumber);
        }
        Engine.runGame(RULE_OF_EVEN_GAME, gameQuestionsAndAnswers);
    }

    public static String calcExpression(String mathOperator, int firstRandomNumber, int secondRandomNumber) {
        return switch (mathOperator) {
            case " + " -> Integer.toString(firstRandomNumber + secondRandomNumber);
            case " - " -> Integer.toString(firstRandomNumber - secondRandomNumber);
            case " * " -> Integer.toString(firstRandomNumber * secondRandomNumber);
            default -> null;
        };
    }
}
