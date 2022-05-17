package com.example.sping_portfolio;

public class Student {
    private int tableGroup;
    private String studentName;

    public Student(int a, String str) {
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
