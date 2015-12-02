package xyz.fatahillah.skejul.masuk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xyz.fatahillah.skejul.R;

public class SplashScreen extends AppCompatActivity {

    Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                Intent intent = new Intent(SplashScreen.this, Kampus.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        timerThread.start();
    }

}
