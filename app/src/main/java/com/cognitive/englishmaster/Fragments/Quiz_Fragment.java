package com.cognitive.englishmaster.Fragments;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TextView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.Question;
import com.cognitive.englishmaster.model_classes.model_Question_class;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Quiz_Fragment extends Fragment  {
  private   TextView Quiz_No,Question,Ans_1Txt,Ans_2Txt,Ans_3Txt,Ans_4Txt,Ans_5Txt;
   private RelativeLayout Ans_A,Ans_B,Ans_C,Ans_D,Ans_E;
    private ArrayList<Question> data;

    int value;
    View v;
    public Quiz_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences prefs = getActivity().getSharedPreferences("POS", MODE_PRIVATE);
        final int restoredText = prefs.getInt("position", 0);

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.question_list_design, container, false);
        FindAllViews();
        Ans_A.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
            try {
                Question currentitem = data.get(restoredText);
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Ans_A.setBackgroundResource(R.color.Right_green);
                    Ans_1Txt.setTextColor(R.color.white);
                }
                else{
                    Ans_A.setBackgroundResource(R.color.wrong_red);
                    Ans_1Txt.setTextColor(R.color.white);

                }

                }
            catch(Exception ex) {
                Ans_A.setBackgroundResource(R.color.Right_green);
                Ans_1Txt.setTextColor(R.color.white);
                Ans_D.setBackgroundResource(R.color.wrong_red);
                Ans_4Txt.setTextColor(R.color.white);

            } }
        });
        Ans_B.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                try{
                Question currentitem = data.get(restoredText);
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Ans_B.setBackgroundResource(R.color.Right_green);
                    Ans_2Txt.setTextColor(R.color.white);

                }
                else{
                    Ans_B.setBackgroundResource(R.color.wrong_red);
                    Ans_2Txt.setTextColor(R.color.white);

                }
                }catch(Exception ex) {
                    Ans_A.setBackgroundResource(R.color.Right_green);
                    Ans_1Txt.setTextColor(R.color.white);
                    Ans_D.setBackgroundResource(R.color.wrong_red);
                    Ans_4Txt.setTextColor(R.color.white);

                }
            }
        });
        Ans_C.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                try{
                    Question currentitem = data.get(restoredText);

                if(currentitem.getOption1() == currentitem.getOption5()){
                    Ans_C.setBackgroundResource(R.color.Right_green);
                    Ans_3Txt.setTextColor(R.color.white);

                }
                else{
                    Ans_C.setBackgroundResource(R.color.wrong_red);
                    Ans_3Txt.setTextColor(R.color.white);

                }
            }
            catch(Exception ex) {
                Ans_A.setBackgroundResource(R.color.Right_green);
                Ans_1Txt.setTextColor(R.color.white);
                Ans_D.setBackgroundResource(R.color.wrong_red);
                Ans_4Txt.setTextColor(R.color.white);

            }
            }
        });
        Ans_D.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                try {
                    Question currentitem = data.get(restoredText);
                    if (currentitem.getOption1() == currentitem.getOption5()) {
                        Ans_D.setBackgroundResource(R.color.Right_green);
                        Ans_4Txt.setTextColor(R.color.white);

                    } else {
                        Ans_D.setBackgroundResource(R.color.wrong_red);
                        Ans_4Txt.setTextColor(R.color.white);

                    }
                } catch (Exception ex) {
                    Ans_A.setBackgroundResource(R.color.Right_green);
                    Ans_1Txt.setTextColor(R.color.white);
                    Ans_D.setBackgroundResource(R.color.wrong_red);
                    Ans_4Txt.setTextColor(R.color.white);

                }
            }
        });
        Ans_E.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                try {
                Question currentitem = data.get(restoredText);
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Ans_E.setBackgroundResource(R.color.Right_green);
                    Ans_5Txt.setTextColor(R.color.white);

                }
                else{
                    Ans_E.setBackgroundResource(R.color.wrong_red);
                    Ans_5Txt.setTextColor(R.color.white);

                }
                }catch(Exception ex) {
                    Ans_A.setBackgroundResource(R.color.Right_green);
                    Ans_1Txt.setTextColor(R.color.white);
                    Ans_D.setBackgroundResource(R.color.wrong_red);
                    Ans_4Txt.setTextColor(R.color.white);

                }


            }
        });

        return v;
    }
    public void setTextValue(String question , String q1, String q2, String q3, String q4,String q5, String Right_ans,int no)
    {
        if(getView()==null)
            return;
        FindAllViews();
        Question.setText (question);
        Ans_1Txt.setText ("a.   "+q1);
        Ans_2Txt.setText ("b.   "+q2);
        Ans_3Txt.setText ("c.   "+q3);
        Ans_4Txt.setText ("d.   "+q4);
        Ans_5Txt.setText ("e.   "+q5);
        Quiz_No.setText(String.valueOf(no));

      }

  private void FindAllViews(){
      Quiz_No  = v.findViewById(R.id.Q_NO);
      Question = v.findViewById(R.id.Question_txt);
      Ans_1Txt = v.findViewById(R.id.Question_ans1_txt);
      Ans_2Txt = v.findViewById(R.id.Question_ans2_txt);
      Ans_3Txt = v.findViewById(R.id.Question_ans3_txt);
      Ans_4Txt = v.findViewById(R.id.Question_ans4_txt);
      Ans_5Txt = v.findViewById(R.id.Question_ans5_txt);

      Ans_A= v.findViewById(R.id.Question_ans1_CV);
      Ans_B= v.findViewById(R.id.Question_ans2_CV);
      Ans_C= v.findViewById(R.id.Question_ans3_CV);
      Ans_D= v.findViewById(R.id.Question_ans4_CV);
      Ans_E= v.findViewById(R.id.Question_ans5_CV);


  }

   /* @SuppressLint("ResourceAsColor")
    @Override
*/ /*   public void onClick(View v) {
       if(v == Ans_A){
        if(currentitem.getOption1() == currentitem.getOption5()){
            Ans_A.setBackgroundResource(R.color.Right_green);
            Ans_1Txt.setTextColor(R.color.white);

        }
        else{
            Ans_A.setBackgroundResource(R.color.wrong_red);
            Ans_1Txt.setTextColor(R.color.white);
        }
    }

        else if(v == Ans_B){

           if(currentitem.getOption2() == currentitem.getOption5()){
               Ans_B.setBackgroundResource(R.color.Right_green);
               Ans_2Txt.setTextColor(R.color.white);

           }
           else{
               Ans_B.setBackgroundResource(R.color.wrong_red);
               Ans_2Txt.setTextColor(R.color.white);
           }
    }
         else if(v == Ans_C)
            {
               if(currentitem.getOption3() == currentitem.getOption5()){
                   Ans_C.setBackgroundResource(R.color.Right_green);
                   Ans_3Txt.setTextColor(R.color.white);

               }
               else{
                   Ans_C.setBackgroundResource(R.color.wrong_red);
                   Ans_3Txt.setTextColor(R.color.white);
               }
           }
        else if(v == Ans_D)
        {
           if(currentitem.getOption3() == currentitem.getOption5()){
               Ans_D.setBackgroundResource(R.color.Right_green);
               Ans_4Txt.setTextColor(R.color.white);

           }
           else{
               Ans_D.setBackgroundResource(R.color.wrong_red);
               Ans_4Txt.setTextColor(R.color.white);
           }
       }
       else if(v == Ans_E){
           if(currentitem.getOption3() == currentitem.getOption5()){
               Ans_E.setBackgroundResource(R.color.Right_green);
               Ans_5Txt.setTextColor(R.color.white);

           }
           else{
               Ans_E.setBackgroundResource(R.color.wrong_red);
               Ans_5Txt.setTextColor(R.color.white);
           }
       }

    }
*/
}


