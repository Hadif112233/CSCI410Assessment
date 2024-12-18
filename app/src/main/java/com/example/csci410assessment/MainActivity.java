package com.example.csci410assessment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email;
    RadioGroup gender;
    RadioButton selectedGender;
    Spinner contactMethod;
    CheckBox subscribe;
    Button submit, clear;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.et1);
        email = findViewById(R.id.et2);
        gender = findViewById(R.id.genderGroup);
        contactMethod = findViewById(R.id.spinner);
        subscribe = findViewById(R.id.cb1);
        submit = findViewById(R.id.submitButton);
        clear = findViewById(R.id.clearButton);
        result = findViewById(R.id.tv);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = name.getText().toString();
                String emailStr = email.getText().toString();

                if (nameStr.isEmpty() || emailStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!emailStr.contains("@") || !emailStr.contains(".")) {
                    Toast.makeText(MainActivity.this, "Please enter a valid email format", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedGenderId = gender.getCheckedRadioButtonId();
                selectedGender = findViewById(selectedGenderId);
                String genderStr = selectedGender.getText().toString();

                String contactMethodStr = contactMethod.getSelectedItem().toString();
                boolean isSubscribed = subscribe.isChecked();

                String resultStr = "Name: " + nameStr + "\nEmail: " + emailStr + "\nGender: " + genderStr +
                        "\nContact Method: " + contactMethodStr + "\nSubscribed: " + isSubscribed;
                result.setText(resultStr);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                gender.clearCheck();
                contactMethod.setSelection(0);
                subscribe.setChecked(false);
                result.setText("");
            }
        });
    }
}