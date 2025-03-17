package EmployeeObjects;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestingAnnoations {

    public static void main(String[] args) {
        // Employee objects to test the annotations
        HourlyEmployee hourlyEmp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
        SalaryEmployee salaryEmp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manger", 64325);
        CommissionEmployee commissionEmp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);

        // Counter to keep track when the @EmployeeType annotation is present in the class
        int employeeCounter = 0;

        // Validate if the @EmployeeType annotation is present in the HourlyEmployee, SalaryEmployee and CommissionEmployee class
        if (HourlyEmployee.class.isAnnotationPresent(EmployeeType.class)) {
            employeeCounter++;
        }
        if (SalaryEmployee.class.isAnnotationPresent(EmployeeType.class)) {
            employeeCounter++;
        }
        if (CommissionEmployee.class.isAnnotationPresent(EmployeeType.class)) {
            employeeCounter++;
        }

        // Print the result of the count
        System.out.println("You have " + employeeCounter + " employee types");

        // Created method to check if the @WeeklyPayCalculator annotation is present in HourlyEmployee, SalaryEmployee and CommissionEmployee class
        checkEmployeeWeeklyPayCalculatorMethods(hourlyEmp);
        checkEmployeeWeeklyPayCalculatorMethods(salaryEmp);
        checkEmployeeWeeklyPayCalculatorMethods(commissionEmp);

        // Created method to check if the @PayRate annotation is present in HourlyEmployee, SalaryEmployee and CommissionEmployee class
        checkEmployeePayRateFields(hourlyEmp);
        checkEmployeePayRateFields(salaryEmp);
        checkEmployeePayRateFields(commissionEmp);
    }

    // Created a method that gets all the methods from the class
    // Loops through all the methods and checks if the @WeeklyPayCalculator is present
    // If it finds it, then we use the invoke method in our employees to call the method with the annotation
    // Prints the result from the method with the @WeeklyPayCalculator annotation
    private static void checkEmployeeWeeklyPayCalculatorMethods(Object employee) {
        for (Method myMethods : employee.getClass().getDeclaredMethods()) {
            if (myMethods.isAnnotationPresent(WeeklyPayCalculator.class)) {
                try {
                    Object methodWithWeeklyPayCalculatorResult = myMethods.invoke(employee);
                    System.out.println("Employee Weekly Pay: $" + methodWithWeeklyPayCalculatorResult);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    // Created a method that gets all the fields from the class
    // Loops through all the fields and checks if the @PayRate is present
    // If it finds it, then it enables access to the private field with the @PayRate annotation
    // Prints the result from the field with the @PayRate annotation
    private static void checkEmployeePayRateFields(Object employee) {
        for (Field myClassField : employee.getClass().getDeclaredFields()) {
            if (myClassField.isAnnotationPresent(PayRate.class)) {
                myClassField.setAccessible(true);
                try {
                    System.out.println("Employee pay rate: $" + myClassField.get(employee));
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
