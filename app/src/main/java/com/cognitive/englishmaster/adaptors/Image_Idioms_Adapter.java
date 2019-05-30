package com.cognitive.englishmaster.adaptors;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.Image_Idioms_Model;

import java.util.ArrayList;

public class Image_Idioms_Adapter extends RecyclerView.Adapter<Image_Idioms_Adapter.Image_Idioms_VH> {
    private Context ctx;
    private ArrayList<Image_Idioms_Model> data;


    // constructor
    public Image_Idioms_Adapter(Context ctx, ArrayList<Image_Idioms_Model> data) {
        this.ctx = ctx;
        this.data = data;
    }


    @Override
    public Image_Idioms_VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.image_idioms_itemlist, viewGroup, false);

        return new Image_Idioms_VH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final Image_Idioms_VH holder, final int i) {
        Image_Idioms_Model model = data.get(i);
        holder.Idiom_image.setImageResource(model.getImage());
        holder.Idiom_Heading.setText(model.getHeading());
        holder.Idiom_meaning.setText(model.getMeaning());
        holder.Idiom_Sentence.setText(model.getSentence());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Image_Idioms_VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView Idiom_image;
        private TextView Idiom_Heading,Idiom_meaning,Idiom_Sentence;

        public Image_Idioms_VH(View itemView) {
            super(itemView);
            Idiom_Heading = itemView.findViewById(R.id.ImageIdioms_heading);
            Idiom_meaning = itemView.findViewById(R.id.ImageIdioms_meaning);
            Idiom_Sentence = itemView.findViewById(R.id.ImageIdioms_sentence);
            Idiom_image = itemView.findViewById(R.id.ImageIdioms_IV);
        }



        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show();

        }

    }
}

