package com.eugenesumaryev.mygraphicsapp01;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends Activity /*implements AdapterView.OnItemSelectedListener */ {

    private GraphicsView graphicsView;
    private ImageButton currPaint;
    public ImageSpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graphicsView = (GraphicsView)findViewById(R.id.graphicsView);

        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);

        currPaint = (ImageButton)paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));

        Spinner spinner = (Spinner) findViewById(R.id.brush_size);
       // spinner.setOnItemClickListener(this);

        ArrayList<BrushItem> list = new ArrayList<BrushItem>();
       /*
        list.add(new BrushItem(R.drawable.large_circle, "one"));
        list.add(new BrushItem(R.drawable.medium_circle, "two"));
        list.add(new BrushItem(R.drawable.small_circle, "three"));
        */

        list.add(new BrushItem("one"));
        list.add(new BrushItem("two"));
        list.add(new BrushItem("three"));

        // Create an ArrayAdapter using the string array and a default spinner layout
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        //        R.array.circles, R.layout.circles_spinner_layout);

        adapter = new ImageSpinnerAdapter(this,
                R.layout.circles_spinner_layout, list);



        // Specify the layout to use when the list of choices appears
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Listener called when spinner item selected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View v, int position, long id) {
                // your code here
                graphicsView.changeBrush(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        }


    public void paintClicked(View view){

        //use chosen color
        if(view!=currPaint){
            //update color
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();

            graphicsView.setColor(color);

            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint=(ImageButton)view;
        }


    }

    public void onNewClicked(View view){

        graphicsView.resetBitmap();
        changeColor(currPaint);

    }

    public void onBrushClicked(View view){

        /*
        String color = currPaint.getTag().toString();
        graphicsView.setColor(color);
        */
        changeColor(currPaint);

    }

    public void onEraseClicked(View view){

       // String color = String.valueOf(R.color.canvas_background_color);

        /*
        String color = view.getTag().toString();
        graphicsView.setColor(color);
        */
        changeColor(view);



    }

    public void onSaveClicked(View view){

    }

    private void changeColor(View view){

        String color = view.getTag().toString();
        graphicsView.setColor(color);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.graphics, menu);
        return true;
    }

/*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
    */
}
