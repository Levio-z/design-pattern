package com.divine.code.combinator.example_03;

import java.util.ArrayList;
import java.util.List;

public class Department extends Component{
    private List<Component> subordinates = new ArrayList<>();
    public Department(String name) {
        super(name);
    }

    @Override
    void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth+1; i++) {
            sb.append(" ");
        }
        System.out.println(sb + name);
        for (Component component : subordinates) {
            component.display(depth +1);
        }
    }

    public void add(Component component) {
        subordinates.add(component);
    }
}
