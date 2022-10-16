package company_app_design;

import java.util.Scanner;

public class EmployeeInfo extends EmployeeParent {

    /**
     * INSTRUCTIONS
     * <p>
     * This class should implement the Employee interface, but you must do that without using the keyword `implements`
     * anywhere in this class.
     * <p>
     * HINT: Take a look at the collections framework diagram. Do you see how a class may implement an interface without
     * directly implementing it?
     * <p>
     * YOU MUST USE/DO:
     * OOP (Abstraction, Encapsulation, Inheritance and Polymorphism) concepts in every way possible
     * Use all kind of keywords (super, this, static, final, etc)
     * Implement nested class below (DateConversion)
     * Use Exception Handling
     * <p>
     * Once you're done with designing this EmployeeInfo class, go to the CompanyEmployee class to test
     */

    // Make sure to declare and use static, non-static & final fields
    static final String companyName = "Tesla";

    // You must have/use multiple constructors to initialize instance variables that you will create above
    public EmployeeInfo(int employeeId) {
        super(employeeId);
    }

    public EmployeeInfo(String name, int employeeId) {

        super(name, employeeId);
    }

    public EmployeeInfo(int employeeId, String Name, String department, int salary) {
        super(employeeId, Name, department, salary);
    }

    /*
    You need to implement the logic of this method as such:

        It should calculate employee bonus based on salary and performance.
        It should return the total yearly bonus

        e.g. - Bonus = 10% of yearly salary for best performance
               Bonus = 6% of yearly salary for average performance, etc.
     */
    public double calculateAnnualBonus(int salary, int performanceGrade) {
        double total = 0;

        if (performanceGrade < 5) {
            total = calculateSalary(salary) * 0.2;
        } else if (performanceGrade > 5) total = calculateSalary(salary) * 0.3;
        System.out.println("your bonus is :" + total);

        return total;
    }

    /*
    You need to implement the logic of this method as such:

    It should calculate employee pension based on salary and numbers of years spent with the company.
    It should return the total pension amount.

    e.g. - Employee will receive 5% of salary as pension for every year they are with the company
     */
    public int calculateEmployeePension() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter start date (september,2013): ");
        String joiningDate = sc.nextLine();
        System.out.println("Please enter your end  date (may,2020 ");
        String todaysDate = sc.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);

        // Figure out how to extract the number of years the employee has been with the company, using the above 2 dates
        // Calculate pension
        int salary = super.getSalary();
        int indexOfSlash = convertedJoiningDate.indexOf("/");
        // convert String year to Integer for both the Joining date and the today date
        int startDate = Integer.parseInt(convertedJoiningDate.substring(indexOfSlash + 1));
        int todayDate = Integer.parseInt(convertedTodaysDate.substring(indexOfSlash + 1));
        int numberOfYears = todayDate - startDate;
        total = (numberOfYears * salary * 5) / 100;
        System.out.println("Your pension for " + numberOfYears + " years with a salary of  $" + salary + " is :");
        System.out.println(total);


        return total;
    }

    @Override
    public void assignDepartment() {
        super.getDepartment();
    }

    @Override
    public int calculateSalary() {
        return calculateSalary();
    }

    @Override
    public void benefits() {


    }

    private static class DateConversion {

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
            String givenMonth = extractMonth[0];
            int monthDate = whichMonth(givenMonth);

            String actualDate = monthDate + "/" + extractMonth[1];
            return actualDate;
        }

        public static int whichMonth(String givenMonth) {
            Months month = Months.valueOf(givenMonth);
            int monthNumber;

            switch (month) {
                case January:
                    monthNumber = 1;
                    break;
                case February:
                    monthNumber = 2;
                    break;
                case March:
                    monthNumber = 3;
                    break;
                case April:
                    monthNumber = 4;
                    break;
                case May:
                    monthNumber = 5;
                    break;
                case June:
                    monthNumber = 6;
                    break;
                case July:
                    monthNumber = 7;
                    break;
                case August:
                    monthNumber = 8;
                    break;
                case September:
                    monthNumber = 9;
                    break;
                case October:
                    monthNumber = 10;
                    break;
                case November:
                    monthNumber = 11;
                    break;
                case December:
                    monthNumber = 12;
                    break;
                default:
                    monthNumber = -1;
                    break;
            }
            return monthNumber;
        }
    }
}
