package com.cognitive.englishmaster.activities;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.cognitive.englishmaster.R;

public class DifficultyLevelActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView btn_beginner,btn_intermediate,btn_Advance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);
        Find_All_Views();
    }
    private void Find_All_Views(){
        btn_beginner        = findViewById(R.id.diff_lev_beginner);
        btn_intermediate    = findViewById(R.id.diff_lev_intermediate);
        btn_Advance         = findViewById(R.id.diff_lev_advance);
    }


    @Override
    public void onClick(View v) {
        if(v == btn_beginner){
            startActivity(new Intent(this, VocabularyActivity.class));

        }
        else if(v == btn_intermediate){
            startActivity(new Intent(this, Select_Language.class));
        }
        else if(v == btn_Advance){
            startActivity(new Intent(this, Idioms_Activity.class));

        }
    }
}
