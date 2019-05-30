package com.cognitive.englishmaster.Fragments;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognitive.englishmaster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdiomsFragment extends Fragment {
    private TextView Idiom_Heading_TV,Idiom_Sentence_V,Idiom_Translation_TV;
    private View v;
    private LinearLayout color_layout;
    public IdiomsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=  inflater.inflate(R.layout.fragment_idioms, container, false);;
        Find_All_Views();

        // Inflate the layout for this fragment
        return v;
    }

    private void Find_All_Views(){
        Idiom_Heading_TV     = v.findViewById(R.id.Idioms_heading_TV);
        Idiom_Sentence_V     = v.findViewById(R.id.Idioms_Sentenc_TV);
        Idiom_Translation_TV = v.findViewById(R.id.Idioms_Translation_TV);
        color_layout = v.findViewById(R.id.Idiom_ColorLayout);
    }

    public void setTextValue(String  heading, String Sentences,  String Translation, int Color)
    {
        if(getView()==null)
            return;
        Find_All_Views();
        Idiom_Heading_TV.setText(heading);
        Idiom_Sentence_V.setText(Sentences);
        Idiom_Translation_TV.setText(Translation);
        color_layout.setBackgroundColor(Color);
    }
}
