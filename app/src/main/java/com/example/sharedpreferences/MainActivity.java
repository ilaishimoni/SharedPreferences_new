package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @author		Ilai Shimoni <ilaishimoni@gmail.com>
 * @version	     1.0
 * @since		03/01/22
 * application saves data into an internal file and shows saved text on the app
 */

public class MainActivity extends AppCompatActivity {
    int count = 0;
    Button count_btn;
    TextView tv;
    EditText et;
    Intent si;
    String name;






    /**
     * occurs during app creation ( 1 time only )
     * <p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count_btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
    }


    /**
     * occurs at app creation and application start, gets data from SharedPreferences file and displays to user
     * <p>
     */
    protected void onStart() {
        SharedPreferences settings=getSharedPreferences("name_count",MODE_PRIVATE);
        name = settings.getString("name", "enter name");
        count = settings.getInt("count", 0);

        et.setText(name);
        tv.setText(count + "");

        super.onStart();

    }


    /**
     * occurs at app closure, saves data to file
     * <p>
     */
    protected void onStop() {
        SharedPreferences settings=getSharedPreferences("name_count",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("name",(et.getText().toString()));
        editor.putInt("count",(count));
        editor.commit();
        super.onStop();
    }




    /**
     * displays new count (adds 1) and updates parameter
     * <p> button press
     */
    public void count_plus(View view) {
        count++;
        tv.setText("" + count);
    }
    /**
     * displays new count (0) and updates parameter
     * <p> button press
     */
    public void reset(View view) {
        count = 0;
        tv.setText(""+0);

    }
    /**
     * saves data at to SharedPreferences file
     * <p> "exit" button press
     */
    public void save_data(View view) {

        if(et.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),"enter your name", Toast.LENGTH_SHORT);

        }
        else{
            SharedPreferences settings=getSharedPreferences("name_count",MODE_PRIVATE);
            SharedPreferences.Editor editor=settings.edit();
            editor.putString("name",(et.getText().toString()));
            editor.putInt("count",(count));
            editor.commit();

        }
        finish();


    }



    /**
     *
     * gets Menu
     * Creation and inflation of OptionsMenu on this activity
     */
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.credits, menu);


        return true;

    }


    /**
     *
     * gets Menu
     * Creation and inflation of OptionsMenu on this activity
     */
    public void credits(MenuItem item) {
        si = new Intent(this, credits.class);
        startActivity(si);

    }
}