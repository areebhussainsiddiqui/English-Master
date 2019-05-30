package com.cognitive.englishmaster.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.BlogListAdaptor;
import com.cognitive.englishmaster.model_classes.Blog;
import com.cognitive.englishmaster.save_image;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity {

    private RecyclerView list;
    private ArrayList<Blog> data;
    private BlogListAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        list = findViewById(R.id.blog_activity_recycler_view);

    }

    protected void onStart() {
        settingAdaptor();
        super.onStart();
    }

    @SuppressLint("WrongConstant")
    private void settingAdaptor()
    {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(manager);
           data = new ArrayList<>();
            ParseJson();
        // adaptor = new BlogListAdaptor(this, sampleData());
    //    list.setAdapter(adaptor);

    }

 /*   private ArrayList<Blog> sampleData() {
        ArrayList<Blog> data = new ArrayList<>();

        data.add(new Blog(R.drawable.ic_launcher_background, "Title"));
        data.add(new Blog(R.drawable.ic_launcher_background, "Title"));
        data.add(new Blog(R.drawable.ic_launcher_background, "Title"));
        data.add(new Blog(R.drawable.ic_launcher_background, "Title"));
        data.add(new Blog(R.drawable.ic_launcher_background, "Title"));
        data.add(new Blog(R.drawable.ic_launcher_background, "Title"));
        data.add(new Blog(R.drawable.ic_launcher_background, "Title"));


        return data;
    }
 */   private void ParseJson() {

        ConnectivityManager connManager = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo (ConnectivityManager.TYPE_WIFI);
        RequestQueue requestQueue = Volley.newRequestQueue (this);

        if (mWifi.isConnected ( )) {
            String url = "https://pixabay.com/api/?key=12388420-fc79d1e1501037428d35a53b7&q=english+learning&image_type=photo";
            JsonObjectRequest request = new JsonObjectRequest (Request.Method.GET, url, null, new Response.Listener <JSONObject> ( ) {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray array = response.getJSONArray ("hits");
                        //.getJSONObject (0).getJSONArray ("subMenu");

                        for (int i = 0; i < array.length ( ); i++) {
                            JSONObject hits = array.getJSONObject (i);
/*                            String Product_Id = hits.getString ("_id");*/
                            String Product_Name = hits.getString ("tags");
                            String Product_Image = hits.getString ("previewURL");
//                            save_image SI = new save_image(Product_Name,Product_Image,"/data/data/com.cognitive.englishmaster/files/Images"))
                            data.add (new Blog (Product_Image,Product_Name));
  /*                          Log.d ("TAG_ID", "onResponse: id " + Product_Id);
  */                      }
                        adaptor = new BlogListAdaptor (BlogActivity.this, data);
                       // Log.d ("TAG", "onResponse: " + ArrayLists);
                        list.setAdapter (adaptor);

                        //                   progressDialog.dismiss ();
                    } catch (JSONException e) {
                        e.printStackTrace ( );
                    }
                }
            }, new Response.ErrorListener ( ) {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace ( );
                }
            });
            requestQueue.add (request);

        }
        }
    }

