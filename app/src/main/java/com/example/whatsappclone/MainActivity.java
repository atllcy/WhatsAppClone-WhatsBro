package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);

        FragmentManager fm = getSupportFragmentManager();
        pageAdapter = new PageAdapter(fm,getLifecycle());
        viewPager2.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ng) {
            Toast.makeText(getApplicationContext(), "New group menu selected", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nb) {
            Toast.makeText(getApplicationContext(), "New broadcast menu selected", Toast.LENGTH_LONG).show();
        } else if (id == R.id.ld) {
            Toast.makeText(getApplicationContext(), "Linked devices menu selected", Toast.LENGTH_LONG).show();
        } else if (id == R.id.sm) {
            Toast.makeText(getApplicationContext(), "Starred messages menu selected", Toast.LENGTH_LONG).show();
        } else if (id == R.id.st) {

            Intent intent = new Intent(this, Setting_page.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
