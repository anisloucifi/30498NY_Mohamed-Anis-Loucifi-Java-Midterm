package math_problems;

public class FindMissingNumber {

    /**
     * INSTRUCTIONS
     * Write a method to find the missing number from the array.
     */

    public static void main(String[] args) {
        int[] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
        int L = array.length;

        // Function call
        System.out.println(getMissingNumber(array, L));
    }


    static int getMissingNumber(int a[], int n) {
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }

    // Driver Code
}
