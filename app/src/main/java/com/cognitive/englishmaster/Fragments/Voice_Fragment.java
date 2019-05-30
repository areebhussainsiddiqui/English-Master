package com.cognitive.englishmaster.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.AudiosListAdaptor;
import com.cognitive.englishmaster.model_classes.Audio;
import com.cognitive.englishmaster.model_classes.VocabularyDetail;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Voice_Fragment extends Fragment {
    private RecyclerView list;
View v;

    public Voice_Fragment() {

        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_voice, container, false);
        list = (RecyclerView) v.findViewById(R.id.audio_list_activity_recycler_view);
        settingRecyclerView();


        return v;
    }
    private void settingRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);

        AudiosListAdaptor adaptor = new AudiosListAdaptor(getActivity(), sampleData());
        list.setAdapter(adaptor);
    }

    private ArrayList<Audio> sampleData()
    {
        ArrayList<Audio> data = new ArrayList<>();


       /* data.add(new Audio(R.drawable.clock, "Time"));
        data.add(new Audio(R.drawable.injection, "Sickness / Illness"));
        data.add(new Audio(R.drawable.plant, "Plant"));
        data.add(new Audio(R.drawable.arm, "Body Parts"));
        data.add(new Audio(R.drawable.fruit, "Food"));
       */ data.add(new Audio(R.drawable.cherry_icon, "Cherry"));
        data.add(new Audio(R.drawable.cricket_icon, "Bat and Ball"));
        data.add(new Audio(R.drawable.cherry_icon, "Cherry"));
        data.add(new Audio(R.drawable.rabbit_icon, "Rabbit"));

        return data;
    }

}
