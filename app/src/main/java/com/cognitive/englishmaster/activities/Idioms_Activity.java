package com.cognitive.englishmaster.activities;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.cognitive.englishmaster.Fragments.IdiomsFragment;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.Idioms_Model;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

public class Idioms_Activity extends AppCompatActivity {
    private FragmentPagerAdapter adapterViewPager;
    private SmartTabLayout viewPagerTab ;
    private ViewPager viewPager;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioms_);
        Find_All_Views();
    }

    @Override
    protected void onStart() {
        Pager();

        super.onStart();
    }

    private void Find_All_Views(){
        viewPagerTab = (SmartTabLayout) findViewById(R.id.Idioms_viewpagertab);
        viewPager = (ViewPager) findViewById(R.id.Idioms_viewpager);

    }
    private void Pager(){
        viewPager.setOffscreenPageLimit(0);

        FragmentPagerItems.Creator creator = FragmentPagerItems.with(this);
        for (int i = 1, tabCount = 4; i < tabCount; i++) {

            creator.add(""+i, IdiomsFragment.class);
        }
        final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());

        //  viewPager.setAdapter(adapterViewPager);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

        viewPagerTab.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {
                viewPagerTab.setSelectedIndicatorColors();
                viewPager.setCurrentItem(position+1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Data(position,adapter);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        int  pageNo = getIntent ().getIntExtra ("position",0);

        viewPager.setCurrentItem(pageNo);

    }
    private void Data(int position , FragmentPagerItemAdapter adapter){
        IdiomsFragment fragment = ((IdiomsFragment) adapter.getPage(position));
        int[] androidColors = this.getResources().getIntArray(R.array.androidcolors);
        //for(int a  =0;a > androidColors.length;a++ ){


        List<Idioms_Model> allItems = new ArrayList<Idioms_Model>();
        allItems.add(new Idioms_Model ("A blessing in disguise","An apparent misfortune that eventually has" +
                "good results \n being omitted from the World Cup squad was a blessing in disguise","Translation"));
        allItems.add(new Idioms_Model ("A dime a dozen","    An apparent misfortune that eventually has" +
                " good results \n being omitted from the World Cup squad was a blessing in disguise","Translation"));
        allItems.add(new Idioms_Model ("Beat around the bush","    An apparent misfortune that eventually has" +
                " good results \n being omitted from the World Cup squad was a blessing in disguise","Translation"));


        fragment.setTextValue(String.valueOf(allItems.get(position).getIdiomTitle()),
                String.valueOf(allItems.get(position).getIdiomSentence()),
                String.valueOf(allItems.get(position).getIdiomsTranslation()),
                androidColors[position]);
        //     bindViews ();

    }
}


/*
                allItems.add(new Idioms_Model ("A blessing in disguise","An apparent misfortune that eventually has" +
                        "good results \n being omitted from the World Cup squad was a blessing in disguise","Translation"));
                        allItems.add(new Idioms_Model ("A dime a dozen","    An apparent misfortune that eventually has" +
                        " good results \n being omitted from the World Cup squad was a blessing in disguise","Translation"));
                        allItems.add(new Idioms_Model ("Beat around the bush","    An apparent misfortune that eventually has" +
                        " good results \n being omitted from the World Cup squad was a blessing in disguise","Translation"));
*/
