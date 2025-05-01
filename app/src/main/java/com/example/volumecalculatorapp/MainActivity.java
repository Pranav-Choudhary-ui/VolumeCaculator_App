package com.example.volumecalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Shape> shapeArrayList;
    ShapeCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView gridView = findViewById(R.id.gridview);

        shapeArrayList = new ArrayList<>();

        Shape s3 = new Shape(R.drawable.sphere, "Sphere");
        Shape s2 = new Shape(R.drawable.cylinder, "Cylinder");
        Shape s1 = new Shape(R.drawable.cube, "Cube");
        Shape s4 = new Shape(R.drawable.prism, "Prism");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter = new ShapeCustomAdapter(shapeArrayList, getApplicationContext());
        gridView.setAdapter(adapter);

        // Completed above this comment. Rest work is to be done of either creating different
        // activities or using switch cases in same switch case

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView a = findViewById(R.id.text1);
                String name = a.getText().toString();
//
//                Method 1-
//                try {
//                    Class<?> activityclass = Class.forName("com.example.volumecalculatorapp." + str);
//                    Intent i = new Intent(getApplicationContext(), activityclass);
//                    startActivity(i);
//                } catch (ClassNotFoundException e) {
//                    Toast.makeText(getApplicationContext(),"Activity for "+str+" not Found",Toast.LENGTH_SHORT).show();
//                }


//                Method 2 -
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("name",name);
                startActivity(i);
            }
        });

    }
}