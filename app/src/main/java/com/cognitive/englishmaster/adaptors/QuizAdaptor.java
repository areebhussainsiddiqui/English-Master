package com.cognitive.englishmaster.adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.KeyEventDispatcher;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.activities.QuizActivity;
import com.cognitive.englishmaster.model_classes.Question;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class QuizAdaptor extends RecyclerView.Adapter<QuizAdaptor.QuizViewHolder>
{
    private Context ctx;
    private ArrayList<Question> data;

    // constructor
    public QuizAdaptor(Context ctx, ArrayList<Question> data)
    {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)  {
        View view = LayoutInflater.from(ctx).inflate(R.layout.question_list_design, viewGroup, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuizViewHolder Holder, final int i) {
        final Question currentitem = data.get(i);
       // Holder.setData(data.get(i), (i+1), data.size());
        Holder.Quiz_No.setText(String.valueOf(i));
        Holder.Question.setText(currentitem.getStatement());
        Holder.Ans_1Txt.setText(currentitem.getOption1());
        Holder.Ans_2Txt.setText(currentitem.getOption2());
        Holder.Ans_3Txt.setText(currentitem.getOption3());
        Holder.Ans_4Txt.setText(currentitem.getOption4());
        Holder.Ans_5Txt.setText(currentitem.getOption5());

        Holder.Ans_A.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Holder.Ans_A.setBackgroundResource(R.color.circle_red_Color);
                    Holder.Ans_1Txt.setTextColor(R.color.white);
                }
                else{
                    Holder.Ans_A.setBackgroundResource(R.color.circle_red_Color);
                    Holder.Ans_1Txt.setTextColor(R.color.white);

                }
            }
        });
        Holder.Ans_B.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Holder.Ans_B.setBackgroundResource(R.color.Right_green);
                    Holder.Ans_2Txt.setTextColor(R.color.white);

                }
                else{
                    Holder.Ans_B.setBackgroundResource(R.color.circle_red_Color);
                    Holder.Ans_2Txt.setTextColor(R.color.white);

                }
            }
        });
        Holder.Ans_C.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Holder.Ans_C.setBackgroundResource(R.color.Right_green);
                    Holder.Ans_3Txt.setTextColor(R.color.white);

                }
                else{
                    Holder.Ans_C.setBackgroundResource(R.color.circle_red_Color);
                    Holder.Ans_3Txt.setTextColor(R.color.white);

                }
            }
        });
        Holder.Ans_D.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")

            @Override
            public void onClick(View v) {
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Holder.Ans_D.setBackgroundResource(R.color.Right_green);
                    Holder.Ans_4Txt.setTextColor(R.color.white);

                }
                else{
                    Holder.Ans_D.setBackgroundResource(R.color.circle_red_Color);
                    Holder.Ans_4Txt.setTextColor(R.color.white);

                }
            }
        });
        Holder.Ans_E.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")

            @Override
            public void onClick(View v) {
                if(currentitem.getOption1() == currentitem.getOption5()){
                    Holder.Ans_E.setBackgroundResource(R.color.Right_green);
                    Holder.Ans_5Txt.setTextColor(R.color.white);

                }
                else{
                    Holder.Ans_E.setBackgroundResource(R.color.circle_red_Color);
                    Holder.Ans_5Txt.setTextColor(R.color.white);

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class QuizViewHolder extends RecyclerView.ViewHolder
    {
        private ArrayList<Boolean> answers;
        private TextView Quiz_No,Question,Ans_1Txt,Ans_2Txt,Ans_3Txt,Ans_4Txt,Ans_5Txt;
        private RelativeLayout Ans_A,Ans_B,Ans_C,Ans_D,Ans_E;

        @SuppressLint("RestrictedApi")
        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);

            answers = new ArrayList<>();
          FindAllView();




    }
private void FindAllView(){
    Quiz_No =  itemView.findViewById(R.id.question_number);
    Question = itemView.findViewById(R.id.Question_txt);
    Ans_1Txt=  itemView.findViewById(R.id.Question_ans1_txt);
    Ans_2Txt=  itemView.findViewById(R.id.Question_ans2_txt);
    Ans_3Txt=  itemView.findViewById(R.id.Question_ans3_txt);
    Ans_4Txt=  itemView.findViewById(R.id.Question_ans4_txt);
    Ans_5Txt=  itemView.findViewById(R.id.Question_ans5_txt);
    Ans_A=     itemView.findViewById(R.id.Question_ans1_CV);
    Ans_B=     itemView.findViewById(R.id.Question_ans2_CV);
    Ans_C=     itemView.findViewById(R.id.Question_ans3_CV);
    Ans_D=     itemView.findViewById(R.id.Question_ans4_CV);
    Ans_E=     itemView.findViewById(R.id.Question_ans5_CV);

}

    }

}
