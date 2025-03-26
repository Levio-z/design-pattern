package com.divine.code.combinator.example_03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取公司名称
        String companyName = sc.nextLine();
        Department company = new Department(companyName);

        // 读取部门和员工数量
        int n = sc.nextInt();
        sc.nextLine(); // 消耗换⾏符
        Department temp = null;
        // 读取部门和员工信息
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.nextLine().trim();
            if ("D".equals(type)) {
                temp = new Department(name);
                company.add(temp);
            } else {
                temp.add(new Employee(name));
            }
        }
        System.out.println("Company Structure:");
        company.display(0);
    }

}
