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
            int firstRandomNumber = Utils.numRandomize(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int stepProgression = Utils.numRandomize(MIN_STEP_PROGRESSION, MAX_STEP_PROGRESSION);

            int[] progressionArray = getProgression(progressionLength, firstRandomNumber, stepProgression);
            int indexOfHiddenProgressionNumber = (Utils.numRandomize(MIN_RANDOM_NUMBER, progressionLength));
            String progressionArrayWithHiddenNumber =
                    getProgressionWithHiddenNumber(progressionArray, indexOfHiddenProgressionNumber);

            gameQuestionAndAnswer[Engine.INDEX_OF_QUESTION_IN_ARRAY] = progressionArrayWithHiddenNumber;
            gameQuestionAndAnswer[Engine.INDEX_OF_CORRECT_ANSWER_IN_ARRAY] =
                    Integer.toString(progressionArray[indexOfHiddenProgressionNumber]);
        }
        Engine.runGame(RULE_OF_PROGRESSION_GAME, gameQuestionsAndAnswers);
    }

    public static int[] getProgression(int progressionLength, int firstRandomNumber, int stepProgression) {
        int[] progression = new int[progressionLength];
        progression[0] = firstRandomNumber;
        int nextNumberInProgression = firstRandomNumber;
        for (int i = 1; i < progression.length; i++) {
            nextNumberInProgression += stepProgression;
            progression[i] = nextNumberInProgression;
        }
        return progression;
    }

    public static String getProgressionWithHiddenNumber(int[] progressionArray, int indexOfHiddenProgressionNumber) {
        String[] progressionWithHiddenNumber = new String[progressionArray.length];
        for (int i = 0; i < progressionArray.length; i++) {
            progressionWithHiddenNumber[i] = Integer.toString(progressionArray[i]);
        }
        progressionWithHiddenNumber[indexOfHiddenProgressionNumber] = "..";
        return String.join(" ", progressionWithHiddenNumber);
    }
}
