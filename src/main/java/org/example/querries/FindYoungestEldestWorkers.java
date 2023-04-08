package org.example.querries;

import java.util.Date;

public class FindYoungestEldestWorkers {

    private String type;
    private String name;

    private Date birthday;

    public FindYoungestEldestWorkers(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\ntype=" + type +
                ", name=" + name  +
                ", birthday=" + birthday;
    }
}
