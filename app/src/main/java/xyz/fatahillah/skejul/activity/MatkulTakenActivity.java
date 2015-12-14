package xyz.fatahillah.skejul.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import xyz.fatahillah.skejul.R;
import xyz.fatahillah.skejul.fragments.TambahMatkulFragment;
import xyz.fatahillah.skejul.fragments.TimePickerFragment;

public class MatkulTakenActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_taken);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mata Kuliah Taken");

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
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.tb_add:
                FragmentManager fm = getSupportFragmentManager();
                TambahMatkulFragment tambahMatkulFragment = new TambahMatkulFragment();
                tambahMatkulFragment.show(fm, "fragment_tambah_jadwal");
//            case R.id.tb_setting:
//                startActivity(new Intent(this, SettingActivity.class));
//                return true;
//            case R.id.tb_add:
//                startActivity(new Intent(this, MatkulTakenActivity.class));
//                return true;
        }


        return super.onOptionsItemSelected(item);
    }

//    private void showTambahJadwalFragment() {
//        FragmentManager fm = getSupportFragmentManager();
//        TambahJadwalFragment tambahJadwalFragment = new TambahJadwalFragment();
//        tambahJadwalFragment.show(fm, "fragment_tambah_jadwal");
//    }

    public void onClickMatkul(View v) {
        Intent intent = new Intent(this, TambahJadwal.class);
        startActivity(intent);
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}
