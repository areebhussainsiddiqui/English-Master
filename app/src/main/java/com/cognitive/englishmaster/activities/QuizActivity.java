package com.cognitive.englishmaster.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.cognitive.englishmaster.Fragments.Quiz_Fragment;;
import com.cognitive.englishmaster.model_classes.model_Question_class;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

import com.cognitive.englishmaster.R;

public class QuizActivity extends AppCompatActivity {
    private FragmentPagerAdapter adapterViewPager;
    private SmartTabLayout viewPagerTab ;
    private ViewPager viewPager;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Find_All_Views();
    }

    @Override
    protected void onStart() {
        Pager();

        super.onStart();
    }

    private void Find_All_Views(){
        viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

    }
    private void Pager(){
        viewPager.setOffscreenPageLimit(0);

        FragmentPagerItems.Creator creator = FragmentPagerItems.with(this);
        for (int i = 1, tabCount = 13; i < tabCount; i++) {

            creator.add(""+i,Quiz_Fragment.class);
        }
        final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());

        //  viewPager.setAdapter(adapterViewPager);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

        viewPagerTab.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {
                viewPagerTab.setSelectedIndicatorColors();
                viewPager.setCurrentItem(position+1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Data(position,adapter);
                SharedPreferences.Editor editor = getSharedPreferences("POS", MODE_PRIVATE).edit();
                editor.putInt("position", position);
                editor.apply();
        }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
       /* int  pageNo = getIntent ().getIntExtra ("position",0);

        viewPager.setCurrentItem(pageNo);*/

    }
    private void Data(int position , FragmentPagerItemAdapter adapter){
        Quiz_Fragment fragment = ((Quiz_Fragment) adapter.getPage(position));
        //for(int a  =0;a > androidColors.length;a++ ){


        List<model_Question_class> allItems = new ArrayList<>();
        allItems.add(new model_Question_class("Q1. At what percentage should he mark the Wiper up to get the required percentage profit", "10%", "20%", "15%", "5%", "5%", "5%"));
        allItems.add(new model_Question_class("Q2. The discount given by the shopkeeper on the purchase of the Toothpaste to the customer is Rs.4.40; find at what price did the shopkeeper sold the Toothpaste", "  Rs. 50", "  Rs. 50.60 ", " Rs. 45", " Rs. 48", " Rs. 48", " Rs. 48"));
        allItems.add(new model_Question_class("QUESTION3", "1", "2", "3", "4", "4", "4"));
        allItems.add(new model_Question_class("QUESTION4", "1", "2", "3", "3", "4", "3"));
        allItems.add(new model_Question_class("Q1. At what percentage should he mark the Wiper up to get the required percentage profit", "10%", "20%", "15%", "5%", "5%", "5%"));
        allItems.add(new model_Question_class("Q2. The discount given by the shopkeeper on the purchase of the Toothpaste to the customer is Rs.4.40; find at what price did the shopkeeper sold the Toothpaste", "  Rs. 50", "  Rs. 50.60 ", " Rs. 45", " Rs. 48", " Rs. 48", " Rs. 48"));
        allItems.add(new model_Question_class("QUESTION3", "1", "2", "3", "4", "4", "4"));
        allItems.add(new model_Question_class("QUESTION4", "1", "2", "3", "3", "4", "3"));
        allItems.add(new model_Question_class("Q1. At what percentage should he mark the Wiper up to get the required percentage profit", "10%", "20%", "15%", "5%", "5%", "5%"));
        allItems.add(new model_Question_class("Q2. The discount given by the shopkeeper on the purchase of the Toothpaste to the customer is Rs.4.40; find at what price did the shopkeeper sold the Toothpaste", "  Rs. 50", "  Rs. 50.60 ", " Rs. 45", " Rs. 48", " Rs. 48", " Rs. 48"));
        allItems.add(new model_Question_class("QUESTION3", "1", "2", "3", "4", "4", "4"));
        allItems.add(new model_Question_class("QUESTION4", "1", "2", "3", "3", "4", "3"));


        fragment.setTextValue(

                String.valueOf(allItems.get(position).getQuestion()),
                String.valueOf(allItems.get(position).getAns1()),
                String.valueOf(allItems.get(position).getAns2()),
                String.valueOf(allItems.get(position).getAns3()),
                String.valueOf(allItems.get(position).getAns4()),
                String.valueOf(allItems.get(position).getAns5()),
                String.valueOf(allItems.get(position).getRightAns()),
                position+1);
        //     bindViews ();

    }
}
  /*  private FragmentPagerAdapter adapterViewPager;
    private SmartTabLayout viewPagerTab ;
    private ViewPager viewPager;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Find_All_Views();
    }

    @Override
    protected void onStart() {
        Pager();

        super.onStart();
    }

    public void bottomBarIconClicked(View v) {
        if (v.getId() == R.id.home_icon)
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
        else if (v.getId() == R.id.idea_icon)
            Toast.makeText(this, "idea", Toast.LENGTH_SHORT).show();
        else if (v.getId() == R.id.voice_icon)
            startActivity(new Intent(this, AudioListActivity.class));
        else if (v.getId() == R.id.help_icon)
            Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();
    }
    private void Find_All_Views(){
        viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

    }
    private void Pager(){
        viewPager.setOffscreenPageLimit(0);

        FragmentPagerItems.Creator creator = FragmentPagerItems.with(this);
        for (int i = 1, tabCount = 5; i < tabCount; i++) {

            creator.add(""+i, Quiz_Fragment.class);
        }
        final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());

        //  viewPager.setAdapter(adapterViewPager);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

        viewPagerTab.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {
                viewPager.setCurrentItem(position+1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Data(position,adapter);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        int  pageNo = getIntent ().getIntExtra ("position",0);

        viewPager.setCurrentItem(pageNo);

    }
    private void Data(int position , FragmentPagerItemAdapter adapter){
    Quiz_Fragment fragment = ((Quiz_Fragment) adapter.getPage(position));



    List<model_Question_class> allItems = new ArrayList<model_Question_class>();
    allItems.add(new model_Question_class("Q1. At what percentage should he mark the Wiper up to get the required percentage profit", "10%", "20%", "15%", "5%", "5%", "5%"));
    allItems.add(new model_Question_class("Q2. The discount given by the shopkeeper on the purchase of the Toothpaste to the customer is Rs.4.40; find at what price did the shopkeeper sold the Toothpaste", "  Rs. 50", "  Rs. 50.60 ", " Rs. 45", " Rs. 48", " Rs. 48", " Rs. 48"));
    allItems.add(new model_Question_class("QUESTION3", "1", "2", "3", "4", "4", "4"));
    allItems.add(new model_Question_class("QUESTION4", "1", "2", "3", "3", "4", "3"));


    fragment.setTextValue(
            String.valueOf(position+1),
            String.valueOf(allItems.get(position).getQuestion()),
            String.valueOf(allItems.get(position).getAns1()),
            String.valueOf(allItems.get(position).getAns2()),
            String.valueOf(allItems.get(position).getAns3()),
            String.valueOf(allItems.get(position).getAns4()),
            String.valueOf(allItems.get(position).getAns5()),
            String.valueOf(allItems.get(position).getRightAns()));


    //     bindViews ();

}
}
*/



































    /*
    private LinearLayout layout;
    private String selectedAns;
    private ArrayList<Question> data;
    private ArrayList<Boolean> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


    }*/



    /*    layout = findViewById(R.id.quiz_activity_container);
        answers = new ArrayList<>();

       // data = sampleData();
       // addQuestions();
    }
*/
  /*  private ArrayList<Question> sampleData() {
        ArrayList<Question> arr = new ArrayList<>();

        arr.add(new Question("Question 1", "option1", "option2", "option3", "option4", "option1"));
        arr.add(new Question("Question 2", "option1", "option2", "option3", "option4", "option2"));
        arr.add(new Question("Question 3", "option1", "option2", "option3", "option4", "option3"));
        arr.add(new Question("Question 4", "option1", "option2", "option3", "option4", "option4"));
        arr.add(new Question("Question 5", "option1", "option2", "option3", "option4", "option1"));
        arr.add(new Question("Question 6", "option1", "option2", "option3", "option4", "option2"));
        arr.add(new Question("Question 7", "option1", "option2", "option3", "option4", "option3"));
        arr.add(new Question("Question 8", "option1", "option2", "option3", "option4", "option4"));


        return arr;
    }
*/

  /*  private void addQuestions() {
        View v;

        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);

        for (int i = 0; i < data.size(); i++) {
            v = createView(data.get(i), (i + 1), data.size());
            v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, screenSize.y));
//            v.setLayoutParams(new LinearLayout.LayoutParams(screenSize.x, ViewGroup.LayoutParams.MATCH_PARENT));
            layout.addView(v);
        }
    }
*/
  /*  private View createView(final Question question, int questionNum, int totalQuestions) {
        View view = LayoutInflater.from(this).inflate(R.layout.question_list_design, null);


        TextView questionNumTv = view.findViewById(R.id.question_list_q_number);
        TextView questionTv = view.findViewById(R.id.question_list_q);
//        final TextView resultTv = view.findViewById(R.id.question_list_result);
        RadioGroup answerGroup = view.findViewById(R.id.question_list_answer_options);
        final RadioButton radio1 = view.findViewById(R.id.question_list_option_1);
        final RadioButton radio2 = view.findViewById(R.id.question_list_option_2);
        final RadioButton radio3 = view.findViewById(R.id.question_list_option_3);
        final RadioButton radio4 = view.findViewById(R.id.question_list_option_4);

        questionNumTv.setText("Question " + questionNum + "/" + totalQuestions);
        questionTv.setText(question.getStatement());
        radio1.setText(question.getOption1());
        radio2.setText(question.getOption2());
        radio3.setText(question.getOption3());
        radio4.setText(question.getOption4());
//        resultTv.setVisibility(View.INVISIBLE);

        answerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.question_list_option_1)
                    selectedAns = radio1.getText().toString();
                else if (checkedId == R.id.question_list_option_2)
                    selectedAns = radio2.getText().toString();
                else if (checkedId == R.id.question_list_option_3)
                    selectedAns = radio3.getText().toString();
                else if (checkedId == R.id.question_list_option_4)
                    selectedAns = radio4.getText().toString();

                if (selectedAns.equals(question.getCorrectAns())) {
//                    resultTv.setBackgroundResource(R.drawable.correct_answer_background);
//                    resultTv.setTextColor(getResources().getColor(R.color.correct_answer));
//                    resultTv.setText(question.getCorrectAns() + ". Your answer is correct");
                    answers.add(true);
                } else {
//                    resultTv.setBackgroundResource(R.drawable.wrong_answer_background);
//                    resultTv.setTextColor(getResources().getColor(R.color.wrong_answer));
//                    resultTv.setText(question.getCorrectAns() + ". Your answer is incorrect");
                    answers.add(false);
                }

//                resultTv.setVisibility(View.VISIBLE);

                if(answers.size() == data.size())
                {
                    Intent resultIntent = new Intent(QuizActivity.this, ResultActivity.class);
                    resultIntent.putExtra("answers", answers);
                    startActivity(resultIntent);
                }
            }
        });


        return view;
    }

 } */
