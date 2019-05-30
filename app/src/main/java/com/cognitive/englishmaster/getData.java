package com.cognitive.englishmaster;

import android.content.Context;
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

public class getData extends AsyncTask<String,Void,String> {

    private Context context;
    private String url1;
    String lattitude, longitude;
    public getData(Context context,  JSONObject jsonObj) {

            /*this.context = context;
            String urlString = Utilities.getBaseURL() + jsonObj;
            String encodedurl = null;
            try {
                encodedurl = URLEncoder.encode(urlString,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            this.url1=urlString;
            Log.e("URLFinal",""+urlString);*/
        this.context = context;
        Log.i("Method","- Start");
        String urlString = "http://movieguro.com/php_apis/api/product/read.php";
        //Utilities.getBaseURL(context) + jsonObj;
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
        // Log.e("showing","progress");



    }

    @Override
    protected String doInBackground(String... params) {
        try{
            //  String link = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + lattitude + "," + longitude + "&sensor=true";
            //pDialog.show();

            //  Log.e("getting","data");
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