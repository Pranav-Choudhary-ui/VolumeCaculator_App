package com.example.volumecalculatorapp;

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
import java.util.List;
import java.util.zip.Inflater;

public class ShapeCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList;
    Context context;



    public ShapeCustomAdapter(ArrayList<Shape> shapeArrayList, Context context) {
        super(context, R.layout.gridview_layout, shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MyViewHolder myViewHolder;
        Shape shape = getItem(position);

        if (convertView==null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.gridview_layout,parent,false);
            myViewHolder.img = (ImageView)  convertView.findViewById(R.id.img);
            myViewHolder.txt = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(myViewHolder);

        }
        else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.img.setImageResource(shape.getImage());
        myViewHolder.txt.setText(shape.getText());

        return convertView;
    }

    private class MyViewHolder{
        ImageView img;
        TextView txt;
    }
}
