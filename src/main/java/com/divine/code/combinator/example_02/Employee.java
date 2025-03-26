package com.divine.code.combinator.example_02;

public class Employee extends HumanResource{

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }


    @Override
    public double calculateSalary() {

        return salary;
    }

}
