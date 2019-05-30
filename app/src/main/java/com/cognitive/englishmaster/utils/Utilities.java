package com.cognitive.englishmaster.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

 public class  Utilities
{
    public static boolean isNetworkAvailable(Context ctx)
    {
        ConnectivityManager manager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static String getBaseUrl()
    {
        // todo: replace url with original one
        return "http://movieguro.com/laravel-api/public/api/subcategories/1";
    }


    public static class getData extends AsyncTask<String,Void,String> {

        private Context context;

        private String url1;
        public getData(Context context, JSONObject jsonObj) {
            Toast.makeText(context, "Reached here safely:", Toast.LENGTH_SHORT).show();
            this.context = context;
            String urlString = getBaseUrl() + jsonObj;
            String encodedurl = null;
            try {
                encodedurl = URLEncoder.encode(urlString,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.url1=urlString;
            Log.e("URLFinal",""+urlString);

        }
        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {
            try{
                URL url = new URL(url1);
                URLConnection urlc = url.openConnection();
                HttpURLConnection con = null;
                urlc.setConnectTimeout(20000);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
                String line;
                String x = bfr.readLine();
                while ((line = bfr.readLine()) != null) {
                    x += line;
                }
                return x;
            }
            catch(Exception e){
                return "Exception: " + e.getMessage();
            }

        }
        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                try {
                    Toast.makeText(context, "Response:"+result, Toast.LENGTH_SHORT).show();
/*
                    Log.e("result",""+result);


                    JSONObject json = new JSONObject(result);
                    JSONArray jArray = json.getJSONArray("salons");
                   Log.e("upp","class");
                    Log.e("Size","::"+jArray.length());

                    //new code
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject json_data = jArray.getJSONObject(i);
                        Log.e("hereRR",":"+"comes");

                        try{
                            JSONArray arr = json_data.getJSONArray("techs");
                            for (int j = 0; j < arr.length(); j++) {
                                Log.e("sizeAA",":"+arr.length());


                                JSONObject innerData = arr.getJSONObject(j);
                                // DataObj dataObj = new DataObj(); // Create Object here
                                // dataObj.setShowTitle(innerData.getString("ShowTitle"));
                                // data.setDataObj(dataObj); // setting the dataObj

                                //Add the DataObj to a list in the Row object
                                // data.addDataObject(dataObj);
                            }
                        }catch (Exception e){
                            Log.e("exception",""+e.toString());

                        }*/
                    // }
                    JSONObject jsonObj = new JSONObject(result);
                    String query_result = result;

                    switch (query_result) {
                        case "OK":
                            //Toast.makeText(context, "Data retrieved.", Toast.LENGTH_SHORT).show();
                            break;
                        case "ZERO_RESULTS":
                            // Toast.makeText(context, "Unable to get retrieve data.", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            // Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Toast.makeText(context, "Internet Error!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
            }

        }
    }




}
