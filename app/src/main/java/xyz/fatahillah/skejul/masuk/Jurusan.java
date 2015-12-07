package xyz.fatahillah.skejul.masuk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import xyz.fatahillah.skejul.R;
import xyz.fatahillah.skejul.activity.LihatJadwal;

public class Jurusan extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan);

        Button clickButton = (Button) findViewById(R.id.submit_jurusan);
        clickButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.submit_jurusan:
                startActivity(new Intent(Jurusan.this, LihatJadwal.class));
                finish();

        }
    }
}
