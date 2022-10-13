package data_structures;

import databases.SharedStepsDatabase;

import java.util.*;

public class UseArrayList {

    /**
     * INSTRUCTIONS
     * <p>
     * Demonstrate how to use an ArrayList that includes using the add, peek, remove & retrieve methods.
     * Use For-Each loop and While-loop with Iterator to retrieve the data.
     * <p>
     * Store and retrieve the data from/to a database table.
     */

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("anis");
        array.add("khalil");
        array.add("chams");
        array.add("rahim");

        //     array.p
        Iterator<String> itr = array.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());

        }

        for (String s : array) {
            System.out.println(s);

        }
        SharedStepsDatabase a = new SharedStepsDatabase();


        a.insertList("test", "test", array);
        List<String> arr = null;
        try {
            System.out.println("true");
            arr = a.executeQueryReadAllSingleColumn("select * from test", "test");

        } catch (Exception e) {
            System.out.println(e);
        }
        for (String s : arr) {
            System.out.println(s);
        }

    }
}