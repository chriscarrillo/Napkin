package com.egr423.android.napkin;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class GPAActivity extends AppCompatActivity {
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = getSharedPreferences("com.egr423.android.napkin", MODE_PRIVATE);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        //Inputs
        EditText class1Credits = (EditText) findViewById(R.id.Class1Credits);
        EditText class2Credits = (EditText) findViewById(R.id.Class2Credits);
        EditText class3Credits = (EditText) findViewById(R.id.Class3Credits);
        EditText class4Credits = (EditText) findViewById(R.id.Class4Credits);
        EditText class5Credits = (EditText) findViewById(R.id.Class5Credits);
        EditText class6Credits = (EditText) findViewById(R.id.Class6Credits);
        EditText class7Credits = (EditText) findViewById(R.id.Class7Credits);

        class1Credits.setText(prefs.getString("class1Credits", "0"), TextView.BufferType.EDITABLE);
        class2Credits.setText(prefs.getString("class2Credits", "0"), TextView.BufferType.EDITABLE);
        class3Credits.setText(prefs.getString("class3Credits", "0"), TextView.BufferType.EDITABLE);
        class4Credits.setText(prefs.getString("class4Credits", "0"), TextView.BufferType.EDITABLE);
        class5Credits.setText(prefs.getString("class5Credits", "0"), TextView.BufferType.EDITABLE);
        class6Credits.setText(prefs.getString("class6Credits", "0"), TextView.BufferType.EDITABLE);
        class7Credits.setText(prefs.getString("class7Credits", "0"), TextView.BufferType.EDITABLE);

        Spinner class1Grade = (Spinner) findViewById(R.id.Class1Grade);
        Spinner class2Grade = (Spinner) findViewById(R.id.Class2Grade);
        Spinner class3Grade = (Spinner) findViewById(R.id.Class3Grade);
        Spinner class4Grade = (Spinner) findViewById(R.id.Class4Grade);
        Spinner class5Grade = (Spinner) findViewById(R.id.Class5Grade);
        Spinner class6Grade = (Spinner) findViewById(R.id.Class6Grade);
        Spinner class7Grade = (Spinner) findViewById(R.id.Class7Grade);

        class1Grade.setSelection(prefs.getInt("class1Grade", 0), false);
        class2Grade.setSelection(prefs.getInt("class2Grade", 0), false);
        class3Grade.setSelection(prefs.getInt("class3Grade", 0), false);
        class4Grade.setSelection(prefs.getInt("class4Grade", 0), false);
        class5Grade.setSelection(prefs.getInt("class5Grade", 0), false);
        class6Grade.setSelection(prefs.getInt("class6Grade", 0), false);
        class7Grade.setSelection(prefs.getInt("class7Grade", 0), false);


        updateOutputs();


        //Listeners

        TextWatcher textListen = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateOutputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        class1Credits.addTextChangedListener(textListen);
        class2Credits.addTextChangedListener(textListen);
        class3Credits.addTextChangedListener(textListen);
        class4Credits.addTextChangedListener(textListen);
        class5Credits.addTextChangedListener(textListen);
        class6Credits.addTextChangedListener(textListen);
        class7Credits.addTextChangedListener(textListen);

        View.OnTouchListener spinListen = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                updateOutputs();
                return false;
            }
        };
        class1Grade.setOnTouchListener(spinListen);
        class2Grade.setOnTouchListener(spinListen);
        class3Grade.setOnTouchListener(spinListen);
        class4Grade.setOnTouchListener(spinListen);
        class5Grade.setOnTouchListener(spinListen);
        class6Grade.setOnTouchListener(spinListen);
        class7Grade.setOnTouchListener(spinListen);

    }

    private void updateOutputs() {
        double totalGrade = 0;
        double totalCredits = 0;
        double gpa = 0;
        try{
            //Inputs
            EditText class1Credits = (EditText) findViewById(R.id.Class1Credits);
            EditText class2Credits = (EditText) findViewById(R.id.Class2Credits);
            EditText class3Credits = (EditText) findViewById(R.id.Class3Credits);
            EditText class4Credits = (EditText) findViewById(R.id.Class4Credits);
            EditText class5Credits = (EditText) findViewById(R.id.Class5Credits);
            EditText class6Credits = (EditText) findViewById(R.id.Class6Credits);
            EditText class7Credits = (EditText) findViewById(R.id.Class7Credits);
            prefs.edit().putString("class1Credits",class1Credits.getText().toString()).apply();
            prefs.edit().putString("class2Credits",class2Credits.getText().toString()).apply();
            prefs.edit().putString("class3Credits",class3Credits.getText().toString()).apply();
            prefs.edit().putString("class4Credits",class4Credits.getText().toString()).apply();
            prefs.edit().putString("class5Credits",class5Credits.getText().toString()).apply();
            prefs.edit().putString("class6Credits",class6Credits.getText().toString()).apply();
            prefs.edit().putString("class7Credits",class7Credits.getText().toString()).apply();


            Spinner class1Grade = (Spinner) findViewById(R.id.Class1Grade);
            Spinner class2Grade = (Spinner) findViewById(R.id.Class2Grade);
            Spinner class3Grade = (Spinner) findViewById(R.id.Class3Grade);
            Spinner class4Grade = (Spinner) findViewById(R.id.Class4Grade);
            Spinner class5Grade = (Spinner) findViewById(R.id.Class5Grade);
            Spinner class6Grade = (Spinner) findViewById(R.id.Class6Grade);
            Spinner class7Grade = (Spinner) findViewById(R.id.Class7Grade);

            prefs.edit().putInt("class1Grade", class1Grade.getSelectedItemPosition()).apply();
            prefs.edit().putInt("class2Grade", class2Grade.getSelectedItemPosition()).apply();
            prefs.edit().putInt("class3Grade", class3Grade.getSelectedItemPosition()).apply();
            prefs.edit().putInt("class4Grade", class4Grade.getSelectedItemPosition()).apply();
            prefs.edit().putInt("class5Grade", class5Grade.getSelectedItemPosition()).apply();
            prefs.edit().putInt("class6Grade", class6Grade.getSelectedItemPosition()).apply();
            prefs.edit().putInt("class7Grade", class7Grade.getSelectedItemPosition()).apply();


            double[] creditList = new double[]{Double.parseDouble(class1Credits.getText().toString()),
                    Double.parseDouble(class2Credits.getText().toString()),
                    Double.parseDouble(class3Credits.getText().toString()),
                    Double.parseDouble(class4Credits.getText().toString()),
                    Double.parseDouble(class5Credits.getText().toString()),
                    Double.parseDouble(class6Credits.getText().toString()),
                    Double.parseDouble(class7Credits.getText().toString())};

            double[] gradeList = new double[]{gradeValue(class1Grade.getSelectedItem().toString()),
                    gradeValue(class2Grade.getSelectedItem().toString()),
                    gradeValue(class3Grade.getSelectedItem().toString()),
                    gradeValue(class4Grade.getSelectedItem().toString()),
                    gradeValue(class5Grade.getSelectedItem().toString()),
                    gradeValue(class6Grade.getSelectedItem().toString()),
                    gradeValue(class7Grade.getSelectedItem().toString())};
            for(int i = 0; i < 7; i++){
                totalCredits += creditList[i];
            }
            for(int i = 0; i < 7; i++){
                gpa += creditList[i] * gradeList[i];
            }
            gpa = gpa/totalCredits;
            TextView gpaView = (TextView) findViewById(R.id.gpa);

            gpaView.setText(String.valueOf(gpa));
        }catch(NumberFormatException E){
        }

    }

    double gradeValue(String gradeText){
        double gradeval = 0;
        switch (gradeText){
            case "A":
                gradeval = 4.0;
                break;
            case "A-":
                gradeval = 3.7;
                break;
            case "B+":
                gradeval = 3.3;
                break;
            case "B":
                gradeval = 3.0;
                break;
            case "B-":
                gradeval = 2.7;
                break;
            case "C+":
                gradeval = 2.3;
                break;
            case "C":
                gradeval = 2.0;
                break;
            case "C-":
                gradeval = 1.7;
                break;
            case "D+":
                gradeval = 1.3;
                break;
            case "D":
                gradeval = 1.0;
                break;
            case "D-":
                gradeval = 0.7;
                break;
            case "F":
                gradeval = 0.0;
                break;
        }
        return gradeval;
    }
}

