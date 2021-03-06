package hexlet.code.games;

import hexlet.code.Engine;


import static hexlet.code.Utils.MAX_NUMBER;
import static hexlet.code.Utils.generateRandom;

public class GCD {

    public static final String GCD = "GCD";
    static final String RULES_GAME = "Find the greatest common divisor of given numbers.";


    private static String findGCD(int firstNumber, int secondNumber) {
        int differences = Math.max(firstNumber, secondNumber) - Math.min(firstNumber, secondNumber);
        int minNumber = Math.min(firstNumber, secondNumber);
        if (minNumber == 0) {
            return String.valueOf(differences);
        } else {
            while (differences != minNumber) {
                firstNumber = differences;
                differences = Math.max(differences, minNumber) - Math.min(differences, minNumber);
                minNumber = Math.min(firstNumber, minNumber);
            }
            return String.valueOf(minNumber);
        }
    }

    public static void start() {
        String[] questions = new String[Engine.ROUNDS];
        String[] answers = new String[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstNumber = generateRandom(MAX_NUMBER);
            int secondNumber = generateRandom(MAX_NUMBER);
            questions[i] = firstNumber + " " + secondNumber;
            answers[i] = findGCD(firstNumber, secondNumber);
        }
        Engine.start(new String[][]{questions, answers}, RULES_GAME);
    }
}
