package com.pat.admin.watoto;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class DonateActivity extends AppCompatActivity {

    private Spinner paymentDropdown;
    private BottomBar mBottomBar;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.material_maroon)));


        paymentDropdown = (Spinner) findViewById(R.id.paymentSpinner);
        String[] paymentItems = new String[]{"Cash", "Cheque", "Direct Debit", "Standing Order"};

        ArrayAdapter<String> paymentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, paymentItems);
        paymentDropdown.setAdapter(paymentAdapter);

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

//        mBottomBar = BottomBar.attach(this, savedInstanceState);
//        mBottomBar.setItems(R.menu.bottom_bar_menu);
//        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
//            @Override
//            public void onMenuTabSelected(@IdRes int menuItemId) {
//                if (menuItemId == R.id.bottomBarItemOne) {
//                    // The user selected item number one.
//                    Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
//                    startActivity(intent);
//                } else if (menuItemId == R.id.bottomBarItemtwo) {
//                    // The user reselected item number one, scroll your content to top.
//                    Intent intent = new Intent(getApplicationContext(), DonateActivity.class);
//                    startActivity(intent);
//                } else if (menuItemId == R.id.bottomBarItemthree) {
//                    // The user reselected item number one, scroll your content to top.
//                    Intent intent = new Intent(getApplicationContext(), ChoirActivity.class);
//                    startActivity(intent);
//                }
//            }
//
//            @Override
//            public void onMenuTabReSelected(@IdRes int menuItemId) {
//                if (menuItemId == R.id.bottomBarItemOne) {
//                    // The user reselected item number one, scroll your content to top.
//                }
//            }
//        });
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
//        mDrawerList.setAdapter(mAdapter);

        DrawerList customList = new DrawerList(this, items, imageid);

        listView = (ListView) findViewById(R.id.navList);
        assert listView != null;
        listView.setAdapter(customList);
//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        intent = new Intent(getApplicationContext(), VideoActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
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
//                Toast.makeText(getApplicationContext(),"You Clicked "+items[i],Toast.LENGTH_SHORT).show();
            }
        });
    }

}
