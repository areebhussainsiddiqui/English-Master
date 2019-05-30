package com.cognitive.englishmaster.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognitive.englishmaster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Idea_Fragment extends Fragment {


    public Idea_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 View v =inflater.inflate(R.layout.fragment_idea_, container, false);

        // Inflate the layout for this fragment
        return v; }

}
