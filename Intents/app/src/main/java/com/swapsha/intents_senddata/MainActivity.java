package com.swapsha.intents_senddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Variables declared
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variables assigned
        editText = (EditText)findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = editText.getText().toString();
                //Intent object is defined to set which activity to start
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                //Bundle object is created
                Bundle bundle = new Bundle();
                //put functions can be used to attach data
                bundle.putString("String",string);
                //putExtras is used to attach the bundle
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
