package com.cognitive.englishmaster.activities;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.cognitive.englishmaster.R;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private ArrayList<Boolean> ans;
    private TextView totalTv, correctTv, wrongTv;
    private Button btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Find_All_Views();

    }

    @Override
    protected void onStart() {
        ans = (ArrayList<Boolean>) getIntent().getSerializableExtra("answers");
        setPoints();

        super.onStart();
    }

    private void Find_All_Views(){
        totalTv = findViewById(R.id.result_activity_total);
        correctTv = findViewById(R.id.result_activity_correct);
        wrongTv = findViewById(R.id.result_activity_wrong);
        btn_share = findViewById(R.id.result_activity_share);
    }
    private void setPoints()
    {
        int count = 0;
        totalTv.setText("Total Points: " + ans.size());

        for(int i=0; i < ans.size(); i++)
        {
            if(ans.get(i) == true)
                count++;
        }
        correctTv.setText("Points Won: " + count);
        wrongTv.setText("Points Lost: " + (ans.size()-count));
    }
}
