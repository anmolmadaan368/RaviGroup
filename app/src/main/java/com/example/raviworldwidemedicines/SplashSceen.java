package com.example.raviworldwidemedicines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;

public class SplashSceen extends AppCompatActivity {

    Animation topanimation,bottomnavigation;
    ImageView view_Logom;
//            ,loading1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sceen);
        view_Logom = findViewById(R.id.view_Logom);
//        loading1 = findViewById(R.id.loading1);



        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        view_Logom.setAnimation(topanimation);
//        bottomnavigation = AnimationUtils.loadAnimation(this,R.anim.bottom_navigation);
//        loading1.setAnimation(bottomnavigation);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashSceen.this, MainActivity.class);
                startActivity(intent);
              finish();

            }

        },5000);


    }
}