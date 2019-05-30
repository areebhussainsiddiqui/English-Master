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

public class VocabularyDetailAdaptor extends RecyclerView.Adapter<VocabularyDetailAdaptor.VocabularyDetailViewHolder>
{
    private Context ctx;
    private ArrayList<VocabularyDetail> data;
    private VocabularyDetail set;

    // constructor
    public VocabularyDetailAdaptor(Context ctx, ArrayList<VocabularyDetail> data)
    {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public VocabularyDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.vocabulary_detail_list_design, viewGroup, false);

        return new VocabularyDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocabularyDetailViewHolder viewHolder, final int i) {
        Random rnd = new Random();
        int[] androidColors = ctx.getResources().getIntArray(R.array.androidcolors);
        //for(int a  =0;a > androidColors.length;a++ ){
            viewHolder.cardView.setCardBackgroundColor(androidColors[i]);
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

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VocabularyDetailViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title, definition, example, itemNumber;
        private ImageView expandIcon, icon;
        private LinearLayout details;
        private CardView cardView;
        public VocabularyDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            itemNumber = itemView.findViewById(R.id.item_num);
            details = itemView.findViewById(R.id.details_layout);
            icon = itemView.findViewById(R.id.detail_icon);
            expandIcon = itemView.findViewById(R.id.expand_details_icon);
            title = itemView.findViewById(R.id.detail_title_tv);
            definition = itemView.findViewById(R.id.definition_tv);
            example = itemView.findViewById(R.id.example_tv);
            icon.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         //cImage=  getIntent().getStringExtra ("ProductImage");
        //ImageView imageView = mview.findViewById(R.id.alertImage);
       // Picasso.with (this).load (cImage).fit ().centerInside ().into (imageView);

    }
});
            expandDetails(itemView);
        }

        private void expandDetails(View view)
        {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(details.getVisibility() == View.GONE)
                    {
                        details.setVisibility(View.VISIBLE);
                        expandIcon.setImageResource(R.drawable.unexpand_icon);
                    }
                    else
                    {
                        details.setVisibility(View.GONE);
                        expandIcon.setImageResource(R.drawable.expand_icon);
                    }
                }
            });
        }

        public void setData(VocabularyDetail data, int itemNum)
        {
            title.setText(data.getTitle());
            icon.setImageResource(data.getIcon());


            definition.setText(data.getDefinition());
            example.setText(data.getExample());
         //   itemNumber.setText(itemNum+".");
            itemNumber.setText(itemNum+".");

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
