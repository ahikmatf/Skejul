package xyz.fatahillah.skejul.masuk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import xyz.fatahillah.skejul.R;

public class Kampus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kampus);


        Button button = (Button) findViewById(R.id.submit_kampus);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), Jurusan.class);
                startActivity(intent);
                finish();
            }
        });
    }
}