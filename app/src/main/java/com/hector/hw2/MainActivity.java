// By: Hector Rodriguez Reyes
// Date: 10/12/19
// Class: CPSC 411
// Time: Tu/Th 4:00-5:15 PM

package com.hector.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hector.hw2.model.CourseEnrollment;
import com.hector.hw2.model.Student;
import com.hector.hw2.model.StudentDB;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createStudentObject();
        setContentView(R.layout.student_list);

        root = findViewById(R.id.student_list);

        LayoutInflater inflater = LayoutInflater.from(this);
        View row_view = inflater.inflate(R.layout.student_row, root, false);

        ((TextView) row_view.findViewById(R.id.first_name)).setText("First");
        ((TextView) row_view.findViewById(R.id.last_name)).setText("Last");

        ((TextView) row_view.findViewById(R.id.first_name)).setTypeface(null,Typeface.BOLD);
        ((TextView) row_view.findViewById(R.id.last_name)).setTypeface(null,Typeface.BOLD);
        root.addView(row_view);


        ArrayList<Student> studentList = StudentDB.getInstance().getStudentList();
        for(int i = 0; i < studentList.size(); i++){
            Student s = studentList.get(i);
            //
            inflater = LayoutInflater.from(this);
            row_view = inflater.inflate(R.layout.student_row, root, false);
            //
            ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName());
            ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName());
            root.addView(row_view);
        }
    }


    protected void createStudentObject() {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();

        Student student = new Student("Hector ", "Rodriguez", 12345);
        courses.add(new CourseEnrollment("CPSC411","A"));
        courses.add(new CourseEnrollment("CPSC454","A"));
        courses.add(new CourseEnrollment("CPSC456","A"));
        student.setCourseEnrollments(courses);
        students.add(student);

        student = new Student("Michael ","Scott",67890);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC100","B"));
        courses.add(new CourseEnrollment("CPSC110", "A"));
        student.setCourseEnrollments(courses);
        students.add(student);

        student = new Student("Jennifer ","Snow",24680);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC353","C"));
        courses.add(new CourseEnrollment("CPSC110", "A"));
        student.setCourseEnrollments(courses);
        students.add(student);

        student = new Student("Luis ","Ramirez",13579);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC400","A"));
        courses.add(new CourseEnrollment("CPSC420", "C"));
        student.setCourseEnrollments(courses);
        students.add(student);

        student = new Student("Josh ","Peck",45678);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC201", "B"));
        student.setCourseEnrollments(courses);
        students.add(student);

        StudentDB.getInstance().setStudentList(students);

    }

}
