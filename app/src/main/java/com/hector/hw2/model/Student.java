// By: Hector Rodriguez Reyes
// Date: 10/12/19
// Class: CPSC 411
// Time: Tu/Th 4:00-5:15 PM

package com.hector.hw2.model;

import java.util.ArrayList;

// Student attributes
public class Student extends ArrayList {

    protected String mFirstName;
    protected String mLastName;
    protected Integer mCWID;

    protected ArrayList<CourseEnrollment> mCourseEnrollments;

    public Student(String fName, String lName, Integer dCWID){
        mFirstName = fName;
        mLastName = lName;
        mCWID = dCWID;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Integer getCWID() {
        return mCWID;
    }

    public void setCWID(Integer CWID) {
        mCWID = CWID;
    }

    public ArrayList<CourseEnrollment> getCourseEnrollments() {
        return mCourseEnrollments;
    }

    public void setCourseEnrollments(ArrayList<CourseEnrollment> courseEnrollments) {
        mCourseEnrollments = courseEnrollments;
    }



}
