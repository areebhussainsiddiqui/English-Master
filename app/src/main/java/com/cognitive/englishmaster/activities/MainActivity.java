package com.cognitive.englishmaster.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.cognitive.englishmaster.Fragments.Help_Fragment;
import com.cognitive.englishmaster.Fragments.Home_Fragments;
import com.cognitive.englishmaster.Fragments.Idea_Fragment;
import com.cognitive.englishmaster.Fragments.Voice_Fragment;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.VocabularyDetail;
import com.cognitive.englishmaster.utils.Database;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*
        try {
            new ApiReader.ReadApi().execute(Utilities.getBaseUrl()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       */

        centeringAppbarTitle();

        Database db = new Database(this);
        db.insert(new VocabularyDetail(R.drawable.idea_icon, "Title 1", "definition 1", "example 1"));

    }

    @Override
    protected void onStart() {
        Frame();
        super.onStart();
    }

    private void Frame(){
    BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

    final Home_Fragments home_fragments = new Home_Fragments();
    final Idea_Fragment idea_fragment = new Idea_Fragment();
    final Voice_Fragment voice_fragment = new Voice_Fragment();
    final Help_Fragment help_fragment = new Help_Fragment();

    bottomNavigationView.setOnNavigationItemSelectedListener
            (new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    int id = menuItem.getItemId();
                    if (id == R.id.bottm_nav_home) {
                        setFragment(home_fragments);
                        return true;
                    } else if (id == R.id.bottm_nav_idea) {
                        setFragment(idea_fragment);
                        return true;
                    } else if (id == R.id.bottm_nav_voice) {
                        setFragment(voice_fragment);
                        return true;
                    } else if (id == R.id.bottm_nav_help) {
                        setFragment(help_fragment);
                        return true;
                    }
                    return false;
                }
            });

    bottomNavigationView.setSelectedItemId(R.id.bottm_nav_home);

}

    private void centeringAppbarTitle() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(getLayoutInflater().inflate(R.layout.center_appbar_title, null),
                new ActionBar.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.MATCH_PARENT,
                        Gravity.CENTER
                )
        );
    }


    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


    public void bottomBarIconClicked(View v) {
        if (v.getId() == R.id.home_icon)
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
        else if (v.getId() == R.id.idea_icon)
            Toast.makeText(this, "idea", Toast.LENGTH_SHORT).show();
        else if (v.getId() == R.id.voice_icon)
            startActivity(new Intent(this, AudioListActivity.class));
        else if (v.getId() == R.id.help_icon) {
            Database db = new Database(this);
            List<VocabularyDetail> data = db.read();

            String x = "";

            for (int i = 0; i < data.size(); i++)
                x = x + data.get(i).toString() + "\n";

            Log.d("abc", x);
        }
//            Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();
    }

}
