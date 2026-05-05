package com.example.computeaverageandmanagecontacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ComputeAverage extends AppCompatActivity {
    EditText englishGrade, filipinoGrade, mathGrade,  scienceGrade, mapehGrade;
    Button submit, back;
    Intent intent;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compute_average);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        englishGrade = findViewById(R.id.etEnglish);
        filipinoGrade = findViewById(R.id.etFilipino);
        mathGrade = findViewById(R.id.etMath);
        scienceGrade = findViewById(R.id.etScience);
        mapehGrade = findViewById(R.id.etMAPEH);
        submit = findViewById(R.id.btnSubmit);
        back = findViewById(R.id.btnBack);

        builder= new AlertDialog.Builder(this);

        intent = new Intent(ComputeAverage.this, AverageResult.class);
        back.setOnClickListener(v -> finish());
        computeAverage();
    }
    public void computeAverage(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (englishGrade.getText().toString().isEmpty() || filipinoGrade.getText().toString().isEmpty() || mathGrade.getText().toString().isEmpty() || scienceGrade.getText().toString().isEmpty() || mapehGrade.getText().toString().isEmpty()) {
                    displayMessage("Input Error!", "Please fill out all fields");
                    return;
                }

                double doubleEnglishGrade = Double.parseDouble(englishGrade.getText().toString());
                double doubleFilipinoGrade = Double.parseDouble(filipinoGrade.getText().toString());
                double doubleMathGrade = Double.parseDouble(mathGrade.getText().toString());
                double doubleScienceGrade = Double.parseDouble(scienceGrade.getText().toString());
                double doubleMapehGrade = Double.parseDouble(mapehGrade.getText().toString());
                double average = (doubleEnglishGrade + doubleFilipinoGrade + doubleMathGrade + doubleScienceGrade + doubleMapehGrade) / 5;


                Intent intent = new Intent(ComputeAverage.this, AverageResult.class);
                intent.putExtra("computedAverage", average);
                startActivity(intent);

            }
        });
    }
    public void displayMessage(String title, String message){
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}