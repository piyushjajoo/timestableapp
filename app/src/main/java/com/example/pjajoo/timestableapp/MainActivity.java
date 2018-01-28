package com.example.pjajoo.timestableapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.pjajoo.timestablesapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tablesSeekbar = (SeekBar) findViewById(R.id.timesTableChanger);
        tablesSeekbar.setMax(10);
        tablesSeekbar.setProgress(1);

        final ListView tables = (ListView) findViewById(R.id.table);

        final ArrayAdapter<Integer> tableAdapter = new ArrayAdapter<Integer>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        tables.setAdapter(tableAdapter);

        final TextView textView = (TextView) findViewById(R.id.timesTableForText);
        textView.setText("Current Running table is 1");

        tablesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getProgress() == 0) {
                    seekBar.setProgress(1);
                }
                tablesSeekbar.setProgress(seekBar.getProgress());
                Log.i("Seekbar value ", Integer.toString(seekBar.getProgress()));
                textView.setText("Current Running table is " + Integer.toString(seekBar.getProgress()));
                final List<Integer> tableValues = new ArrayList<Integer>();
                for (int i = 1; i < 11; i++) {
                    tableValues.add(i - 1, seekBar.getProgress() * i);
                }
                final ArrayAdapter<Integer> tableAdapter = new ArrayAdapter<Integer>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, tableValues);
                tables.setAdapter(tableAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
