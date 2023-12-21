package games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    static final int INTERVAL = 100;
    static final int UNATTAINABLE_NUMBER = 999;
    static final int INTERVAL_CHOICE = 10;
    public static void startsTheGameProgression() {
        String userName = Cli.greetsThePlayer();

        String rules = "What number is missing in the progression?";

        int countAnswer = 0;

        Random random = new Random();
        int numberOfRounds = 3;
        int startNumber;
        int countStep;
        int numberMissing;
        int arrayLength = 10;

        for (int i = 0; i < numberOfRounds; i++) {

            if (countAnswer == -1) {
                break;
            }
            int[] numbers = new int[arrayLength];
            startNumber = random.nextInt(INTERVAL);
            countStep = random.nextInt(INTERVAL_CHOICE);
            numberMissing = random.nextInt(INTERVAL_CHOICE);
            numbers[0] = startNumber;
            for (int j = 1; j < numbers.length; j++) {
                numbers[j] = startNumber + countStep;
                startNumber = numbers[j];
            }
            int correctAnswer = numbers[numberMissing];
            String correctAnswerToString = Integer.toString(correctAnswer);

            numbers[numberMissing] = UNATTAINABLE_NUMBER;

            String processedString = Arrays.toString(numbers);
            processedString = processedString.replace("[", "").replace("]", "").replace(",", "").replace("999", "..");

            String question = "Question: " + processedString;
            countAnswer = Engine.upEngine(userName, rules, question, correctAnswerToString, i, countAnswer);
        }
    }
}
