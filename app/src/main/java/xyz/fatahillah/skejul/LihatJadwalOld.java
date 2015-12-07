package xyz.fatahillah.skejul;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import xyz.fatahillah.skejul.fragments.FridayFragment;
import xyz.fatahillah.skejul.fragments.MondayFragment;
import xyz.fatahillah.skejul.fragments.TambahJadwalFragment;
import xyz.fatahillah.skejul.fragments.ThursdayFragment;
import xyz.fatahillah.skejul.fragments.TuesdayFragment;
import xyz.fatahillah.skejul.fragments.WednesdayFragment;

//import xyz.fatahillah.skejul.R;

public class LihatJadwalOld extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_jadwal_old);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MondayFragment fragment = new MondayFragment();
        transaction.replace(R.id.viewpager, fragment);
        transaction.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.tambah_jadwal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTambahJadwalFragment();
            }
        });

        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
    }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.back_only, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.tb_setting) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MondayFragment(), "SENIN");
        adapter.addFrag(new TuesdayFragment(), "SELASA");
        adapter.addFrag(new WednesdayFragment(), "RABU");
        adapter.addFrag(new ThursdayFragment(), "KAMIS");
        adapter.addFrag(new FridayFragment(), "JUM'AT");
        viewPager.setAdapter(adapter);

    }

    private void showTambahJadwalFragment() {
        FragmentManager fm = getSupportFragmentManager();
        TambahJadwalFragment tambahJadwalFragment = new TambahJadwalFragment();
        tambahJadwalFragment.show(fm, "fragment_tambah_jadwal");
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

/*    public class HeightWrappingViewPager extends ViewPager {

        public HeightWrappingViewPager(Context context) {
            super(context);
        }

        public HeightWrappingViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            boolean wrapHeight = MeasureSpec.getMode(heightMeasureSpec)
                    == MeasureSpec.AT_MOST;

            if(wrapHeight) {
                *//**
     * The first super.onMeasure call made the pager take up all the
     * available height. Since we really wanted to wrap it, we need
     * to remeasure it. Luckily, after that call the first child is
     * now available. So, we take the height from it.
     *//*

                int width = getMeasuredWidth(), height = getMeasuredHeight();

                // Use the previously measured width but simplify the calculations
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);

            *//* If the pager actually has any children, take the first child's
             * height and call that our own *//*
                if(getChildCount() > 0) {
                    View firstChild = getChildAt(0);

                *//* The child was previously measured with exactly the full height.
                 * Allow it to wrap this time around. *//*
                    firstChild.measure(widthMeasureSpec,
                            MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST));

                    height = firstChild.getMeasuredHeight();
                }

                heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
    }*/
}
