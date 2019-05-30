package com.cognitive.englishmaster.activities;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.Image_Idioms_Adapter;
import com.cognitive.englishmaster.adaptors.Pair_of_words_Adapter;
import com.cognitive.englishmaster.model_classes.Image_Idioms_Model;
import com.cognitive.englishmaster.model_classes.Pair_of_words_Model;

import java.util.ArrayList;

public class Pair_of_Words_Activity extends AppCompatActivity {

    private RecyclerView RV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_of__words);
        Find_All_Views();
    }
    private void Find_All_Views(){
        RV = findViewById(R.id.P_O_W_RV);
    }

    @Override
    protected void onStart() {
        settingRecyclerView();
        super.onStart();
    }


    @SuppressLint("WrongConstant")
    private void settingRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RV.setLayoutManager(manager);

        Pair_of_words_Adapter adaptor = new Pair_of_words_Adapter(this, sampleData());
        RV.setAdapter(adaptor);
    }
    private ArrayList<Pair_of_words_Model> sampleData() {
        ArrayList<Pair_of_words_Model> data = new ArrayList<>();
        data.add(new Pair_of_words_Model("Calender","a list of days or events of a specified kind"
                ,"timetable, schedule, programme, diary","a list of days or events of a specified kind"
                , R.drawable.turkey));

        data.add(new Pair_of_words_Model("Colandar","a list of days or events of a specified kind"
                ,"timetable, schedule, programme, diary","a list of days or events of a specified kind"
                , R.drawable.spain));

        data.add(new Pair_of_words_Model("Calender","a list of days or events of a specified kind"
                ,"timetable, schedule, programme, diary","a list of days or events of a specified kind"
                , R.drawable.pakistan));

        data.add(new Pair_of_words_Model("Calender","a list of days or events of a specified kind"
                ,"timetable, schedule, programme, diary","a list of days or events of a specified kind"
                , R.drawable.germany));

        data.add(new Pair_of_words_Model("Calender","a list of days or events of a specified kind"
                ,"timetable, schedule, programme, diary","a list of days or events of a specified kind"
                , R.drawable.france));


        return data;
    }
}