package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class credits extends AppCompatActivity {

    Intent gi;


    /**
     * occurs during app creation ( 1 time only )
     * <p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }


    /**
     *
     * gets Menu
     * Creation and inflation of OptionsMenu on this activity + adding home button
     */
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.credits, menu);
        menu.add("home");
        return true;

    }


    /**
     * checks which button was pressed and acts accordingly
     * @param  item
     * @return method either moves user to another activity or closes the app with data save
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("home")) {
            finish();
        }
        return true;

    }


    /**
     * goes back to main activity
     * @param  item
     */
    public void credits(MenuItem item) {
        gi = new Intent(this, credits.class);
        startActivity(gi);

    }
}

