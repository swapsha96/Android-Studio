package com.swapsha.mylists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables declared outside
    String[] items;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //values assigned inside
        items = new String[]{"wef", "we", "wdef", "wf", "wewf"};
        listView = (ListView)findViewById(R.id.listView);

        //Array Adapter used to attach array strings to the listview. Keep parameters in mind. Don't use getApplicationContext()
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(arrayAdapter);

        //OnClick function created
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //String is extracted and stored in another variable
                String item = parent.getItemAtPosition(position).toString();
                //Toast to show string
                Toast.makeText(MainActivity.this,"You clicked \"" + item + "\".",Toast.LENGTH_LONG).show();
            }
        });
    }
}
