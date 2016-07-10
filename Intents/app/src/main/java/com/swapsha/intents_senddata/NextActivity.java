package com.swapsha.intents_senddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        textView = (TextView)findViewById(R.id.textView);
        //bundle caught is stored using getIntent().getExtras()
        Bundle bundle = getIntent().getExtras();
        //Error checking
        if (bundle == null) {
            return;
        }
        //get functions can be used to store the data in another variable
        String string = bundle.getString("String");
        //string is shown
        textView.setText("Hello " + string + "!");
    }
}
