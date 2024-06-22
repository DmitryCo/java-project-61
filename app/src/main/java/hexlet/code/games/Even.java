package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static final String RULE_OF_EVEN_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startEvenGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int questionNumber = Engine.numberRandomize();
            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] = Integer.toString(questionNumber);
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] = isEven(questionNumber);
        }
        Engine.runGame(RULE_OF_EVEN_GAME, gameQuestionsAndAnswers);
    }

    public static String isEven(int questionNumber) {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
