package com.pat.admin.watoto;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private BottomBar mBottomBar;
    private MediaController mediaControls;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.material_maroon)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerList = (ListView) findViewById(R.id.navList);
        addDrawerItems();

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottom_bar_menu);
        mBottomBar.getBar().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
        mBottomBar.mapColorForTab(0, "#00FF00");
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(getApplicationContext(), R.color.material_maroon));
//        mBottomBar.mapColorForTab(2, ContextCompat.getColor(getApplicationContext(), R.color.material_maroon));
//        mBottomBar.mapColorForTab(3, ContextCompat.getColor(getApplicationContext(), R.color.material_maroon));
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user selected item number one.
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user reselected item number one, scroll your content to top.
                    Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                    startActivity(intent);
                } else if (menuItemId == R.id.bottomBarItemtwo) {
                    // The user reselected item number one, scroll your content to top.
                    Intent intent = new Intent(getApplicationContext(), DonateActivity.class);
                    startActivity(intent);
                } else if (menuItemId == R.id.bottomBarItemthree) {
                    // The user reselected item number one, scroll your content to top.
                    Intent intent = new Intent(getApplicationContext(), ChoirActivity.class);
                    startActivity(intent);
                }
            }
        });

        //set the media controller buttons
        if (mediaControls == null) {
            mediaControls = new MediaController(VideoActivity.this);
        }
        videoView = (VideoView) findViewById(R.id.video_view);
        assert videoView != null;
        videoView.setMediaController(mediaControls);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.gameloft;
        videoView.setVideoURI(Uri.parse(path));
//        videoView.start();
    }

    private void addDrawerItems() {
        final String[] items = {"Home", "Donate", "Book Choir", "Activities", "About", "Sign In", "Sign Up"};
        Integer imageid[] = {
                R.drawable.ic_home,
                R.drawable.ic_love,
                R.drawable.ic_music,
                R.drawable.ic_items,
                R.drawable.ic_info,
                R.drawable.ic_sign_in,
                R.drawable.ic_sign_up
        };

        DrawerList customList = new DrawerList(this, items, imageid);

        listView = (ListView) findViewById(R.id.navList);
        assert listView != null;
        listView.setAdapter(customList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), DonateActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), ChoirActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), WorkActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), SignInActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getApplicationContext(), SignUpActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
