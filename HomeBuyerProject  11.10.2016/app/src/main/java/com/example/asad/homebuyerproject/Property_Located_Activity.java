package com.example.asad.homebuyerproject;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Property_Located_Activity extends AppCompatActivity {


    private Toolbar toolbar;
    private Button mNextActivity;
    String datafrompreviousactivity;
    private  Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property__located_);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                datafrompreviousactivity= null;
            } else {
                datafrompreviousactivity= extras.getString("SellRentData");
            }
        } else {
            datafrompreviousactivity= (String) savedInstanceState.getSerializable("SellRentData");
        }


        TypeCasting();
        SetToolbar();

        //FOR BACK BUTTON ENABLED
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplication(),datafrompreviousactivity,Toast.LENGTH_SHORT).show();
                Intent next = new Intent(Property_Located_Activity.this,Residential_Commercial_Activity.class);
                //pass data to other activity which get from SellRentActivity
                next.putExtra("SellRentData", datafrompreviousactivity);
                startActivity(next);
            }
        });
    }

    public void SetToolbar() {
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //   Toolbartext.setText("Test Screen");

    }

    public void TypeCasting() {

        mNextActivity=(Button)findViewById(R.id.NextActivity);
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

        //FOR BACK BUTTON ALSO INCLUDE META DATA IN MANIFEST
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);

    }

}
