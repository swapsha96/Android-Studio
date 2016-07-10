package com.swapsha.sqlmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText)findViewById(R.id.input);
        Button add = (Button)findViewById(R.id.add);
        Button clear = (Button)findViewById(R.id.clear);
        final TextView output = (TextView)findViewById(R.id.output);
        final DBManager dbManager = new DBManager(MainActivity.this,null,null,1);
        output.setText(dbManager.showTable().toString());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbManager.addMember(input.getText().toString());
                output.setText(dbManager.showTable().toString());
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbManager.clear(input.getText().toString());
                output.setText(dbManager.showTable().toString());
            }
        });
    }
}
