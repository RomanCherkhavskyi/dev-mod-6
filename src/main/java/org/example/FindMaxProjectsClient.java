package org.example;

public class FindMaxProjectsClient {

    private String name;
    private int project_count;


    public FindMaxProjectsClient(String name, int project_count) {
        this.name = name;
        this.project_count = project_count;
    }

    @Override
    public String toString() {
        return "\nname=" + name +
                ", project_count=" + project_count;
    }
}
