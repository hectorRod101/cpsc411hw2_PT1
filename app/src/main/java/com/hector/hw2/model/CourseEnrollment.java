// By: Hector Rodriguez Reyes
// Date: 11/05/19
// Class: CPSC 411
// Time: Tu/Th 4:00-5:15 PM

package com.hector.hw2.model;

// CourseEnrollment attributes
public class CourseEnrollment {

    protected String mCourseID;
    protected String mGrade;

    public CourseEnrollment(String cID, String dGrade){
        mCourseID = cID;
        mGrade = dGrade;
    }

    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String courseID) {
        mCourseID = courseID;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }


}
