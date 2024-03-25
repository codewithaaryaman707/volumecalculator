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

public class Cube extends AppCompatActivity {

    TextView txtView_Title, txtView_Result;
    Button btn_Cube;
    EditText edittext_Side;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            txtView_Title = findViewById(R.id.title_cube);
            txtView_Result = findViewById(R.id.result_cube);
            btn_Cube = findViewById(R.id.btn_cube);
            edittext_Side = findViewById(R.id.side_cube);

            btn_Cube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String sideLength = edittext_Side.getText().toString();

                    int s =Integer.parseInt(sideLength);

                    double volume = s * s * s;

                    txtView_Result.setText("Volume: "+volume + "m^3");
                }
            });





            return insets;
        });
    }
}