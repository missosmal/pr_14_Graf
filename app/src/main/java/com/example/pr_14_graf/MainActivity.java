package com.example.pr_14_graf;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText firstname;
    EditText lastname;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    EditText weight;
    EditText height;
    RadioButton m;
    RadioButton w;
    FrameLayout training1;
    FrameLayout training2;
    FrameLayout training3;
    FrameLayout training4;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor = sharedPreferences.edit();
    }

    public void AlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title).setMessage(message).setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onClickRegin(View view){
        setContentView(R.layout.step_1);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
    }

    public void onClickStep1(View view){
        if(firstname.getText().toString().equals("")) AlertDialog("Уведомление", "Введите ваше имя!");
        else if(lastname.getText().toString().equals("")) AlertDialog("Уведомление", "Введите вашу фамилию!");
        else{
            setContentView(R.layout.step_2);
            text = findViewById(R.id.nice);
            text.setText("Отлично, " + firstname.getText() + " " + lastname.getText());
            rb1 = findViewById(R.id.rb1);
            rb2 = findViewById(R.id.rb2);
            rb3 = findViewById(R.id.rb3);
            rb4 = findViewById(R.id.rb4);
        }
    }

    public void onClickStep2(View view){
        if(!rb1.isChecked() && !rb2.isChecked() && !rb3.isChecked() && !rb4.isChecked()) AlertDialog("Уведомление", "Выберите, как часто вы хотите тренероваться!");
        else {
            setContentView(R.layout.step_3);
            cb1 = findViewById(R.id.cb1);
            cb2 = findViewById(R.id.cb2);
            cb3 = findViewById(R.id.cb3);
            cb4 = findViewById(R.id.cb4);
        }
    }

    public void onClickStep3(View view){
        if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) AlertDialog("Уведомление", "Выберите тип тренеровки!");
        else {
            setContentView(R.layout.step_4);
            weight = findViewById(R.id.weight);
            height = findViewById(R.id.height);
        }
    }

    public void onClickStep4(View view){
        if(weight.getText().toString().equals("")) AlertDialog("Уведомление", "Укажите ваш вес!");
        else if(height.getText().toString().equals("")) AlertDialog("Уведомление", "Укажите ваш рост!");
        else {
            setContentView(R.layout.step_5);
            m = findViewById(R.id.m);
            w = findViewById(R.id.w);
        }
    }

}