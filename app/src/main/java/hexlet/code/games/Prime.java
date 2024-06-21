package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static final String RULE_OF_EVEN_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startPrimeGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int questionNumber = Engine.numberRandomize();
            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] = Integer.toString(questionNumber);
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] = isPrime(questionNumber);
        }
        Engine.runGame(RULE_OF_EVEN_GAME, gameQuestionsAndAnswers);
    }

    public static String isPrime(int questionNumber) {
        if (questionNumber == 1) {
            return "no";
        }
        String answer = "yes";
        for (int i = 2; i <= Math.sqrt(questionNumber); i++) {
            if ((questionNumber % i) == 0) {
                answer = "no";
                break;
            }
        }
        return answer;
    }
}
