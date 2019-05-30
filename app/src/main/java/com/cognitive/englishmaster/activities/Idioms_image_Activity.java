package com.cognitive.englishmaster.activities;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.Image_Idioms_Adapter;
import com.cognitive.englishmaster.model_classes.Image_Idioms_Model;

import java.util.ArrayList;

public class Idioms_image_Activity extends AppCompatActivity {

    private RecyclerView RV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioms_image);
        Find_All_Views();
    }
    private void Find_All_Views(){
        RV = findViewById(R.id.Idioms_Image_RV);
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

        Image_Idioms_Adapter adaptor = new Image_Idioms_Adapter(this, sampleData());
        RV.setAdapter(adaptor);
    }
        private ArrayList<Image_Idioms_Model> sampleData() {
        ArrayList<Image_Idioms_Model> data = new ArrayList<>();
        data.add(new Image_Idioms_Model("Go through the roof","to become very angry or upset"
                ,"Sales of their new CD have gone through the roof.", R.drawable.turkey));

        data.add(new Image_Idioms_Model("Go through the roof","to become very angry or upset"
                ,"Sales of their new CD have gone through the roof.", R.drawable.spain));

        data.add(new Image_Idioms_Model("Go through the roof","to become very angry or upset"
                ,"Sales of their new CD have gone through the roof.", R.drawable.pakistan));

        data.add(new Image_Idioms_Model("Go through the roof","to become very angry or upset"
                ,"Sales of their new CD have gone through the roof.", R.drawable.germany));

        data.add(new Image_Idioms_Model("Go through the roof","to become very angry or upset"
                ,"Sales of their new CD have gone through the roof.", R.drawable.france));


        return data;
        }
}
