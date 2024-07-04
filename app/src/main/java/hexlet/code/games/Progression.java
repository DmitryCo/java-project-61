package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final String RULE_OF_PROGRESSION_GAME = "What number is missing in the progression?";
    private static final int MIN_PROGRESSION_LENGTH = 8;
    private static final int MAX_PROGRESSION_LENGTH = 11;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_STEP_PROGRESSION = 1;
    private static final int MAX_STEP_PROGRESSION = 10;

    public static void startProgressionGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int length = Utils.numRandomize(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int firstRandNum = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int step = Utils.numRandomize(MIN_STEP_PROGRESSION, MAX_STEP_PROGRESSION);

            int[] progression = getProgression(length, firstRandNum, step);
            int hiddenNum = (Utils.numRandomize(MIN_RANDOM_NUMBER, length));
            String progressionWithHiddenNum =
                    String.join(" ", getProgressionWithHiddenNum(progression, hiddenNum));

            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] = progressionWithHiddenNum;
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] =
                    Integer.toString(progression[hiddenNum]);
        }
        Engine.runGame(RULE_OF_PROGRESSION_GAME, gameQuestionsAndAnswers);
    }

    private static int[] getProgression(int length, int firstRandNum, int step) {
        int[] progression = new int[length];
        for (int i = 0; i < progression.length; i++) {
            progression[i] = firstRandNum + step * i;
        }
        return progression;
    }

    private static String[] getProgressionWithHiddenNum(int[] progression, int hiddenNum) {
        String[] progressionWithHiddenNum = new String[progression.length];
        for (int i = 0; i < progression.length; i++) {
            progressionWithHiddenNum[i] = Integer.toString(progression[i]);
        }
        progressionWithHiddenNum[hiddenNum] = "..";
        return progressionWithHiddenNum;
    }
}
