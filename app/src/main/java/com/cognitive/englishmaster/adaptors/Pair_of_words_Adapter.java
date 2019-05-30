package com.cognitive.englishmaster.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.Pair_of_words_Model;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class Pair_of_words_Adapter extends RecyclerView.Adapter<Pair_of_words_Adapter.POW_VH> {
    private Context ctx;
    private ArrayList<Pair_of_words_Model> data;


    // constructor
    public Pair_of_words_Adapter(Context ctx, ArrayList<Pair_of_words_Model> data) {
        this.ctx = ctx;
        this.data = data;
    }


    @Override
    public POW_VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.pair_of_word_itemlist, viewGroup, false);

        return new POW_VH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final POW_VH holder, final int i) {
        Pair_of_words_Model model = data.get(i);
        holder.Circular_IV.setImageResource(model.getImage());
        holder.POW_Heading.setText(model.getHeading());
        holder.POW_meaning.setText(model.getMeaning());
        holder.POW_Synonyoms.setText(model.getSynonyoms());
        holder.POW_Defination.setText(model.getDefination());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class POW_VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CircleImageView Circular_IV;
        private TextView POW_Heading, POW_meaning, POW_Synonyoms,POW_Defination;

        public POW_VH(View itemView) {
            super(itemView);

            POW_Heading = itemView.findViewById(R.id.POW_heading);
            POW_meaning = itemView.findViewById(R.id.POW_meaning);
            POW_Synonyoms = itemView.findViewById(R.id.POW_synonyms);
            POW_Defination = itemView.findViewById(R.id.POW_defination);
            Circular_IV = itemView.findViewById(R.id.POW_IV);
        }



        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show();

        }

    }
}

