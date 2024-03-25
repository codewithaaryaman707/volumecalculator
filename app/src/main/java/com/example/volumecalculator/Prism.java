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

public class Prism extends AppCompatActivity {

    TextView txtView_title, txtView_result;
    Button btn_prism;
    EditText editText_baseArea, editText_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);

        txtView_title = findViewById(R.id.text_title);
        txtView_result = findViewById(R.id.result_prism);
        btn_prism = findViewById(R.id.btn_prism);
        editText_baseArea = findViewById(R.id.base_area_prism);
        editText_height = findViewById(R.id.height_prism);


        btn_prism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseArea = editText_baseArea.getText().toString();
                String height = editText_height.getText().toString();

                int b = Integer.parseInt(baseArea);
                int h = Integer.parseInt(height);

                double volume = b * h;

                txtView_result.setText("V= "+volume+ "m^3");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}