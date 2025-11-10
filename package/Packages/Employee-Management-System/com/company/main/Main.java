package com.company.main;
import com.company.hr.Employee;
import com.company.payroll.Payroll;
public class MainApp {
    public static void main(String[] args){
        Employee emp = new Employee("E101", "Neha", "Finance", 50000);
        Payroll p = new Payroll();
        double finalSalary = p.calculateBonus(emp);
        System.out.println("Employee Details -> " + emp);
        System.out.println("Salary after 10% bonus -> " + finalSalary);
    }
}
