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

public class Cylinder extends AppCompatActivity {

    EditText editText_Radius, editText_Height;
    TextView textView_Title, textView_Result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);

        editText_Radius = findViewById(R.id.radius_cylinder);
        editText_Height = findViewById(R.id.height_cylinder);
        textView_Title = findViewById(R.id.title_cylinder);
        textView_Result = findViewById(R.id.result_cylinder);
        btn = findViewById(R.id.btn_cylinder);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = editText_Radius.getText().toString();
                String height = editText_Height.getText().toString();

                int r = Integer.parseInt(radius);
                int h = Integer.parseInt(height);

                double volume = 3.14159 * r * r* h;

                textView_Result.setText("V ="+volume + "m^3");
            }
        });







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}