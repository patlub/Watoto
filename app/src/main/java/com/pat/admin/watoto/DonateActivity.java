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
        String[] osArray = {"Sponsor", "Donate", "Choir", "Activities", "Get Involved", "About", "Sign In", "Sign Up"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
//                switch (position) {
//                    case 1:
//                        intent = new Intent(getApplicationContext(), DonateActivity.class);
//                        startActivity(intent);
//                    case 2:
//                        intent = new Intent(getApplicationContext(), ChoirActivity.class);
//                        startActivity(intent);
//                    case 6:
//                        intent = new Intent(getApplicationContext(), SignInActivity.class);
//                        startActivity(intent);
//                    case 7:
//                        intent = new Intent(getApplicationContext(), SignUpActivity.class);
//                        startActivity(intent);
//                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.sign_in) {
            Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
            startActivity(intent);
        } else if (id == R.id.sign_up) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        } else if (id == R.id.video) {
            Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
            startActivity(intent);
        } else if (id == R.id.donate) {
            Intent intent = new Intent(getApplicationContext(), DonateActivity.class);
            startActivity(intent);
        } else if (id == R.id.choir) {
            Intent intent = new Intent(getApplicationContext(), ChoirActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
