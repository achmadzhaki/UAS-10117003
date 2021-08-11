package com.uas.wisatabandung_10117003;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
/*
 * Nama : Achmad Zaki
 * Kelas : IF 8
 * NIM : 10117003
 * pengerjaan : 11 Agustus 2021
 * */
public class MainActivity extends AppCompatActivity {
//https://medium.com/@harmittaa/android-floating-bottom-navigation-bar-with-rounded-corners-56040d804869
    //https://github.com/harmittaa/CoolBottomNavigationBar/tree/master/app/src/main/res/menu
    //https://www.androidrion.com/cara-membuat-bottomnavigationview-viewpager-android-studio/
ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
FragAbout fragabout;
    FragProfile fragProfile;
    FragWisata fragwisata;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager = findViewById(R.id.pager);
        setupViewPager(viewPager);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.wisata:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.about:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.profile:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragwisata = new FragWisata();
        fragabout = new FragAbout();

        fragProfile = new FragProfile();

        adapter.addFragment(fragwisata);
        adapter.addFragment(fragabout);

        adapter.addFragment(fragProfile);
        viewPager.setAdapter(adapter);
    }
}