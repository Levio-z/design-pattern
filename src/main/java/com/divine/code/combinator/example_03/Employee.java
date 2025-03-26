package com.divine.code.combinator.example_03;



public class Employee extends Component{

    public Employee(String name) {
        super(name);
    }

    @Override
    void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth+1; i++) {
            sb.append(" ");
        }
        System.out.println(sb + name);
    }

}
