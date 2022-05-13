package com.example.sping_portfolio.controllers;
import java.util.Arrays;

public class seatstudents {
    private String[] studentList;
    private int studentsperGroup;

    public seatstudents(String[] studList, int groupDecider) {
        studentList = studList;
        studentsperGroup = groupDecider;
    }

    public String[][] studentArray() {
        String[][] studentGroups;
        int column = studentList.length / studentsperGroup + 1;
        studentGroups = new String [studentsperGroup][column];

        for (int i = 0; i < studentGroups.length; i++) {
            for (int j = 0; j < studentGroups[0].length; j++) {
                if (studentList.length > 0) {
                    int randomValueInArray = (int) (Math.random() * (studentList.length));
                    studentGroups[i][j] = studentList[randomValueInArray];
//                    studentList.remove(randomValueInArray);
                }
                else {
                    studentGroups[i][j] = null;
                }
            }
        }
        return studentGroups;
    }

}
