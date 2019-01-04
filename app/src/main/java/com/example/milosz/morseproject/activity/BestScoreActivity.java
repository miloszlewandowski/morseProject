package com.example.milosz.morseproject.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.milosz.morseproject.R;
import com.example.milosz.morseproject.persistence.Database;

import java.util.List;

public class BestScoreActivity extends Activity {

    private Database database = new Database(this);
    private LinearLayout renderTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_score);
        renderTable = (LinearLayout)findViewById(R.id.renderTable);
        this.renderTable(this.database.getScores());
    }

    private void renderTable(List<Integer> scores) {
        while (this.renderTable.getChildCount() > 0) {
            this.renderTable.removeViewAt(0);
        }
        int index = 1;
        TableLayout tableLayout = new TableLayout(this);
        this.renderTable.addView(tableLayout);
        for (int score : scores) {
            TableRow tableRow = new TableRow(this);
            TextView text1 = new TextView(this);
            TextView text2 = new TextView(this);
            text1.setText(Integer.toString(index));
            text2.setText(Integer.toString(score));
            text1.setTextSize(22);
            text1.setTextColor(Color.BLACK);
            text1.setLetterSpacing(2);
            text2.setTextSize(22);
            text2.setTextColor(Color.BLACK);
            tableRow.addView(text1);
            tableRow.addView(text2);
            tableLayout.addView(tableRow);
            index++;
        }
    }
}
