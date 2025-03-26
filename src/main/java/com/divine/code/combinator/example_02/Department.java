package com.divine.code.combinator.example_02;

import java.util.ArrayList;
import java.util.List;

public class Department extends HumanResource{
    private List<HumanResource> subNodes = new ArrayList<HumanResource>();
    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource hr : subNodes) {
            totalSalary += hr.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }
    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }
}
