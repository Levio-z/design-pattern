package com.divine.code.combinator.example_02;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    private static final long ORGANIZATION_SUB_ID = 100101;
    private static final long ORGANIZATION_EMPTY_ID = 100102;

    private Department departmentRepo; // 依赖注入

    private Employee employeeRepo; // 依赖注入

    public void buildOrganization() {

        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);

        Department subDepartment = new Department(ORGANIZATION_SUB_ID);
        subDepartment.addSubNode(new Employee(ORGANIZATION_EMPTY_ID, 2.0));

        rootDepartment.addSubNode(subDepartment);

        System.out.println(rootDepartment.calculateSalary());

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.buildOrganization();
    }

//    private void buildOrganization(Department department) {
//        // 递归构建组织结构
//        // List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
//
//        List<Long> subDepartmentIds = new ArrayList<Long>();
//        subDepartmentIds.add(1002L);
//
//        for (Long subDepartmentId : subDepartmentIds) {
//            Department subDepartment = new Department(subDepartmentId);
//            department.addSubNode(subDepartment);
//            buildOrganization(subDepartment);
//        }
//        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
//        for (Long employeeId : employeeIds) {
//            double salary = employeeRepo.getEmployeeSalary(employeeId);
//            department.addSubNode(new Employee(employeeId, salary));
//        }
//    }

}