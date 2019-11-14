// By: Hector Rodriguez Reyes
// Date: 11/05/19
// Class: CPSC 411
// Time: Tu/Th 4:00-5:15 PM

package com.hector.hw2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    static public StudentDB getInstance() { return ourInstance; }

    public ArrayList<Student> getStudentList(){ return mStudentList;}

    public void setStudentList(ArrayList<Student> studentList) { mStudentList = studentList;}

    private StudentDB(){}

}
