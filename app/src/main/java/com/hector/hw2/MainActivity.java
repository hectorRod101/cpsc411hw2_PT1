// By: Hector Rodriguez Reyes
// Date: 11/05/19
// Class: CPSC 411
// Time: Tu/Th 4:00-5:15 PM

package com.hector.hw2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hector.hw2.model.CourseEnrollment;
import com.hector.hw2.model.Student;
import com.hector.hw2.model.StudentDB;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // To display output onto layout
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Call function to create sample student summary database
        createStudentObject();

        // Set student list layout
        setContentView(R.layout.student_list);

        // Add student layout to root layout
        root = findViewById(R.id.student_list);

        LayoutInflater inflater = LayoutInflater.from(this);

        View row_view = inflater.inflate(R.layout.student_row, root, false);

        ((TextView) row_view.findViewById(R.id.first_name)).setText("First");
        ((TextView) row_view.findViewById(R.id.last_name)).setText("Last");

        ((TextView) row_view.findViewById(R.id.first_name)).setTypeface(null,Typeface.BOLD);
        ((TextView) row_view.findViewById(R.id.last_name)).setTypeface(null,Typeface.BOLD);
        root.addView(row_view);

        // Iterate through student database to display student's first name
        // and last name to Student Summary in Main Activity
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

    // Create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.mainmenu, menu);
    return true;
}
    // Handle ADD button activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // When Add button is clicked go to Detail Activity
        if (id == R.id.menuButton) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }

    // Create a sample student summary
    // With encoded data into student database
    protected void createStudentObject() {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        Student student;

        student = new Student("Hector ", "Rodriguez", 12345);
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


    // Once data is entered from Detail Activity
    // handle data and enter data into student database
    // Display new data in Student Summary
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Make sure requested data has been entered
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                // Get string data and store it
                String firstName = data.getStringExtra("First");
                String lastName = data.getStringExtra("Last");
                String CWID = data.getStringExtra("CWID");
                int CWIDInt = Integer.valueOf(CWID);

                ArrayList<Student> studentAddList = new ArrayList<Student>();
                ArrayList<CourseEnrollment> coursesAdd = new ArrayList<CourseEnrollment>();
                Student studentAdd;

                // Input data into student database
                studentAdd = new Student(firstName, lastName, CWIDInt);
                studentAddList.add(studentAdd);

                StudentDB.getInstance().setStudentList(studentAddList);

                LayoutInflater inflater = LayoutInflater.from(this);

                View row_view = inflater.inflate(R.layout.student_row, root, false);

                // Iterate through student database to display student's first name
                // and last name to Student Summary in Main Activity
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
        }
    }
}
