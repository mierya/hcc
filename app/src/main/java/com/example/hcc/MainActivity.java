package com.example.hcc;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private DrawerLayout mDrawerLayout;
    private Hcc[] hccs = {new Hcc("林深时见鹿",R.drawable.show_1),
            new Hcc("海蓝时见鲸",R.drawable.show_2),new Hcc("梦醒时见你",R.drawable.show_3),
            new Hcc("笑看嫣红染半山",R.drawable.show_4),new Hcc("逐风万里白云间",R.drawable.show_5),
            new Hcc("华色含光",R.drawable.show_6),new Hcc("以梦为马",R.drawable.show_7),
            new Hcc("等一个人",R.drawable.show_8),new Hcc("还是等一个故事",R.drawable.show_9),
            new Hcc("如花美眷",R.drawable.show_10),new Hcc("似水流年",R.drawable.show_11),
            new Hcc("眼角笑意",R.drawable.show_12),new Hcc("夕夏温存",R.drawable.show_13),
            new Hcc("水清天蓝",R.drawable.show_14),new Hcc("邀月对影",R.drawable.show_15),
            new Hcc("往事如烟",R.drawable.show_16),new Hcc("岁月如歌",R.drawable.show_17),
            new Hcc("白驹过隙",R.drawable.show_18),new Hcc("草在结它的种子",R.drawable.show_19),
            new Hcc("风在摇它的叶子",R.drawable.show_20),new Hcc("我们站着，不说话",R.drawable.show_21),
            new Hcc("就十分美好 ",R.drawable.show_22)};
    private List<Hcc> hccList = new ArrayList<>();
    private HccAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                if(item.getItemId()== R.id.nav_friend){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:13018203592"));
                    startActivity(intent);
                }
                else{
                    mDrawerLayout.closeDrawers();
                }

                return true;
            }
        });
        initHcc();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HccAdapter(hccList);
        recyclerView.setAdapter(adapter);
    }
    private void initHcc(){
        hccList.clear();
        for(int i=0;i<22;i++){
            hccList.add(hccs[i]);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }
}
