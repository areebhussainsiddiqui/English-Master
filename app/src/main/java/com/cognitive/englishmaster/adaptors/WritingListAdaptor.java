package com.cognitive.englishmaster.adaptors;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.Question_Model_Class_Api;

import java.util.ArrayList;

public class WritingListAdaptor extends RecyclerView.Adapter<WritingListAdaptor.WritingViewHolder>
{
    private Context mContext;
    private ArrayList<Question_Model_Class_Api> arrayList;

    public WritingListAdaptor(Context context,ArrayList<Question_Model_Class_Api> Arraylist)
    {
        mContext = context;
        arrayList =Arraylist;
    }

    @NonNull
    @Override
    public WritingViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(mContext).inflate(R.layout.writing_list_design, viewGroup,false);
    return new WritingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(WritingViewHolder holder, int position)
    {
        Question_Model_Class_Api currentItem = arrayList.get(position);
        String itemName = currentItem.getTest();
        holder.TestName.setText(itemName);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class WritingViewHolder extends  RecyclerView.ViewHolder
    {public TextView TestName;

        public WritingViewHolder(@NonNull View itemView) {
            super(itemView);
        TestName = itemView.findViewById(R.id.item_title_tv);
        }
    }
 /*   private Context ctx;
    private ArrayList<String> data;

    // constructor
    public WritingListAdaptor(Context ctx, ArrayList<String> data)
    {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public WritingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.writing_list_design, viewGroup, false);

        return new WritingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WritingViewHolder writingViewHolder, int i) {
        writingViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class WritingViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        private TextView title;

        public WritingViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.item_title_tv);
        }

        public void setData(String data)
        {
            title.setText(data);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show();
        }
    }
*/}
