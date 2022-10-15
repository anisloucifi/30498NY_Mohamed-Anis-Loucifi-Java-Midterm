package math_problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class FindLowestDifference {

    /**
     * INSTRUCTIONS
     * Write a method to return the lowest number, that is not shared between the 2 arrays below
     * HINT: The lowest number that isn't shared between these arrays is 1
     */

    public static void main(String[] args) {


        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};

        ArrayList<Integer> low = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            if (array2[i] != array1[i]) {
                low.add(array1[i]);
            }
        }
        for (int i = 0; i < array2.length; i++) {
            if (array1[i] != array2[i]) {
                low.add(array2[i]);
            }
        }
        Collections.sort(low);
        System.out.println("the lowest number is : " + low.get(0));

    }

}






