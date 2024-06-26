package com.example.stopwatches;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView appname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

            appname = findViewById(R.id.app_name);

            //Typeface typeface = ResourcesCompat.getFont(this,R.font.class);
            Animation anim = AnimationUtils.loadAnimation(this,R.anim.myanim);
            appname.setAnimation(anim);

            new Thread(){
                @Override
                public void run(){
                    try {
                        sleep(3000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                }



            }.start();

        }

    }

