package isp.lab2;

import java.util.Arrays;
import java.util.Random;

public class Exercise5 {
    private static final Random RANDOM = new Random();

    /**
     * This method should generate an array that have 20 random nubers between -1000 and 1000
     *
     * @return the random numbers
     */
    public static int[] generateRandomNumbers() {
        int min = -1000;
        int max = 1000;
        int[] randomNumbers = new int[20];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = RANDOM.nextInt(max + 1 - min) + min;
        }
        return randomNumbers;
    }

    /**
     * This method should sort the given random numbers
     *
     * @param randomNumbers numbers generated random
     * @return sorted int array
     */
    public static int[] getSortedNumbers(int[] randomNumbers) {
        int n = randomNumbers.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (randomNumbers[j] > randomNumbers[j + 1]) {
                    int temp = randomNumbers[j];
                    randomNumbers[j] = randomNumbers[j + 1];
                    randomNumbers[j + 1] = temp;
                }
        return randomNumbers;
    }

    public static void main(String[] args) {
        int[] randomNumbers = generateRandomNumbers();
        System.out.println("The random generated numbers are:");
        System.out.println(Arrays.toString(randomNumbers));

        System.out.println("The sorted numbers are:");
        System.out.println(Arrays.toString(getSortedNumbers(randomNumbers)));
    }
}
