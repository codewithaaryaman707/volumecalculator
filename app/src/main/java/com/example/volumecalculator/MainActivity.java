package com.example.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapeArrayList;
    MyCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            gridView = findViewById(R.id.gridView);

            shapeArrayList = new ArrayList<>();
            Shape s1 = new Shape(R.drawable.sphere, "Sphere");
            Shape s2 = new Shape(R.drawable.cube, "Cube");
            Shape s3 = new Shape(R.drawable.cylinder, "Cylinder");
            Shape s4 = new Shape(R.drawable.prism, "Prism");

            shapeArrayList.add(s1);
            shapeArrayList.add(s2);
            shapeArrayList.add(s3);
            shapeArrayList.add(s4);

            adapter = new MyCustomAdapter(shapeArrayList, getApplicationContext());
            gridView.setAdapter(adapter);
            gridView.setNumColumns(2);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position==0)
                    {
                        Intent inext = new Intent(MainActivity.this,Sphere.class);
                        startActivity(inext);
                    }
                    else if(position==1)
                    {
                        Intent inext = new Intent(MainActivity.this,Cube.class);
                        startActivity(inext);
                    }
                    else if(position==2)
                    {
                        Intent inext = new Intent(MainActivity.this,Cylinder.class);
                        startActivity(inext);
                    }
                    else if(position==3){
                        Intent inext = new Intent(MainActivity.this,Prism.class);
                        startActivity(inext);

                    }
                }
            });


            return insets;
        });


    }
}