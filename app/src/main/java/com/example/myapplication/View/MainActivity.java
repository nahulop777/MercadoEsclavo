package com.example.myapplication.View;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> listaPantallas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        listaPantallas = new ArrayList<>();

        listaPantallas.add(new FragmentCelular());

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(),listaPantallas);

        viewPager.setAdapter(viewPageAdapter);
    }


    }

