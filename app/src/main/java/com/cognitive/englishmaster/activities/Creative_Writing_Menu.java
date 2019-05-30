package com.cognitive.englishmaster.activities;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cognitive.englishmaster.R;

public class Creative_Writing_Menu extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout Reading_Vocab,Writing_Vocab,Listen_Vocab,Speaking_Vocab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creativewriting__menu);
        Find_All_Views();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        if(v == Reading_Vocab)
        {
        startActivity(new Intent(this,Idioms_image_Activity.class));
        }else if(v == Writing_Vocab)
        {
            startActivity(new Intent(this,Pair_of_Words_Activity.class));


        }else if(v == Listen_Vocab)
        {

        }else if(v == Speaking_Vocab)
        {

        }

    }
    private void Find_All_Views(){
        Reading_Vocab = findViewById(R.id.Crea_Wri_ReadingVocabulary_btn);
        Writing_Vocab = findViewById(R.id.Crea_Wri_WritingVocabulary_btn);
        Listen_Vocab  = findViewById(R.id.Crea_Wri_ListeningVocabulary_btn);
        Speaking_Vocab = findViewById(R.id.Crea_Wri_SpeakingVocabulary_btn);
    }
}
