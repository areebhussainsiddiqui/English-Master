package com.cognitive.englishmaster;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.ImageView;
import com.squareup.picasso.Callback;

import java.io.File;
import java.io.FileOutputStream;

import static com.android.volley.VolleyLog.TAG;

public class save_image implements Callback {
    public static final String MEDIA_DIRECTORY = "/EnglishMaster/Media/";
    public static final String MEDIA_EXTENSION = ".jpeg";

    private String mDirectory;
    private String mFileName;
    private ImageView mContainer;

    public save_image(String fileName, ImageView container, String directory) {
        this.mFileName = fileName;
        this.mContainer = container;
        this.mDirectory = directory;
        this.getStorageDir();
    }

    @Override
    public void onSuccess() {
/*
        if (this.isExternalStorageWritable()) {
            final Bitmap bitmap = ((BitmapDrawable) this.mContainer.getDrawable()).getBitmap();
            new AsyncTask<Void, Void, File>() {
                @Override
                protected File doInBackground(Void... params) {
                    File file = null;
                    try {
                        //MEDIA_EXTENSION
                        file = new File(save_image.this.getStorageDir().getPath().concat("/").concat(save_image.this.mFileName.concat(save_image.this.mFileName.concat(MEDIA_EXTENSION))));
                        file.createNewFile();
                        FileOutputStream ostream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                        ostream.close();
                    } catch (Exception e) {
                        Log.e(TAG, "External Storage is not available");
                    }
                    return file;
                }
            }.execute();
        } else {
            Log.e(TAG, "External Storage is not available");
        }
*/
    }

    @Override
    public void onError() {

    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public File getStorageDir() {
        //SyncStateContract.Constants.MEDIA_DIRECTORY
        File file = new File(Environment.getExternalStorageDirectory(), MEDIA_DIRECTORY.concat(this.mDirectory));
        if (!file.mkdirs()) {
            file.mkdirs();

        }
        return file;
    }
}