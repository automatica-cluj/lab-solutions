package isp.lab2;

public class Exercise4 {
    private static final String POSITION = "Position: ";

    /**
     * This method should verify if a number is prime
     *
     * @param number the number to check
     * @return true if number is prime and false otherwise
     */
    public static boolean isPrimeNumber(final int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method should get the first(by position) odd number from the given array
     *
     * @param someNumbers the given int array
     * @return first odd number from the array
     */
    public static int firstOdd(int[] someNumbers) {
        for (int i = 0; i < someNumbers.length; i++) {
            if (someNumbers[i] % 2 != 0) {
                System.out.println(POSITION + i);
                return someNumbers[i];
            }
        }
        return -1;
    }

    /**
     * This method should get the first(by position) even number from the given array
     *
     * @param someNumbers the given int array
     * @return first even number from the array
     */
    public static int firstEven(int[] someNumbers) {
        for (int i = 0; i < someNumbers.length; i++)
            if (someNumbers[i] % 2 == 0) {
                System.out.println(POSITION + i);
                return someNumbers[i];
            }
        return -1;
    }

    /**
     * This method should get the first(by position) prime number from the given array
     *
     * @param someNumbers the given int array
     * @return first prime number from the array
     */
    public static int firstPrime(int[] someNumbers) {
        for (int i = 0; i < someNumbers.length; i++) {
            if (isPrimeNumber(someNumbers[i])) {
                System.out.println(POSITION + i);
                return someNumbers[i];
            }
        }
        return -1;
    }

    /**
     * Don't forget to also display the position of ech number
     */
    public static void main(String[] args) {
        int[] someNumbers = new int[]{13, 18, 13, 22, 21, 11, 57, 141, 563, 16};

        System.out.println("First odd number: " + firstOdd(someNumbers));
        System.out.println("First even number: " + firstEven(someNumbers));
        System.out.println("First prime number: " + firstPrime(someNumbers));
    }
}
