package com.example.leon.myvideo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SurfaceHolder.Callback{

    MediaPlayer player = null;
    private Button buttonStart;
    private Button buttonStop;
    private Button buttonPause;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayerInit();
    }
    private void PlayerInit()
    {
        //button
        surfaceView = findViewById(R.id.surface_show);
        buttonStart = findViewById(R.id.button_start);
        buttonPause = findViewById(R.id.button_pause);
        buttonStop = findViewById(R.id.button_stop);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonPause.setOnClickListener(this);
        //sufaceView
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(320,220);
    }

    @Override
    public void onClick(View view) {
        int id;
        id = view.getId();
        switch (id)
        {
            case R.id.button_start:
            {
                Toast.makeText(getApplicationContext(),"开始播放",Toast.LENGTH_SHORT).show();
                player.start();
            }break;
            case R.id.button_pause:
            {
                Toast.makeText(getApplicationContext(),"暂停播放",Toast.LENGTH_SHORT).show();
                player.pause();
            }break;
            case R.id.button_stop:
            {
                Toast.makeText(getApplicationContext(),"停止播放",Toast.LENGTH_SHORT).show();
                player.stop();
            }break;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        player = MediaPlayer.create(MainActivity.this, R.raw.demo);
        player.setDisplay(surfaceHolder);    //设置显示视频显示在SurfaceView上
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
