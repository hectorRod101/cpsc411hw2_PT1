// By: Hector Rodriguez Reyes
// Date: 11/05/19
// Class: CPSC 411
// Time: Tu/Th 4:00-5:15 PM

package com.hector.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    // EditText First Name
    protected EditText firstText;

    // EditText Last Name
    protected EditText lastText;

    // EditText CWID
    protected EditText CWIDText;

    // Button DONE
    protected MenuItem enableMenuItem;

    // Int for number of times ADD COURSE is clicked
    protected int clickCount =  0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);

        // Set Detail Activity's Title
        setTitle("Add Student");

        // Creates button to return to Main/Summary Activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Button for 'Add Course'
        Button buttonAdd = findViewById(R.id.addButton);

        // Get text IDs for inputs
        firstText = findViewById(R.id.editTextFirst);
        lastText = findViewById(R.id.editTextLast);
        CWIDText = findViewById(R.id.editTextID);

        // Set listeners
        firstText.addTextChangedListener(mTextWatcher);
        lastText.addTextChangedListener(mTextWatcher);
        CWIDText.addTextChangedListener(mTextWatcher);

        // Layout to one new row to be appended
        final LinearLayout root = findViewById(R.id.detailLayout);

        // Once user clicks on 'Add Course'
        // activity will output a new row
        // for user to input another Course ID and Grade
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLayoutInflater().inflate(R.layout.course_list, root);
                System.err.println(getLayoutInflater());
            }
        });


    }

    // Create a return button to Main Activity
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    // Listens to user input in First Name, Last Name, CWID
    // Once all fields have been inserted it enables DONE button
    private TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String firstString = firstText.getText().toString().trim();
            String lastString = lastText.getText().toString().trim();
            String CWIDString = CWIDText.getText().toString().trim();

            enableMenuItem.setEnabled(!firstString.isEmpty() && !lastString.isEmpty() && !CWIDString.isEmpty());
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,int after){}
        @Override
        public void afterTextChanged(Editable s) {}
    };


    // Create an action bar button DONE
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detailmenu, menu);
        enableMenuItem = menu.findItem(R.id.detailButton);
        return true;
    }

    // Handle button DONE activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // When DONE is clicked pass data to DB and output to Main Activity
        if (id == R.id.detailButton) {
            Intent intent = new Intent();

            // Get EditText First Name, Last Name, & CWID strings
            String firstString = firstText.getText().toString().trim();
            String lastString = lastText.getText().toString().trim();
            String CWIDString = CWIDText.getText().toString().trim();

            // Pass it to Main Activity
            intent.putExtra("First", firstString);
            intent.putExtra("Last", lastString);
            intent.putExtra("CWID", CWIDString);
            setResult(RESULT_OK, intent);
            finish();
            }
        return super.onOptionsItemSelected(item);
    }

}
