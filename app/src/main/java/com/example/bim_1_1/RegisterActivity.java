package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etPaswordReenter;
    CheckBox cb8Hours, cb24Hours;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    Spinner spinnerCountry;
    Button btnRegister, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        LoadComponents();
    }

    private void LoadComponents(){
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPasswordUser);
        etPaswordReenter = (EditText) findViewById(R.id.etPasswordAgain);

        cb8Hours = (CheckBox) findViewById(R.id.cb8Hours);
        cb24Hours = (CheckBox) findViewById(R.id.cb24Hours);

        rgGender = (RadioGroup) findViewById(R.id.rgGender);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);

        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        spinnerCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                etName.setText(country);
            }
        });
    }
}