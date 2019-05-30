package com.cognitive.englishmaster.adaptors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.activities.VocabularyDetailActivity;
import com.cognitive.englishmaster.model_classes.VocabularyDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class DailyWords_Adapter extends RecyclerView.Adapter<DailyWords_Adapter.WordViewHolder>
{
    private Context ctx;
    private ArrayList<VocabularyDetail> data;
    private VocabularyDetail set;

    // constructor
    public DailyWords_Adapter(Context ctx, ArrayList<VocabularyDetail> data)
    {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.card_horizon, viewGroup, false);

        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder viewHolder, final int i) {
        Random rnd = new Random();
        int[] androidColors = ctx.getResources().getIntArray(R.array.androidcolors);
        //for(int a  =0;a > androidColors.length;a++ ){
        viewHolder.view.setBackgroundColor(androidColors[i]);
        //       }
/*
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        viewHolder.cardView.setCardBackgroundColor(randomAndroidColor);
*/

        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePopup(i);
            }
        });
        viewHolder.setData(data.get(i), (i+1));
        int a = i+1;
        viewHolder.itemNumber.setText("Section"+a);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title , itemNumber;
        private ImageView icon;
        private View view;
        private CardView cardView;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.words_card);
            itemNumber = itemView.findViewById(R.id.words_section_No);
            view = itemView.findViewById(R.id.words_view);
            icon = itemView.findViewById(R.id.words_icon);
            title = itemView.findViewById(R.id.words_title_tv);
        }
        public void setData(VocabularyDetail data, int itemNum)
        {
            title.setText(data.getTitle());
            icon.setImageResource(data.getIcon());
        }
    }
    private void ImagePopup(int i){
        set = data.get(i);
        final ImagePopup imagePopup = new ImagePopup(ctx);
        imagePopup.initiatePopupWithPicasso(Uri.parse("android.resource://" + "com.cognitive.englishmaster" + "/" + set.getIcon()));
        imagePopup.setFullScreen(true);
        //imagePopup.setWindowHeight(400); // Optional
        //imagePopup.setWindowWidth(400); // Optional
        imagePopup.setBackgroundColor(Color.BLACK);
        imagePopup.isHideCloseIcon();
        imagePopup.viewPopup();
    }

}
