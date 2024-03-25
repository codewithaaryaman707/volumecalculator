package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private final ArrayList<Shape> shapesArrayList;  // Data Source has been passed as an Array List
    Context context; // Context refers to the current state and environment of the app.
    // It will provide access to various resources and systems that the app needs to interact with system and perform task.


    public MyCustomAdapter( ArrayList<Shape> shapesArrayList, Context context1) {
        super(context1, R.layout.grid_item_layout, shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context1;
    }

    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImg;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Shape shapes = getItem(position); // Getting shape object for current position

        MyViewHolder myViewHolder;
        if(convertView == null){
            // NO view went off screen, so creating new View
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );

        /* LayoutInflater: Utility class that is used to instantiate XML Layout files and convert
            them into corresponding view objects
            So the process of creating the views objects from the XML layout files is defined as inflating
            */

            //Finding View
            myViewHolder.shapeName = convertView.findViewById(R.id.txtView);
            myViewHolder.shapeImg = convertView.findViewById(R.id.imageView);

            convertView.setTag(myViewHolder);


        }else {
            // Reusing the the view that went off-screen
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShapeImg());

        return convertView;

    }
    @Override
    public int getPosition(@Nullable Shape item) {
        if (item.getShapeName().equals("Sphere"))
            return 0;
        else if (item.getShapeName().equals("Cube"))
            return 1;
        else if (item.getShapeName().equals("Cylinder"))
            return 3;
        else if (item.getShapeName().equals("Prisim"))
            return 4;
        return -1;
    }
}
