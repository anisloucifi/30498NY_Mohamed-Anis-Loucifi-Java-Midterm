package company_app_design;

import java.util.Scanner;

public abstract class EmployeeParent implements Employee{
    private int employeeId;
    private String Name;
    private String department;
    private int salary;
    public EmployeeParent(int employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeParent(String Name, int employeeId) {
        this.employeeId = employeeId;
        this.Name = Name;
    }
    public EmployeeParent(int employeeId,String Name,String department,  int salary) {
        this.employeeId = employeeId;
        this.department = department;
        this.Name = Name;
        this.salary = salary;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }



    public int getSalary() {
        return salary;
    }



    public String getDepartment() {
        return department;
    }




    @Override
    public int employeeId() {
        return employeeId;
    }


    @Override
    public String employeeName() {
        return Name;
    }
    public int calculateSalary(int salaryperhours) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Number of Hours per week");
        int numberOfHour = scanner.nextInt();
        scanner.nextLine();
        salaryperhours =  (numberOfHour * salaryperhours);
        System.out.println("Your Weekly salary is :"+ salaryperhours*30);

        return salaryperhours;
    }

}
