package com.cognitive.englishmaster.activities;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.VocabularyListAdaptor;
import com.cognitive.englishmaster.model_classes.Blog;
import com.cognitive.englishmaster.model_classes.Vocabulary;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;

public class VocabularyActivity extends AppCompatActivity {

    private RecyclerView list;
SlidrInterface slidr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        list = findViewById(R.id.vocabulary_activity_recycler_view);
    }

    @Override
    protected void onStart() {
        slidr = Slidr.attach(this);
        slidr.unlock();
        settingRecyclerView();

        super.onStart();
    }

    @SuppressLint("WrongConstant")
    private void settingRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);

        VocabularyListAdaptor adaptor = new VocabularyListAdaptor(this, sampleData());
        list.setAdapter(adaptor);
    }

    private ArrayList<Vocabulary> sampleData()
    {
        ArrayList<Vocabulary> data = new ArrayList<>();

        data.add(new Vocabulary(R.drawable.rabbit_icon, "Animals", 20));
        data.add(new Vocabulary(R.drawable.plant, "Plants", 20));
        data.add(new Vocabulary(R.drawable.basketball_icon, "Sports", 20));
        data.add(new Vocabulary(R.drawable.bureau_icon, "Furniture", 20));
        data.add(new Vocabulary(R.drawable.frisbee_icon, "Frisbee", 20));
        data.add(new Vocabulary(R.drawable.rabbit_icon, "Animals", 20));
        data.add(new Vocabulary(R.drawable.badminton_icon, "Animals", 20));
        data.add(new Vocabulary(R.drawable.basketball_icon, "Animals", 20));
        data.add(new Vocabulary(R.drawable.bureau_icon, "Animals", 20));
        data.add(new Vocabulary(R.drawable.frisbee_icon, "Animals", 20));
        data.add(new Vocabulary(R.drawable.rabbit_icon, "Animals", 20));

        return data;
    }
}
