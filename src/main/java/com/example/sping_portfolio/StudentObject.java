package com.example.sping_portfolio;

public class StudentObject {
    private int tableGroup;
    private String studentName;

    public StudentObject(int a, String str) {
        this.studentName = str;
        this.tableGroup = a;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getTableGroup() {
        return tableGroup;
    }

    public void setStudentName(String s) {
        studentName = s;
    }

    public void setTableGroup(int a) {
        tableGroup = a;
    }
}
