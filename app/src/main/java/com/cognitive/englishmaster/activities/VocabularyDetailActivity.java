package com.cognitive.englishmaster.activities;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.VocabularyDetailAdaptor;
import com.cognitive.englishmaster.model_classes.VocabularyDetail;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;

public class VocabularyDetailActivity extends AppCompatActivity {

    private RecyclerView list;
SlidrInterface slidr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_detail);
        Find_All_Views();
    }

    @Override
    protected void onStart() {
        slidr = Slidr.attach(this);
        slidr.unlock();
        getSupportActionBar().setTitle(getIntent().getStringExtra("appbar_title"));
        settingRecyclerView();

        super.onStart();
    }

    private void Find_All_Views(){
        list = findViewById(R.id.vocabulary_detail_activity_recycler_view);

    }

    @SuppressLint("WrongConstant")
    private void settingRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);

        VocabularyDetailAdaptor adaptor = new VocabularyDetailAdaptor(this, sampleData());
        list.setAdapter(adaptor);
    }

    private ArrayList<VocabularyDetail> sampleData()
    {
        ArrayList<VocabularyDetail> data = new ArrayList<>();

        data.add(new VocabularyDetail(R.drawable.cycling_icon, "Title", "rough definition", "rough example"));

        data.add(new VocabularyDetail(R.drawable.frisbee_icon, "Title", "rough definition", "rough example"));
        data.add(new VocabularyDetail(R.drawable.badminton_icon, "Title", "rough definition", "rough example"));
        data.add(new VocabularyDetail(R.drawable.cricket_icon, "Title", "rough definition", "rough example"));
        data.add(new VocabularyDetail(R.drawable.arm, "Title", "rough definition", "rough example"));
        data.add(new VocabularyDetail(R.drawable.fruit, "Title", "rough definition", "rough example"));
        data.add(new VocabularyDetail(R.drawable.frisbee_icon, "Title", "rough definition", "rough example"));
        data.add(new VocabularyDetail(R.drawable.cricket_icon, "Title", "rough definition", "rough example"));
        data.add(new VocabularyDetail(R.drawable.cherry_icon, "Title", "rough definition", "rough example"));

        return data;
    }
}
