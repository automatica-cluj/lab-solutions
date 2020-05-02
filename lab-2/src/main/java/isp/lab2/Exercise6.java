package isp.lab2;

public class Exercise6 {
    private static int[] vector;

    /**
     * This method should generate the required vector non-recursively
     *
     * @param n the length of teh generated vector
     * @return the generated vector
     */
    public static int[] generateVector(int n) {
        int i;
        int[] x = new int[n];
        x[0] = 1;
        x[1] = 2;
        for (i = 2; i < n; i++) {
            x[i] = x[i - 1] * x[i - 2];
        }
        return x;
    }

    /**
     * This method should generate the required vector recursively
     *
     * @param n the length of teh generated vector
     * @return the generated vector
     */
    public static int[] generateRandomVectorRecursively(int n) {
        if (vector == null) {
            vector = new int[n];
            vector[0] = 1;
            vector[1] = 2;
        }

        if (n > 2) {
            generateRandomVectorRecursively(n - 1);
            vector[n - 1] = vector[n - 2] * vector[n - 3];
        }

        return vector;
    }

    public static void main(String[] args) {
        for (int i : generateVector(8)){
            System.out.println(i);
        }

        for (int i : generateRandomVectorRecursively(8)){
            System.out.println(i);
        }
    }
}
