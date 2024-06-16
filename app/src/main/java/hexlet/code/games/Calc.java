package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static final String RULE_OF_EVEN_GAME = "What is the result of the expression?";

    public static String[] mathOperations = {" + ", " - ", " * "};

    public static void startCalcGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int firstRandomNumber = Engine.numberRandomize();
            int secondRandomNumber = Engine.numberRandomize();
            String mathOperator = Engine.mathOperationRandomize(mathOperations);
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
