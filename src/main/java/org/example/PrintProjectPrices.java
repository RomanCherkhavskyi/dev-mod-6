package org.example;

public class PrintProjectPrices {

    private int name;
    private int project_cost;

    public PrintProjectPrices(int name, int project_cost) {
        this.name = name;
        this.project_cost = project_cost;
    }

    @Override
    public String toString() {
        return "\nname = " + name + ", project_cost = " + project_cost;
    }
}
