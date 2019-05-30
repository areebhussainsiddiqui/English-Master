package com.cognitive.englishmaster.activities;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cognitive.englishmaster.R;

public class SavedActivity extends AppCompatActivity {
    private TextView No_Saved_Articles , No_Saved_Questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        Find_All_Views();
    }
    private void Find_All_Views(){
        No_Saved_Articles = findViewById(R.id.saved_article_tv);
        No_Saved_Questions = findViewById(R.id.saved_questions_tv);
    }
}
