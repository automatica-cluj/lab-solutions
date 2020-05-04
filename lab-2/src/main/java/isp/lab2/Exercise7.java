package isp.lab2;

import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * This method should generate a random number which
     * represent the position in the given arrays,so
     * the random should be between 0 and 7
     *
     * @return the generated random
     */
    public static int generateARandom() {
        return RANDOM.nextInt(8);
    }

    public static void main(String[] args) {
        int[] ucl = new int[]{1, 2, 3, 4, 5, 6, 7, 13};
        int[] answers = new int[]{10, 4, 2, 1, 2, 1, 1, 1};
        int times = generateARandom();

        int counter = 0;
        System.out.println("How many teams win the UCL trophy " + ucl[times] + " times?");

        while (counter <= 1) {
            int answer = SCANNER.nextInt();
            if (answer > answers[times] && counter < 1) {
                System.out.println("Lower");
            } else if (answer < answers[times] && counter < 1) {
                System.out.println("Bigger");
            } else if (answer == answers[times] && counter < 1) {
                System.out.println("Correct!");
                System.exit(0);
            }
            counter++;
        }
        System.out.println("You lost");
    }
}


