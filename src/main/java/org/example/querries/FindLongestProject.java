package org.example.querries;

public class FindLongestProject {

    private int id;
    private int month_count;

    public FindLongestProject(int id, int mount_count) {
        this.id = id;
        this.month_count = mount_count;
    }
    @Override
    public String toString() {
        return "\nproject_id=" + id  +
                ", month_count=" + month_count;
    }
}
