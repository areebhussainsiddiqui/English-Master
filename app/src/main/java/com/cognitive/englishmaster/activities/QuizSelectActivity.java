package com.cognitive.englishmaster.activities;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cognitive.englishmaster.R;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class QuizSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private CheckBox cb1,cb2,cb3;
    private Button btn_done,btn_DontAsk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_select);
        Find_All_Views();




      }

    @Override
    protected void onStart() {
        SlidrInterface slidr = Slidr.attach(this);
        slidr.unlock();

        super.onStart();
    }

    private void Find_All_Views(){
            cb1 = findViewById(R.id.Quiz_Select_cb1);
            cb2 = findViewById(R.id.Quiz_Select_cb2);
            cb3 = findViewById(R.id.Quiz_Select_cb3);
            btn_done = findViewById(R.id.Quiz_Select_btn_done);
            btn_DontAsk = findViewById(R.id.Quiz_Select_btn_DontAsk);
        }
    @Override
    public void onClick(View v) {
        if(v == btn_done)
        {
            if(cb1.isChecked() || cb2.isChecked() ||cb3.isChecked()) {
                startActivity(new Intent(QuizSelectActivity.this, QuizActivity.class));
            }else {
                Toast.makeText(getApplicationContext(),"Select any one",Toast.LENGTH_SHORT).show();
            }
        }else if(v == btn_DontAsk)
        {
            Toast.makeText(getApplicationContext(),"Don't Ask",Toast.LENGTH_SHORT).show();
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.Quiz_Select_cb1:
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                    cb1.setChecked(checked);

                break;
            case R.id.Quiz_Select_cb2:
                cb1.setChecked(false);
                cb3.setChecked(false);
                cb2.setChecked(checked);

                break;

            case R.id.Quiz_Select_cb3:
                cb1.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(checked);

                break;
            // TODO: Veggie sandwich
        }
    }
}
