package data_structures;

import databases.SharedStepsDatabase;

import java.util.*;

public class UseQueue {

    /**
     * INSTRUCTIONS
     * <p>
     * Demonstrate how to use Queue that includes add, peek, remove & poll methods.
     * Use For-Each loop and While-Loop with Iterator to retrieve data.
     * <p>
     * Store and retrieve data from/to a database table.
     */


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        //use peek return the head of queue
        int a = q.peek();
        System.out.println(a);

        q.remove(1); // remove the element contains integer 1
        System.out.println(q.poll());//  print the first element and remove it from the queue

        System.out.println("final output of the queue ");
        for (Integer i : q) {
            System.out.println(i);
        }
        Iterator<Integer> itr = q.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        List l=(List) q;
        System.out.println(l);

        SharedStepsDatabase sql = new SharedStepsDatabase();
        try {
            System.out.println("true");
            sql.insertList("queue","listQueue", (ArrayList<String>) l);

        } catch (Exception e) {
            System.out.println(e);
        }





    }
    }


