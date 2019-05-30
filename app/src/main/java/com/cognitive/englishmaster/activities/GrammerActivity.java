package com.cognitive.englishmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.GrammerListAdaptor;

import java.util.ArrayList;

public class GrammerActivity extends AppCompatActivity {

    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammer);
        Find_All_Views();
    }

    @Override
    protected void onStart() {
        settingRecyclerView();

        super.onStart();
    }

    private void Find_All_Views(){
        list = findViewById(R.id.activity_grammar_recycler_view);
    }

    private void settingRecyclerView()
    {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);

        GrammerListAdaptor adaptor = new GrammerListAdaptor(this, sampleData());
        list.setAdapter(adaptor);
    }

    private ArrayList<String> sampleData()
    {
        ArrayList<String> data = new ArrayList<>();

        data.add("Noun");
        data.add("Pronoun");
        data.add("Adjective");
        data.add("Noun");
        data.add("Pronoun");
        data.add("Adjective");
        data.add("Noun");
        data.add("Pronoun");
        data.add("Adjective");

        return data;
    }
}
