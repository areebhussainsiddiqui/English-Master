package com.cognitive.englishmaster.activities;

import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.AudioDetailAdaptor;
import com.cognitive.englishmaster.adaptors.Select_Language_Adapter;
import com.cognitive.englishmaster.model_classes.AudioDetail;
import com.cognitive.englishmaster.model_classes.language_model;

import java.util.ArrayList;

public class Select_Language extends AppCompatActivity {
    private CheckBox Cb1,Cb2,Cb3,Cb4,Cb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__language);
        Find_All_Views();
    }

    private void Find_All_Views() {
        Cb1 = findViewById(R.id.Sel_Lang_Country_CheckBox1);
        Cb2 = findViewById(R.id.Sel_Lang_Country_CheckBox2);
        Cb3 = findViewById(R.id.Sel_Lang_Country_CheckBox3);
        Cb4 = findViewById(R.id.Sel_Lang_Country_CheckBox4);
        Cb5 = findViewById(R.id.Sel_Lang_Country_CheckBox5);
    }


    @Override
    protected void onStart() {
  /*      settingRecyclerView();
  */      super.onStart();
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.Sel_Lang_Country_CheckBox1:
                Cb1.setChecked(checked);
                Cb2.setChecked(false);
                Cb3.setChecked(false);
                Cb4.setChecked(false);
                Cb5.setChecked(false);

                break;
            case R.id.Sel_Lang_Country_CheckBox2:
                Cb1.setChecked(false);
                Cb2.setChecked(checked);
                Cb3.setChecked(false);
                Cb4.setChecked(false);
                Cb5.setChecked(false);

                break;
                case R.id.Sel_Lang_Country_CheckBox3:
                Cb1.setChecked(false);
                Cb2.setChecked(false);
                Cb3.setChecked(checked);
                Cb4.setChecked(false);
                Cb5.setChecked(false);

                break;
            case R.id.Sel_Lang_Country_CheckBox4:
                Cb1.setChecked(false);
                Cb2.setChecked(false);
                Cb3.setChecked(false);
                Cb4.setChecked(checked);
                Cb5.setChecked(false);

                break;
            case R.id.Sel_Lang_Country_CheckBox5:
                Cb1.setChecked(false);
                Cb2.setChecked(false);
                Cb3.setChecked(false);
                Cb4.setChecked(false);
                Cb5.setChecked(checked);

                break;
            // TODO: Veggie sandwich
        }
    }

    /*private void settingRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RV.setLayoutManager(manager);

        Select_Language_Adapter adaptor = new Select_Language_Adapter(this, sampleData(),);
        RV.setAdapter(adaptor);
    }
*/
    /*private ArrayList<language_model> sampleData() {
        ArrayList<language_model> data = new ArrayList<>();
        data.add(new language_model("Turkish", R.drawable.turkey));
        data.add(new language_model("Spanish", R.drawable.spain));
        data.add(new language_model("Pakistan", R.drawable.pakistan));
        data.add(new language_model("German", R.drawable.germany));
        data.add(new language_model("French", R.drawable.france));


        return data;
        }*/
        }