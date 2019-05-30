package com.cognitive.englishmaster.Fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.activities.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragments extends Fragment  {


    private CardView  dailystuffbtn, quizbtn, grammerbtn, creativebtn;
    private CardView vocablary_imageView;
    private View v;

    public Home_Fragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);
        All_ids();


        creativebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Creative_Writing_Menu.class);
                startActivity(intent);
            }
        });

        dailystuffbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BlogActivity.class);
                startActivity(intent);
            }
        });

        quizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuizSelectActivity.class);
                startActivity(intent);
            }
        });
        grammerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GrammerActivity.class);
                startActivity(intent);
            }
        });

        vocablary_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DifficultyLevelActivity.class);
                startActivity(intent);

            }
        });

        return v;
    }
    private void All_ids(){

        creativebtn = v.findViewById(R.id.main_activity_creative_writing_layout);
        dailystuffbtn = v.findViewById(R.id.main_activity_daily_stuff_layout);
        quizbtn = v.findViewById(R.id.main_activity_quiz_layout);
        grammerbtn = v.findViewById(R.id.main_activity_grammar_layout);
        vocablary_imageView = v.findViewById(R.id.main_activity_vocabulary_layout);
    }
/*
    @Override
    public void onClick(View v) {
        if(v == vocablary_imageView)
        {

        }
        else if(v == dailystuffbtn)
        {

        }
        else if(v == quizbtn)
        {

        }
        else if(v == grammerbtn)
        {

        }
        else if(v == creativebtn)
        {

        }

    }*/
}
