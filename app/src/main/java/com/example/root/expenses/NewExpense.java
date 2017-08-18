package com.example.root.expenses;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewExpense extends AppCompatActivity {

    EditText subject,desc,money;
    Button submit;
    Calendar calendar;
    String datetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);
        final DbHelper dbHelper=new DbHelper(getApplicationContext());

        subject=(EditText)findViewById(R.id.subject);
        desc=(EditText)findViewById(R.id.desc);
        money=(EditText)findViewById(R.id.money);
        submit=(Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub=subject.getText().toString();
                String des=desc.getText().toString();
                String mon=money.getText().toString();
                String dateofprice;
                DateFormat simpleDateFormat=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
                simpleDateFormat.setLenient(false);
                Date today = new Date();
                dateofprice = simpleDateFormat.format(today);

                dbHelper.addExpense(sub,des,mon,dateofprice);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //Log.d("time",datetime);

            }
        });
    }
}
