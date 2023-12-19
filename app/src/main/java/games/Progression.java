package games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    public static void startsTheGameProgression() {
        String userName = Cli.greetsThePlayer();

        String rulesOfTheGame = "What number is missing in the progression?";

        int countCorrectAnswer = 0;

        Random random = new Random();

        for (int i = 0; i < 3; i++) {

            if (countCorrectAnswer == -1) {
                break;
            }
            int[] numbers = new int[10];
            int startNumber = random.nextInt(100);
            int countStep = random.nextInt(10);
            int numberMissing = random.nextInt(10);
            numbers[0] = startNumber;
            for (int j = 1; j < numbers.length; j++) {
                numbers[j] = startNumber + countStep;
                startNumber = numbers[j];
            }
            int correctAnswer = numbers[numberMissing];
            String correctAnswerToString = Integer.toString(correctAnswer);

            numbers[numberMissing] = 999;

            String processedString = Arrays.toString(numbers);
            processedString = processedString.replace("[", "").replace("]", "").replace(",", "").replace("999", "..");

            String question = "Question: " + processedString;
            countCorrectAnswer = Engine.launchEngine(userName, rulesOfTheGame, question, correctAnswerToString, i, countCorrectAnswer);
        }
    }
}