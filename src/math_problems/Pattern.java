package math_problems;

public class Pattern {

    /**
     * INSTRUCTIONS
     * Read the numbers below, identify the pattern, and then implement the logic from this pattern.
     * Once done, you should test to see if you get the same output as below:
     * <p>
     * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32...
     */

    public static void main(String[] args) {

        for (int i = 100; i >= 90; i--) {
            System.out.println(i);
        }

        for (int i = 88; i >= 70; i -= 2) {
            System.out.println(i);
        }

        for (int i = 67; i >= 40; i -= 3) {
            System.out.println(i);
        }
        for (int i = 40; i >= 0; i -= 4) {
            System.out.println(i);
        }
    }
}
