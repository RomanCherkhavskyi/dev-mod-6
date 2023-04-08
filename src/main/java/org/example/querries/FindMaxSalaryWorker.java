package org.example.querries;

public class FindMaxSalaryWorker {
    private String name;
    private int salary;

    public FindMaxSalaryWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "\nname=" + name  +
                ", salary=" + salary ;
    }
}
