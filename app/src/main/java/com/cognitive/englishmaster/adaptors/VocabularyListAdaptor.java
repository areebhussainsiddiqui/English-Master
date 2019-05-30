package com.cognitive.englishmaster.adaptors;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.activities.DailyWord;
import com.cognitive.englishmaster.activities.VocabularyDetailActivity;
import com.cognitive.englishmaster.model_classes.Vocabulary;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VocabularyListAdaptor extends RecyclerView.Adapter<VocabularyListAdaptor.VocabularyViewHolder> {
    private Context ctx;
    private ArrayList<Vocabulary> data;
    Vocabulary set = null;

    // constructor
    public VocabularyListAdaptor(Context ctx, ArrayList<Vocabulary> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public VocabularyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(ctx).inflate(R.layout.vocabulary_list_design, viewGroup, false);
        return new VocabularyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocabularyViewHolder vocabularyViewHolder, final int i) {

        vocabularyViewHolder.setData(data.get(i));

        vocabularyViewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ImagePopup(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VocabularyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, numOfWords;
        private ImageView icon;
        public VocabularyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.vocabulary_title);
            numOfWords = itemView.findViewById(R.id.vocabulary_num_of_words);
            icon = itemView.findViewById(R.id.vocabulary_icon);
        }

        public void setData(Vocabulary data) {

            icon.setImageResource(data.getIcon());
            title.setText(data.getTitle());
            numOfWords.setText("Words: " + data.getNumOfWords());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ctx, DailyWord.class);

           // Intent intent = new Intent(ctx, VocabularyDetailActivity.class);
            intent.putExtra("appbar_title", title.getText().toString());
            ctx.startActivity(intent);

        }


    }
private void ImagePopup(int i){
    set = data.get(i);
    final ImagePopup imagePopup = new ImagePopup(ctx);
    imagePopup.initiatePopupWithPicasso(Uri.parse("android.resource://" + "com.cognitive.englishmaster" + "/" + set.getIcon()));
   imagePopup.setFullScreen(true);
    // imagePopup.setWindowHeight(400); // Optional
    // imagePopup.setWindowWidth(400); // Optional
   // imagePopup.setBackgroundColor(Color.TRANSPARENT);
    imagePopup.isHideCloseIcon();
    imagePopup.viewPopup();
    }
}

