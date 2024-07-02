package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String RULE_OF_PROGRESSION_GAME = "What number is missing in the progression?";
    public static final int MIN_PROGRESSION_LENGTH = 8;
    public static final int MAX_PROGRESSION_LENGTH = 11;
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MIN_STEP_PROGRESSION = 1;
    public static final int MAX_STEP_PROGRESSION = 10;

    public static void startProgressionGame() {
        String[][] gameQuestionsAndAnswers =
                new String[Engine.TOTAL_CORRECT_ANSWERS_FOR_WIN][Engine.NUMBER_OF_ELEMENTS_OF_GAME_IN_ARRAY];

        for (String[] gameQuestionAndAnswer : gameQuestionsAndAnswers) {
            int progressionLength = Utils.numRandomize(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int firstRandomNum = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int stepProgression = Utils.numRandomize(MIN_STEP_PROGRESSION, MAX_STEP_PROGRESSION);

            int[] progressionArray = getProgression(progressionLength, firstRandomNum, stepProgression);
            int indexOfHiddenNum = (Utils.numRandomize(MIN_RANDOM_NUMBER, progressionLength));
            String progressionArrayWithHiddenNum =
                    String.join(" ", getProgressionWithHiddenNum(progressionArray, indexOfHiddenNum));

            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] = progressionArrayWithHiddenNum;
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] =
                    Integer.toString(progressionArray[indexOfHiddenNum]);
        }
        Engine.runGame(RULE_OF_PROGRESSION_GAME, gameQuestionsAndAnswers);
    }

    public static int[] getProgression(int progressionLength, int firstRandomNum, int stepProgression) {
        int[] progression = new int[progressionLength];
        progression[0] = firstRandomNum;
        int nextNumInProgression = firstRandomNum;
        for (int i = 1; i < progression.length; i++) {
            nextNumInProgression += stepProgression;
            progression[i] = nextNumInProgression;
        }
        return progression;
    }

    public static String[] getProgressionWithHiddenNum(int[] progressionArray, int indexOfHiddenNum) {
        String[] progressionWithHiddenNum = new String[progressionArray.length];
        for (int i = 0; i < progressionArray.length; i++) {
            progressionWithHiddenNum[i] = Integer.toString(progressionArray[i]);
        }
        progressionWithHiddenNum[indexOfHiddenNum] = "..";
        return progressionWithHiddenNum;
    }
}
