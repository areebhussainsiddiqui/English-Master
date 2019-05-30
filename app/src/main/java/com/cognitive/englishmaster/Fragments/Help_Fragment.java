package com.cognitive.englishmaster.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognitive.englishmaster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Help_Fragment extends Fragment {


    public Help_Fragment() {
        // Required empty public constructor
    }

View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       v= inflater.inflate(R.layout.fragment_help_, container, false);

   return v;
    }

}
