package com.example.scaleobject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class ScaleObject extends Activity {

    boolean Meters;
    boolean English;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_object);
       final RadioButton metersbutton = (RadioButton)findViewById(R.id.radioButton_meters);
       final RadioButton Englishbutton = (RadioButton)findViewById(R.id.radioButton_English);
       final EditText meterstext = (EditText)findViewById(R.id.editText_meters);
       final EditText feettext = (EditText)findViewById(R.id.editText_feet);
       final EditText inchestext = (EditText)findViewById(R.id.editText_inches);
       final EditText nexttext = (EditText)findViewById(R.id.nextText);
       //TextView nextText = (TextView)findViewById(R.id.nextText);

        // Random x and y values that will be used until linked with other activity
        int x1 = 200;
        int x2 = 500;
        int y1 = 100;
        int y2 = 500;

        // Feet to meters constant
       final int m = 82021/25000;

        // Length between pixels equation
       final double pix = ((((x1 - x2) ^ 2) + ((y1 - y2) ^ 2))) ^ (1/2);
        /**
         * This is where the different units can be selected and the proper text box appears for the
         * units to be converted from pixels to the selected units.
         */
        metersbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (metersbutton.isChecked() == true) {

                    // Makes the text box visible and usable
                    meterstext.setVisibility(View.VISIBLE);

                     Meters = true;
                    English = false;
                }


            }


        });



        Englishbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (Englishbutton.isChecked() == true) {

                    // Makes the text boxes visible and usable
                    feettext.setVisibility(View.VISIBLE);
                    inchestext.setVisibility(View.VISIBLE);

                   English = true;
                    Meters = false;


                }
            }

        });

        nexttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Meters = true){

                    // Getting and parsing the value typed in the text box
                    String si =  meterstext.getText().toString();
                    double meterEntry = Double.parseDouble(si);

                    // This is where the scale is created from the typed value and pixel difference
                    double scale = meterEntry/pix;


                }
                else if(English = true){

                    // Getting and parsing the values typed in the text boxes
                    String ft = feettext.getText().toString();
                    double feetEntry = Double.parseDouble(ft);
                    String in = inchestext.getText().toString();
                    double inchesEntry = Double.parseDouble(in);

                    // This is where the scale is created and converted into meters per pixel
                    double scale = (feetEntry + (inchesEntry/12))/(m * pix);

                }
            }
        });

        /**
         * This is all the coding for making the nextText clickable and going to the next page.
         */
/**
        nextText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


            }
        });
**/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scale_object, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
