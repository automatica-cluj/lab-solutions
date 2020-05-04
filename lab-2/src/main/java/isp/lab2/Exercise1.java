package isp.lab2;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    private static final Random RANDOM = new Random();

    /**
     * This method should generate an random number between 2 and 10 then
     * should ask user to enter that amount of numbers from keyboard and
     * store the numbers in an int array which should be returned
     *
     * @return the array of numbers read from keyboard
     */
    private static int[] getUserNumbers() {
        int min = 2;
        int max = 10;
        int amountOfNumbers = RANDOM.nextInt(max + 1 - min) + min;

        System.out.println("Type " + amountOfNumbers + " numbers: \n");

        Scanner scanner = new Scanner(System.in);
        int[] v = new int[amountOfNumbers];

        for (int i = 0; i < amountOfNumbers; i++) {
            v[i] = scanner.nextInt();
        }
        return v;
    }


    /**
     * This method should compute the arithmetical mean of the given numbers
     *
     * @param userNumbers the numbers inserted by the User
     * @return the arithmetical mean of the given numbers
     */
    public static int computeTheArithmeticalMean(int[] userNumbers) {
        int sum = 0;
        for (int userNumber : userNumbers) {
            sum = sum + userNumber;
        }
        if (userNumbers.length > 0) {
            return sum / userNumbers.length;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] userNumbers = getUserNumbers();
        System.out.println("Mean number is: " + computeTheArithmeticalMean(userNumbers));
    }
}
