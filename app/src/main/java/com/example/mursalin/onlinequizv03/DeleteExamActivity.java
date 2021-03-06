package com.example.mursalin.onlinequizv03;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteExamActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private EditText dateView,delexamname;
    private int year, month, day;
    private Button delexambutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_exam);

        dateView = (EditText) findViewById(R.id.delexamdate);
        delexambutton = (Button) findViewById(R.id.delexambutton);
        delexamname = (EditText)findViewById(R.id.delexamname);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //showDate(year, month+1, day);
        delexambutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteButtonClicked();
            }
        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    void DeleteButtonClicked(){

        String date,name;
        name = delexamname.getText().toString();
        date = dateView.getText().toString();
        //DeleteExamTask deleteExamTask = new DeleteExamTask(DeleteExamActivity.this,getApplicationContext());
        //deleteExamTask.execute(name,date);
    }

}