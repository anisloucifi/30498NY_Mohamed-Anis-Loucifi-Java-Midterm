package company_app_design;

import java.util.Scanner;

public class CompanyEmployee {

    /**
     * INSTRUCTIONS
     * <p>
     * This class has a main method where you will be able to create instances of the EmployeeInfo class in order
     * to use attributes and methods.
     * <p>
     * Demonstrate as many methods as possible here. Feel free to show off what you've learned so far.
     * <p>
     * The goal of this application is to provide basic employee information services
     * Try to think like a Software Developer
     */
    public static void main(String[] args) {


        EmployeeInfo employee = new EmployeeInfo(15, "Loucifi", "IT", 30);
        System.out.println("name :" + employee.employeeName() + "\n" + "Departemenrt :" + employee.getDepartment() + "\n" + "salary :" + employee.getSalary());
        System.out.println("if you want to calculate your bonus please enter your performence rate here  : \n");
        Scanner scanner = new Scanner(System.in);
        int sal = scanner.nextInt();
        System.out.println(employee.calculateAnnualBonus(30,sal));
        System.out.println("if you want to know you pension press 1 :");
        int pes = scanner.nextInt();
        if(pes==1){
            System.out.println("your pension is "+employee.calculateEmployeePension());
        } else System.out.println("have a good day see you next time ");
    }


}
