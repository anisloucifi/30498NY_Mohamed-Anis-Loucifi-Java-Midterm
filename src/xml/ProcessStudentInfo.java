package xml;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import databases.SharedStepsDatabase;
import org.xml.sax.SAXException;


public class ProcessStudentInfo {

    /**
     * INSTRUCTIONS
     * Take a look at the XmlReader class, found within this package. Try to understand what the parseData() method
     * is doing. This is essential to figuring out how to implement the remainder of this exercise.
     * <p>
     * In that XmlReader class, you need to implement the method called "convertIntToChar()" which should convert the
     * student number scores into corresponding letter grades:
     * 90 - 100 = 'A'
     * 80 - 89  = 'B'
     * 70 - 79  = 'C'
     * <p>
     * Here, in the main method, extend the code that is written and meant to get you started. You must parse the
     * students' information contained within the XML files into 2 separate ArrayList's (One for Selenium students and
     * the other for QTP Students) and then store those lists into the provided HashMap
     * <p>
     * Then, you must use a combination of an iterator and a while-loop to print out the stored data.
     * Your output should be formatted EXACTLY like the example below:
     * ......................................................
     * Student ID: 1
     * First Name: Ibrahim
     * Last Name:  Khan
     * GRADE:      B
     * <p>
     * Student ID: 2
     * First Name: Asif
     * Last Name:  Roni
     * GRADE:      A
     * <p>
     * Student ID: 3
     * First Name: Asif
     * Last Name:  Roni
     * GRADE:      C
     * ......................................................
     * <p>
     * Finally, you must store all student data into a database table, called `selenium_students`
     * Use any database (MongoDB, Oracle MySQL, PostgreSQL) to store and retrieve data.
     **/

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // To get you started, your system's abs path has been initialized and some add'l variables have been declared
        String systemPath = System.getProperty("user.dir");
        String seleniumDocRelativePath;
        String qtpDocRelativePath;
        String seleniumDocPath;
        String qtpDocPath;
        String tag = "id";
        seleniumDocRelativePath = systemPath + File.separator + "src" + File.separator + "xml" + File.separator + "data" + File.separator + "selenium.xml";
        qtpDocRelativePath = systemPath + File.separator + "src" + File.separator + "xml" + File.separator + "data" + File.separator + "qtp.xml";
        XmlReader sel = new XmlReader();

        List<Student> stdlistselin = new ArrayList<>();
        List<Student> stdlistqtp = new ArrayList<>();
        stdlistselin = sel.parseData(tag, seleniumDocRelativePath);
        stdlistqtp = sel.parseData(tag, qtpDocRelativePath);
        System.out.println(stdlistselin + "\n");
        System.out.println(stdlistqtp + "\n");

        /*
         Here is a map that you'll be using to store 2 lists. One will contain Selenium students, the other will
         contain QTP students
         */
        Map<String, List<Student>> studentMap = new LinkedHashMap<String, List<Student>>();

        studentMap.put("selenium", stdlistselin);
        studentMap.put("qtp", stdlistqtp);
        List<Student> Students = new ArrayList<Student>();
        Students.addAll(stdlistselin);
        Students.addAll(stdlistqtp);
        Iterator<Map.Entry<String, List<Student>>> itrmap = studentMap.entrySet().iterator();
        while (itrmap.hasNext()) {
            itrmap.next();
        }

        for (Student s : Students) {
            System.out.print("Student ID:" + s.getId() + "\t" + "\n");
            System.out.print("First Name:" + s.getFirstName() + "\t" + "\n");
            System.out.print("Last Name:" + s.getLastName() + "\t" + "\n");
            System.out.print("GRADE:" + s.getScore() + "\t" + "\n");
            System.out.print(" ");
            System.out.println();
        }
        List<String> FirstName = new ArrayList<String>();
        List<String> LastName = new ArrayList<String>();
        List<String> grade = new ArrayList<String>();
        for (Student s : Students) {
            FirstName.add(s.getFirstName());
            LastName.add(s.getLastName());
            grade.add(String.valueOf(s.getScore()));

            SharedStepsDatabase sql = new SharedStepsDatabase();
            sql.insertList("FirstName_xml", "first_name", (ArrayList<String>) FirstName);
            sql.insertList("LastName_xml", "last_Name", (ArrayList<String>) LastName);
            sql.insertList("Grade_xml", "grade", (ArrayList<String>) grade);


//
//        // Implement the rest below, as per the instructions

        }
    }
}
