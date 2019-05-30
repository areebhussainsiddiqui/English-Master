package com.cognitive.englishmaster.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.adaptors.WritingListAdaptor;
import com.cognitive.englishmaster.model_classes.Question_Model_Class_Api;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WritingActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private Sprite doubleBounce;
    private RecyclerView list;
    private WritingListAdaptor  mAdapter;
    private FloatingActionButton floatbutton;
    private ArrayList<Question_Model_Class_Api> ArrayList;
    private RequestQueue requestQueue;


    private final String appbarTitle = "Writing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        Find_All_Views();


        //      settingRecyclerView();
    }

    @Override
    protected void onStart() {
        SlidrInterface slidr = Slidr.attach(this);
        slidr.unlock();

        FloatAction();
        doubleBounce = new DoubleBounce();
        list.setHasFixedSize (true);
        list.setLayoutManager(new LinearLayoutManager(this));
        ArrayList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        ParseJson();

        super.onStart();
    }

    private void Find_All_Views(){
        progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        progressBar.setIndeterminateDrawable(doubleBounce);
        list = findViewById(R.id.writing_activity_recycler_view);
        floatbutton = findViewById(R.id.float_button);

    }
    private void GoToTop() {
        list.smoothScrollToPosition(0);
    }

    private void ParseJson() {

        String url = "http://movieguro.com/php_apis/api/mcqs_main_category/read.php";
        progressBar.isShown();
        progressBar.setVisibility(View.VISIBLE);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET
                , url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("records");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject record = array.getJSONObject(i);
                                String Test_Name = record.getString("mmc_name");
                                ArrayList.add(new Question_Model_Class_Api(Test_Name));
                            }
                            mAdapter = new WritingListAdaptor(WritingActivity.this, ArrayList);
                            list.setAdapter(mAdapter);
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);


    }

    private void FloatAction(){
        list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && floatbutton.getVisibility() != View.VISIBLE) {
                    floatbutton.show();
                } else if (dy < 0 && floatbutton.getVisibility() == View.VISIBLE) {
                    floatbutton.hide();

                }
            }
        });
    }

    private void Cambridge_Dict(){


        String url = "https://dictionary.cambridge.org/api/v1";
        progressBar.isShown();
        progressBar.setVisibility(View.VISIBLE);
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET
                , url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray array = response.getJSONArray("");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject record = array.getJSONObject(i);
                                String Test_Name = record.getString("mmc_name");
                                ArrayList.add(new Question_Model_Class_Api(Test_Name));
                            }
                            mAdapter = new WritingListAdaptor(WritingActivity.this, ArrayList);
                            list.setAdapter(mAdapter);
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);



    }


    @Override
    public void onClick(View v) {
        if(v == floatbutton){
            GoToTop();
        }
    }


    /*  private void settingRecyclerView() {
          LinearLayoutManager manager = new LinearLayoutManager(this);
          manager.setOrientation(LinearLayoutManager.VERTICAL);
  
          list.setLayoutManager(manager);
  
          WritingListAdaptor adaptor = new WritingListAdaptor(this, sampleData());
          list.setAdapter(adaptor);
      }

    private ArrayList<String> sampleData() {
        ArrayList<String> data = new ArrayList<>();

        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");
        data.add("Sample title");

        return data;
    }*/
}
