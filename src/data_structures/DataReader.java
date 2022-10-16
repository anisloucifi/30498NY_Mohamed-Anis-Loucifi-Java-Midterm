package data_structures;

import databases.SharedStepsDatabase;

import  java.io.*;
import java.util.*;


public class DataReader {

    /** INSTRUCTIONS
     *
     * Create an API to read the .txt file and print it to the console.
     *      HINT: Use BufferedReader class
     * Use try-catch block to handle any exceptions
     *
     * Store and retrieve the file to/from a database table.
     *
     * After reading from file using BufferedReader API, store each word, first into a LinkedList. Each word
     * should construct a node in LinkedList. Second, do the same, but with a Stack.
     * Finally, traverse through the list\stack & retrieve each item in `FIFO` order and `FILO` order, respectively
     *
     * Demonstrate how to use a stack using push, peek, search & pop methods.
     * Use For-Each & While-loop with Iterator to retrieve/print data.
     **/

    public static void main(String[] args) {
        String textFilePath = System.getProperty("user.dir") + "/src/data_structures/data/self-driving-car.txt";

        SharedStepsDatabase sql = new SharedStepsDatabase();
        File file = new File(textFilePath);

        //printing file in the console using try catch with resources
        String text = "";

        try (FileInputStream inp = new FileInputStream(file);
             InputStreamReader reader = new InputStreamReader(inp);
             BufferedReader buffere = new BufferedReader(reader)) {
            String Line;
            while ((Line = buffere.readLine()) != null) {
                text = text + Line;
                System.out.println(Line);

            }


        } catch (FileNotFoundException e) {
            System.out.println("file doesn't exist ");

        } catch (IOException e) {
            System.out.println("could not read from file");
        }




        SharedStepsDatabase sql2 = new SharedStepsDatabase();
        sql2.insertString("file_content", "file_column", text);

        //retrieve file content from db
        String query = "SELECT file_column From file_content ";
        String textdb = null;
        try {

            textdb = sql2.executeQueryReadOne(query);
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("the content text from db " + "\n" + textdb);

        // here we  store  words in a string array
        text = text.replaceAll("\\p{Punct}", "");//we replace punctuation with empty string
        String[] arrayWord = text.trim().split(" ");
        // store  words in LInkedList
        LinkedList<String> Word = new LinkedList<String>();

        for (String s : arrayWord) {
            Word.add(s);
        }

        //retreive fifo
        for (String s : Word) {
            System.out.println(s);
        }
        //retreive   filo
        ListIterator<String> Iter = Word.listIterator(Word.size());
        while (Iter.hasPrevious()) {
            System.out.println(Iter.previous());
        }

        //using  Stack to store words
        Stack<String> stack = new Stack<String>();

        for (String str : arrayWord) {
            stack.push(str);
        }
        //retreive stack fifo
        for (String s : stack) {
            System.out.println(s);
        }


        //using iterator
        Iterator<String> iter = stack.iterator();
        while (iter.hasNext()) {
            String s = stack.pop();
            System.out.println(s);
        }

        //using stack
        Stack <Integer> stack1 = new Stack<>();
        System.out.println("stack is empty : " +stack1.isEmpty());
        //push
        stack1.push(4);
        stack1.push(6);
        stack1.push(8);
        stack1.push(1);
        stack1.push(9);
        System.out.println("stack is empty:"+stack1.isEmpty());
        //peek return the top element
        Integer i =stack1.peek();
        System.out.println("top element  "+i);

        //search return the position of given element
        int position = stack1.search(8);
        System.out.println("position of 8 "+ position);
        //pop retreive and delete top element
        System.out.println(stack1.pop());
        System.out.println("stack now after deleting top"+stack1);
        //using for each loop
        for(Integer a : stack1){
            System.out.println(a);
        }
        //using while with iterator
        Iterator<Integer> itr = stack1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



    }

    }

