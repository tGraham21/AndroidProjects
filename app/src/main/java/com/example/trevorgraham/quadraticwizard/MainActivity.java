package com.example.trevorgraham.quadraticwizard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import java.lang.Math;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    Button mButton;
    TextView mView1;
    TextView mView2;
    EditText mTextA;
    EditText mTextB;
    EditText mTextC;
    String posQuad;
    String negQuad;
    double valueA;
    double valueB;
    double valueC;
    double ans1;
    double ans2;
    public double topSqrt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.solveButton);
        mView1 = (TextView) findViewById(R.id.output1);
        mView2 = (TextView) findViewById(R.id.output2);
        mTextA = (EditText) findViewById(R.id.editTextA);
        mTextB = (EditText) findViewById(R.id.editTextB);
        mTextC = (EditText) findViewById(R.id.editTextC);


       


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valueA = (double) Integer.parseInt(mTextA.getText().toString());
                valueB = (double) Integer.parseInt(mTextB.getText().toString());
                valueC = (double) Integer.parseInt(mTextC.getText().toString());
                topSqrt = Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC)));
                //if( Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC)))<0) {
                    //imagNum(topSqrt);
                    //double topPos = (((valueB)) + Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC))));
                    ////double topNeg = (((valueB)) - Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC))));
                    //topSqrt = Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC)));
                    //ans1 = ((topPos) / (2 * valueA) * -1);
                    //ans2 = ((topNeg) / (2 * valueA) * -1);
                    //mView1.setText(((valueB) + (imagNum(topSqrt))) + "/" + ((2 * valueA) * -1));
                //}


                {
                    double topPos = (((valueB)) + Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC))));
                    double topNeg = (((valueB)) - Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC))));
                    topSqrt = Math.sqrt((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC)));
                    //ans1 = ((topPos) / (2 * valueA) * -1);
                    // ans2 = ((topNeg) / (2 * valueA) * -1);
                    if ((Math.pow(valueB, 2.0) - (4.0 * valueA * valueC)) < 0) {
                        mView1.setText("Imaginary Solution");
                        mView2.setText("Imaginary Solution");

                    } else {
                        ans1 = ((topPos) / (2 * valueA) * -1);
                        ans2 = ((topNeg) / (2 * valueA) * -1);


                        posQuad = "x = " + ans1;
                        negQuad = "x = " + ans2;


                        mView1.setText(round(posQuad));
                        mView2.setText(round(negQuad));
                    }

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public String imagNum(double i) {
        double square = i / 2;
        String imagin= "";
        if (i < 0) {
            if (square * 2 == 1) {
                imagin = square + "i";
            }
        }
        return imagin;
    }

    public String round(String d ){
        String num= ""+d;
        if(num.contains(".")){
            num = num.substring(0, (num.indexOf(".")+5));
        }

        return num;
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
