package com.cognitive.englishmaster.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class ApiReader
{
   /* public static class ReadApi extends AsyncTask<String, Void, String>
    {
        private final String REQUEST_METHOD = "GET";
        private final int CONNECTION_TIMEOUT = 15000;
        private final int READ_TIMEOUT = 15000;

        @Override
        protected String doInBackground(String... params) {

            String output = "";
            try {
                URL url = new URL(params[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();

                InputStreamReader stream = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(stream);

                String line = null;

                while ((line = reader.readLine()) != null)
                    output += line;

                stream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            return output;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("rough", s.toString());
        }
    }
*/}
