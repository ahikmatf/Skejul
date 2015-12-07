package xyz.fatahillah.skejul.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import xyz.fatahillah.skejul.R;
import xyz.fatahillah.skejul.appinvite.InviteActivity;
import xyz.fatahillah.skejul.fragments.LihatMasalahFragment;
import xyz.fatahillah.skejul.fragments.TabFragment;

/**
 * Created by root on 12/1/15.
 */

public class LihatJadwal extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_jadwal);

        /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navview);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.menu_lihat_jadwal) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.menu_lihat_masalah) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new LihatMasalahFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.menu_mata_kuliah) {
                    Intent intent = new Intent(LihatJadwal.this, MatkulTakenActivity.class);
                    startActivity(intent);

                }

                if (menuItem.getItemId() == R.id.menu_invite) {
                    Intent intent = new Intent(LihatJadwal.this, InviteActivity.class);
                    startActivity(intent);

                }

                if (menuItem.getItemId() == R.id.menu_setting) {
                    Intent intent = new Intent(LihatJadwal.this, SettingActivity.class);
                    startActivity(intent);

                }

                if (menuItem.getItemId() == R.id.menu_help) {
                    Intent intent = new Intent(LihatJadwal.this, HelpActivity.class);
                    startActivity(intent);

                }


                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);


        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.plus_only, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.tb_add:
                startActivity(new Intent(this, MatkulTakenActivity.class));
                return true;
        }


        return super.onOptionsItemSelected(item);
    }


}