package com.example.tec_3;
//AUTOR : CHURA PABEL JOEL,CCUNO CARLOS PAUL ARNALDO, LIPA OCHOA JOSE,  //

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    private static int SPLASH_SCREEN=5000;
    Animation topAnim,bottomAnim;
    ImageView img;
    TextView titulo;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        img=(ImageView)findViewById(R.id.bus_logo);
        titulo=(TextView)findViewById(R.id.INICIO);
        img.setAnimation(topAnim);
        titulo.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent= new Intent(Inicio.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
        try {
            playAudio("https://firebasestorage.googleapis.com/v0/b/tec-3-281117.appspot.com/o/windows-95-startup-microsoft.mp3?alt=media&token=0fb2ac05-7f51-4a24-9e64-b1d720039ca5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void playAudio(String url)throws Exception{
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        mediaPlayer.prepare();
    }
}