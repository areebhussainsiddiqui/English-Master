package com.cognitive.englishmaster.adaptors;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Window;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cognitive.englishmaster.activities.AudioDetailActivity;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.Audio;

import java.util.ArrayList;
import java.util.Locale;

public class AudiosListAdaptor extends RecyclerView.Adapter<AudiosListAdaptor.AudioViewHolder>
{
    private Context ctx;
    private ArrayList<Audio> data;

    // constructor
    public AudiosListAdaptor(Context ctx, ArrayList<Audio> data)
    {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.audio_list_design, viewGroup, false);

        return new AudioViewHolder(view);
    }
    TextToSpeech toSpeech;
    String text;
    int result;
    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder audioViewHolder, final int i) {

        audioViewHolder.setData(data.get(i));

        SharedPreferences pref = ctx.getSharedPreferences("Seekbar", Context.MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
         final float Pitch = pref.getFloat("Seek", (float) 1.5); // getting Float
        Log.d("BLACK", "onBindViewHolder: "+Pitch);
        toSpeech=new TextToSpeech(ctx, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    result=toSpeech.setLanguage(Locale.UK);
                }
                else
                {
                    Toast.makeText(ctx,"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });
        audioViewHolder.listenIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(ctx,"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    text = data.get(i).getTitle();
                    Log.d("BLACK", "onClick: "+text);

                    //toSpeech.setPitch();
                    toSpeech.setSpeechRate(showDialog(ctx));

                    toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
               //     toSpeech.stop();
                }


            }
        });
        audioViewHolder.listenIcon.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDialog(ctx);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class AudioViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        private TextView titleTv;
        private ImageView audioIcon, listenIcon;

        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            titleTv = itemView.findViewById(R.id.audio_list_title);
            audioIcon = itemView.findViewById(R.id.audio_list_icon);
            listenIcon = itemView.findViewById(R.id.audio_list_listen_icon);
        }

        public void setData(Audio data)
        {
            titleTv.setText(data.getTitle());
            audioIcon.setImageResource(data.getIcon());
        }

        @Override
        public void onClick(View v) {
       //     ctx.startActivity(new Intent(ctx, AudioDetailActivity.class));
        }
    }
    float Prog;
    public float showDialog(final Context context){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.spinner_pop);

        final SeekBar seekBar = (SeekBar) dialog.findViewById(R.id.seekbar);
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
  //        if(progress == 0){
//              Prog = Float.valueOf(1);

    //      }
      //    else {
              Prog = (float) seekRate(progress,ctx);
         //  }
            Log.d("BLACK", "onProgressChanged: "+progress);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    });
        Button dialogButton = (Button) dialog.findViewById(R.id.set_speed_Btn);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
return Prog;
    }
   private float seekRate(int progress,Context context){
        SharedPreferences pref = context.getSharedPreferences("Seekbar", Context.MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        float Rate = 0;
        switch (progress){
            case 0:
            editor.putFloat("Seek", (float) 0.2); // Storing integer
            Rate = (float) 0.2;
            editor.commit(); // commit changes
            break;

            case 1:
            editor.putFloat("Seek", (float) 0.4); // Storing integer
            Rate = (float) 0.4;
            editor.commit(); // commit changes
            break;

            case 2:
            editor.putFloat("Seek", (float) 0.6); // Storing integer
            Rate = (float) 0.6;
            editor.commit(); // commit changes
            break;

            case 3:
            editor.putFloat("Seek", (float) 0.8); // Storing integer
            Rate = (float) 0.8;
            editor.commit(); // commit changes
            break;

            case  4:
            editor.putFloat("Seek", (float) 1.0); // Storing integer
            Rate = (float) 1.0;
            editor.commit(); // commit changes
            break;

            case 5:
            editor.putFloat("Seek", (float) 1.2); // Storing integer
            Rate = (float) 1.2;
            editor.commit(); // commit changes

            case 6:
            editor.putFloat("Seek", (float) 1.5); // Storing integer
            Rate = (float) 1.5;
            editor.commit(); // commit changes
            break;

            case 7:
            editor.putFloat("Seek", (float) 2.0); // Storing integer
            Rate = (float) 0.8;
            editor.commit(); // commit changes
            break;

            case 8:
            editor.putFloat("Seek", (float) 3.0); // Storing integer
            Rate = (float) 3.0;
            editor.commit(); // commit changes
            break;

            default :
                editor.putFloat("Seek", (float) 4.0); // Storing integer
                Rate = (float) 4.0;
                editor.commit(); // commit changes
                break;
        }

       return Rate;
    }
}
