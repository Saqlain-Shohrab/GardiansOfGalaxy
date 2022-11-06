package com.saqqu.guardiansofgalaxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StartActivity extends Activity {

    ImageView startBtn;
    boolean shouldExit = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activty_start);

        startBtn = findViewById(R.id.start_btn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, SpaceInvadersActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (shouldExit) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            new CountDownTimer(2000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    shouldExit = true;
                }

                @Override
                public void onFinish() {
                    shouldExit = false;
                }
            }.start();
        }

    }
}
