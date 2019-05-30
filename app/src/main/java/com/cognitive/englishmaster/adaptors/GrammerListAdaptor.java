package com.cognitive.englishmaster.adaptors;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.cognitive.englishmaster.R;

import java.util.ArrayList;

public class GrammerListAdaptor extends RecyclerView.Adapter<GrammerListAdaptor.GrammerViewHolder>
{
    private Context ctx;
    private ArrayList<String> data;

    // constructor
    public GrammerListAdaptor(Context ctx, ArrayList<String> data)
    {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public GrammerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.grammer_list_design, viewGroup, false);

        return new GrammerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrammerViewHolder grammerViewHolder, int i) {
        grammerViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class GrammerViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        private TextView title, subTitle;

        public GrammerViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.grammar_list_title);
            subTitle = itemView.findViewById(R.id.grammar_list_subtitle);
        }

        public void setData(String data)
        {
            title.setText(data);
            subTitle.setText("Read " + data + " and\nDo exercise.");
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
