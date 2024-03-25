package com.example.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sphere extends AppCompatActivity {

    EditText editText_SphereRadius;
    TextView textView_Title, textView_result_sphere;
    Button btn_sphere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);

        editText_SphereRadius = findViewById(R.id.sphere_radius);
        textView_result_sphere= findViewById(R.id.result_sphere);
        textView_Title = findViewById(R.id.textView_title);
        btn_sphere = findViewById(R.id.btn_sphere);

        btn_sphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Volume is (4/3) * pi * r^3
                String radius = editText_SphereRadius.getText().toString();

                int r = Integer.parseInt(radius);

                double volume = (4/3) * 3.14159 * r*r*r;

                textView_result_sphere.setText("V = " +volume+ "m^3");

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}