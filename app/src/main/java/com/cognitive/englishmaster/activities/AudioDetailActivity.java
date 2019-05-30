package com.cognitive.englishmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.AudioDetailAdaptor;
import com.cognitive.englishmaster.model_classes.AudioDetail;
import com.cognitive.englishmaster.utils.Utilities;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;

public class AudioDetailActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_detail);

        list = findViewById(R.id.audio_detail_activity_recycler_view);
        try {
            netWorkCall();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //  settingRecyclerView();

    }

    @Override
    protected void onStart() {
        settingRecyclerView();
        super.onStart();
    }

    private JSONObject getInputList() {
        Hashtable serviceData = new Hashtable();
        serviceData.put("service", "get_tech_slots");// encodeBytes("login".getBytes()));
        serviceData.put("tech_id", "id");
// Log.e("techId111",techId);
        JSONObject jsonObj = new JSONObject(serviceData);
        return jsonObj;
    }

    public void netWorkCall() throws ExecutionException, InterruptedException {
        String output= new Utilities.getData(AudioDetailActivity.this,getInputList()).execute("").get();

    }



    private void settingRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);

        AudioDetailAdaptor adaptor = new AudioDetailAdaptor(this, sampleData());
        list.setAdapter(adaptor);
    }

    private ArrayList<AudioDetail> sampleData()
    {
        ArrayList<AudioDetail> data = new ArrayList<>();

        data.add(new AudioDetail("Sample title", "statement 1", "statement 2", "statement 3"));
        data.add(new AudioDetail("Sample title", "statement 1", "statement 2", "statement 3"));
        data.add(new AudioDetail("Sample title", "statement 1", "statement 2", "statement 3"));
        data.add(new AudioDetail("Sample title", "statement 1", "statement 2", "statement 3"));
        data.add(new AudioDetail("Sample title", "statement 1", "statement 2", "statement 3"));


        return data;
    }







}
