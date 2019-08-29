package me.erika.urbandirectory.view;

import androidx.appcompat.app.AppCompatActivity;
import me.erika.urbandirectory.R;
import android.os.Bundle;

/***
 Description: Urban Dictionary Hub Activity
 Author: Erika Orozco
 ***/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load SearchFragment
        if(savedInstanceState==null) {
            SearchFragment firstFragment = new SearchFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }


    }
}
