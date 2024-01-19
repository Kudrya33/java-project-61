package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    static final int NUMBER_OF_ROUNDS = 3;
    public static void startsTheGameEven() {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = Utils.getArray(3);
        String[] answers = Utils.getArray(3);

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            int evenNumber = Utils.getRandomInt(0, 100);

            String correctAnswer = Integer.toString(answerToQuestion(evenNumber)).equals("0") ? "Yes" : "No";
            String question = "Question: " + evenNumber;

            questions[i] = question;
            answers[i] = correctAnswer;
        }
        Engine.upEngine(rules, questions, answers);
    }
    public static int answerToQuestion(int evenNumber) {
        return evenNumber % 2 == 0 ? 0 : 1;
    }
}
