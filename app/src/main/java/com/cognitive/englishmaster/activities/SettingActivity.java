package com.cognitive.englishmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.cognitive.englishmaster.R;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    private ListView settingList;
    private List<String> settingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Find_All_Views();
    }

    @Override
    protected void onStart() {
        makingData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, settingData);
        settingList.setAdapter(adapter);

        super.onStart();
    }

    private void Find_All_Views(){
        settingList = findViewById(R.id.setting_list);

    }
    void makingData()
    {
        settingData = new ArrayList<>();
        settingData.add("Account");
        settingData.add("Chat Setting");
        settingData.add("Notification");
        settingData.add("Who can find me");
        settingData.add("Privacy");
        settingData.add("Clear Cache");
    }
}
