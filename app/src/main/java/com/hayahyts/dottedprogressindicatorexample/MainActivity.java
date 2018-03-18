package com.hayahyts.dottedprogressindicatorexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hayahyts.dottedprogressindicator.DottedProgressBar;

public class MainActivity extends AppCompatActivity {
    private int current = 0;
    private static final int TOTAL_SIZE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DottedProgressBar dottedProgressBar = findViewById(R.id.dotted_progress_bar);
        dottedProgressBar.setDotCount(TOTAL_SIZE);
        dottedProgressBar.setCurrent(current, true);

        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current < TOTAL_SIZE -1) {
                    dottedProgressBar.setCurrent(++current, true);
                }else {
                    current = 0;
                    dottedProgressBar.setCurrent(current, true);
                }

            }
        });
    }
}