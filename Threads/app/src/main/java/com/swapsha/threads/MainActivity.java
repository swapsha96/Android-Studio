package com.swapsha.threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Variables declared.
    String string;
    TextView textView;
    Button button;
    //Handler object is created to make changes in UI. DO NOT MAKE CHANGES IN UI INSIDE RUNNABLE. ALWAYS USE Handler
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //Text is set from String variable in which value is set inside Runnable
            textView = (TextView) findViewById(R.id.textView);
            textView.setText(string);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Runnable object is declared as final to access it inside OnClick function
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 5000;
                //following snippet waits for 50 seconds and then sete value to string variable
                while(System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                string = "Text set!";
                //handler is called using sendEmptyMessage(0)
                handler.sendEmptyMessage(0);
            }
        };

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Thread object is created and Runnable object is set as parameter then started
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });

    }
}
