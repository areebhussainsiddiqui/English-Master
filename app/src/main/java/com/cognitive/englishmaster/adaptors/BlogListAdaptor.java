package com.cognitive.englishmaster.adaptors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.DownloadListener;
import com.cognitive.englishmaster.Constant;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.activities.MainActivity;
import com.cognitive.englishmaster.model_classes.Blog;
import com.cognitive.englishmaster.save_image;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class BlogListAdaptor extends RecyclerView.Adapter<BlogListAdaptor.BlogViewHolder> {
    private Context ctx;
    private ArrayList<Blog> data;

    // constructor
    public BlogListAdaptor(Context ctx, ArrayList<Blog> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.blog_list_design, viewGroup, false);

        return new BlogViewHolder(view);
    }
    File file;
    String dirPath, fileName;
    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder blogViewHolder, int i) {
      Blog dat = data.get(i) ;
       // blogViewHolder.setData(data.get(i));
        String imageUrl = (dat.getImage());
        Picasso.with(ctx).load(imageUrl).fit().centerInside().into(blogViewHolder.img);
        AndroidNetworking.initialize(ctx.getApplicationContext());
        dirPath = "/data/data/com.cognitive.englishmaster/code_cache/Image/";

        fileName = "Image_"+i ;
        file = new File(dirPath, fileName);

        Uri uri = Uri.fromFile(new File(dirPath));


        AndroidNetworking.download(imageUrl, dirPath, fileName)
                .build()
                .startDownload(new DownloadListener() {

                    @Override
                    public void onDownloadComplete() {

                        Toast.makeText(ctx, "DownLoad Complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(ctx, "DownLoad Failed"+ anError, Toast.LENGTH_SHORT).show();
                        Log.d("BLACK", "onError: "+anError);
                    }
                });


        blogViewHolder.title.setText(dat.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class BlogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView title;
        int a=0;
        File file;
        String dirPath, fileName;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            img = itemView.findViewById(R.id.blog_list_img);
            title = itemView.findViewById(R.id.blog_list_title);
        }

        public void setData(Blog data) {

       /*     String imageUrl = (data.getImage());
            Picasso.with(ctx).load(imageUrl).fit().centerInside().into(img);
            AndroidNetworking.initialize(ctx.getApplicationContext());
            dirPath = Environment.getExternalStorageDirectory() + "/Image/";
            a=a+1;
            fileName = "Image_"+a ;
            file = new File(dirPath, fileName);

            AndroidNetworking.download(data.getImage(), dirPath, fileName)
                    .build()
                    .startDownload(new DownloadListener() {
                        @Override
                        public void onDownloadComplete() {

                            Toast.makeText(ctx, "DownLoad Complete", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(ANError anError) {
                            Toast.makeText(ctx, "DownLoad Failed"+ anError, Toast.LENGTH_SHORT).show();
                            Log.d("BLACK", "onError: "+anError);
                        }
                    });


            title.setText(data.getTitle());
       */ }

        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show();

        }

    }
}
