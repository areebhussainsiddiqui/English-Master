package com.cognitive.englishmaster.adaptors;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.AudioDetail;

import java.util.ArrayList;

public class AudioDetailAdaptor extends RecyclerView.Adapter<AudioDetailAdaptor.AudioDetailViewHolder>
{
    private Context ctx;
    private ArrayList<AudioDetail> data;

    public AudioDetailAdaptor(Context ctx, ArrayList<AudioDetail> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public AudioDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.audio_detail_list_design, viewGroup, false);
        return new AudioDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioDetailViewHolder audioDetailViewHolder, int i) {
        audioDetailViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class AudioDetailViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title, statement1, statement2, statement3;

        public AudioDetailViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.audio_detail_title);
            statement1 = itemView.findViewById(R.id.audio_detail_st1);
            statement2 = itemView.findViewById(R.id.audio_detail_st2);
            statement3 = itemView.findViewById(R.id.audio_detail_st3);
        }

        public void setData(AudioDetail data)
        {
            title.setText(data.getTitle());
            statement1.setText(data.getStatement1());
            statement2.setText(data.getStatement2());
            statement3.setText(data.getStatement3());
        }
    }
}
