package com.cognitive.englishmaster.adaptors;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.DownloadListener;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.Blog;
import com.cognitive.englishmaster.model_classes.language_model;
import com.squareup.picasso.Picasso;
import org.intellij.lang.annotations.Language;

import java.io.File;
import java.util.ArrayList;

public class Select_Language_Adapter  extends RecyclerView.Adapter<Select_Language_Adapter.Select_Lang_ViewHolder> {
    private Context ctx;
    private ArrayList<language_model> data;


    // constructor
    public Select_Language_Adapter(Context ctx, ArrayList<language_model> data) {
        this.ctx = ctx;
        this.data = data;
    }


    @Override
    public Select_Lang_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_list_select_lang, viewGroup, false);

        return new Select_Lang_ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final Select_Lang_ViewHolder holder, final int i) {
        language_model model = data.get(i);
        holder.FlagIV.setImageResource(model.getCountry_Flag());
        holder.Country_TextV.setText(model.getCountry_name());

        holder.Cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.Cb.isChecked();

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Select_Lang_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView FlagIV;
        private TextView Country_TextV;
        private CheckBox Cb;

        public Select_Lang_ViewHolder(@NonNull View itemView) {
            super(itemView);
        FlagIV =itemView.findViewById(R.id.Sel_Lang_FLAG_IV);
        Country_TextV = itemView.findViewById(R.id.Sel_Lang_Country_TxtV);
        Cb = itemView.findViewById(R.id.Sel_Lang_Country_CheckBox);
        }



        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show();

        }

    }
}
