package com.example.kevinjuma.myapplication;

//importation des bibliothèques
import android.support.v7.app.AppCompatActivity;
import android.os.Build;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnChronometerTickListener, OnClickListener {
    //declaration des varibles
    EditText Value;
    TextView Text;
    Button Clique;
    Chronometer Timer;
    int delay,i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //affiliation du bouton à son entité
        Value=(EditText) findViewById(R.id.etvValue);
        Clique=(Button) findViewById(R.id.btnClick);
        Timer=(Chronometer) findViewById(R.id.cmMeter);
        Text=(TextView) findViewById(R.id.tvMsg);

        Clique.setOnClickListener(this);
        Timer.setOnChronometerTickListener(this);
        Timer.setVisibility(-1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnClick)
        {
            Timer.stop();
            delay=Integer.parseInt(Value.getText().toString());
            Timer.start();
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {

        //création du toast
        Text.setText("Temps: [ 0"+ (delay-i) +" ]");
        if(i==delay)
        {
            Toast.makeText(getApplicationContext(), "Nani ?..!!", 20).show();
            i=0;
            Timer.stop();
        }
        i++;
    }
}