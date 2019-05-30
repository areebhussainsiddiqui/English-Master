package com.cognitive.englishmaster.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.AudiosListAdaptor;
import com.cognitive.englishmaster.model_classes.Audio;

import java.util.ArrayList;

public class AudioListActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_list);

        list = findViewById(R.id.audio_list_activity_recycler_view);
    }
    protected void onStart() {
        settingRecyclerView();
        super.onStart();
    }

    private void settingRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);

        AudiosListAdaptor adaptor = new AudiosListAdaptor(this, sampleData());
        list.setAdapter(adaptor);
    }

    private ArrayList<Audio> sampleData()
    {
        ArrayList<Audio> data = new ArrayList<>();

        data.add(new Audio(R.drawable.idea_icon, "Sample title"));
     /*   data.add(new Audio(R.drawable.cherry_icon, "Sample title"));
        data.add(new Audio(R.drawable.cricket_icon, "Sample title"));
        data.add(new Audio(R.drawable.cherry_icon, "Sample title"));
        data.add(new Audio(R.drawable.rabbit_icon, "Sample title"));
     */   return data;
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
}
