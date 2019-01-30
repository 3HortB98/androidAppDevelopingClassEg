package com.example.classexample1;

import android.app.Activity;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    public static String radio;
    public static String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstApplication", "Created");
        //setContentView(R.layout.activity_main);//linear layout
        setContentView(R.layout.activity_main_v2); //relative layout
        //setContentView(R.layout.activity_main_v3);//constraint layout
        Button buttonSubmit = findViewById(R.id.button_submit);
        final EditText etName = findViewById(R.id.etName);
        final EditText etAge = findViewById(R.id.etAge);
        final EditText etAddress = findViewById(R.id.etAddress);
        //final EditText etGender = findViewById(R.id.etGender);
        final RadioGroup rg = findViewById(R.id.radioGrp);
        final TextView textViewStatus = findViewById(R.id.textview_Combination);
        final Spinner spinner = (Spinner) findViewById(R.id.genderSpinner);
        //spinner.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*if (parent.getItemAtPosition(0).equals("Select a gender...")){
                    gender = "Did not select anything";
                }
                else {
                    gender = spinner.getSelectedItem().toString();
                }*/
                gender = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_choices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String address = etAddress.getText().toString();
                //String gender = etGender.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Pls enter in your name", Toast.LENGTH_SHORT).show();
                } else if (age.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Pls enter your age", Toast.LENGTH_SHORT).show();
                }else if(address.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Pls enter your address", Toast.LENGTH_SHORT).show();
                }else if(gender.equals("Select a gender...")){
                    Toast.makeText(getApplicationContext(), "Pls select your gender", Toast.LENGTH_SHORT).show();
                }else if(rg.getCheckedRadioButtonId()== -1){
                    Toast.makeText(getApplicationContext(), "Driving license not answered", Toast.LENGTH_SHORT).show();
                }else {

                        String combo = "Name: " + name + ",\n" +
                                "Age: " + age + ",\n" +
                                "Address: " + address + ",\n" +
                                "Gender: " + gender + ",\n" +
                                "Driving License: " + radio;
                        textViewStatus.setText(combo);
                        etAddress.onEditorAction(EditorInfo.IME_ACTION_DONE);
                        etAge.onEditorAction(EditorInfo.IME_ACTION_DONE);
                        etName.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    }
                }

        });







    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FirstApplication", "Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FirstApplication", "Stopped");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FirstApplication", "Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FirstApplication", "Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FirstApplication", "Destroyed");
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.btnYes:
                if (checked)
                    // yes is selected
                    radio = "Yes";
                    break;
            case R.id.btnNo:
                if (checked)
                    // No is selected
                    radio = "No";
                    break;
        }
    }


}
