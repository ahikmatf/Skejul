package xyz.fatahillah.skejul;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import xyz.fatahillah.skejul.fragments.DaftarMatkulFragment;
import xyz.fatahillah.skejul.fragments.InviteFragment;
import xyz.fatahillah.skejul.fragments.LihatMasalahFragment;
import xyz.fatahillah.skejul.fragments.SettingFragment;
import xyz.fatahillah.skejul.fragments.TabFragment;
import xyz.fatahillah.skejul.fragments.TambahJadwalFragment;
import xyz.fatahillah.skejul.masuk.SplashScreen;

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
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.menu_lihat_masalah) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new LihatMasalahFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.menu_mata_kuliah) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new DaftarMatkulFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.menu_invite) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new InviteFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.menu_setting) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new SettingFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.menu_help) {
                    Intent intent = new Intent(LihatJadwal.this, SplashScreen.class);
                    startActivity(intent);

                }


                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.tambah_jadwal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTambahJadwalFragment();
            }
        });

    }




    private void showTambahJadwalFragment() {
        FragmentManager fm = getSupportFragmentManager();
        TambahJadwalFragment tambahJadwalFragment = new TambahJadwalFragment();
        tambahJadwalFragment.show(fm, "fragment_tambah_jadwal");
    }
}