package com.example.computeaverageandmanagecontacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AverageResult extends AppCompatActivity {

    TextView tvMathGrade, tvMapehGrade, tvScience, tvEnglish, tvFilipino, tvAverageGrade;
    Button btnBack;

    ImageView heronReaction;

    double average;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_average_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        tvAverageGrade = findViewById(R.id.tvComputedAverage);
        tvMathGrade = findViewById(R.id.tvMathGrade);
        tvMapehGrade = findViewById(R.id.tvMAPEHGrade);
        tvFilipino = findViewById(R.id.tvFilipinoGrade);
        tvScience = findViewById(R.id.tvScienceGrade);
        tvEnglish = findViewById(R.id.tvEnglishGrade);

        Intent intent = getIntent();

        average = intent.getDoubleExtra("computedAverage", 0.0);
        double mathGrade = intent.getDoubleExtra("mathGrade", 0.0);
        double mapehGrade = intent.getDoubleExtra("mapehGrade", 0.0);
        double filipinoGrade = intent.getDoubleExtra("filipinoGrade", 0.0);
        double scienceGrade = intent.getDoubleExtra("scienceGrade", 0.0);
        double englishGrade = intent.getDoubleExtra("englishGrade", 0.0);

        tvAverageGrade.setText("Computed Average: " + String.format("%.2f", average));
        tvMathGrade.setText("Math Grade: " + String.format("%.2f", mathGrade));
        tvMapehGrade.setText("MAPEH Grade: " + String.format("%.2f", mapehGrade));
        tvFilipino.setText("Filipino Grade: " + String.format("%.2f", filipinoGrade));
        tvScience.setText("Science Grade: " + String.format("%.2f", scienceGrade));
        tvEnglish.setText("English Grade: " + String.format("%.2f", englishGrade));

        setHeronReaction();

        btnBack.setOnClickListener(v -> finish());
    }
    public void setHeronReaction(){

        if(average >= 1.0 && average <= 5.0 ){
            if(average < 2.0){heronReaction.setImageResource(R.drawable.amazed);}
            else{heronReaction.setImageResource(R.drawable.sad);}
        } else if (average >=5.0 )  {

            if(average< 75){
                heronReaction.setImageResource(R.drawable.sad);
            }

        }

    }
}