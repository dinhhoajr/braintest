package com.example.mybraintest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mybraintest.MainActivity;
import com.example.mybraintest.R;
import java.util.Timer;
import java.util.TimerTask;

public class StartApp extends AppCompatActivity {
    private TimerTask timerTask;
    private static int SPLASH_TIME_OUT = 3000;

//    public String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

//        AGConnectUser user = AGConnectAuth.getInstance().getCurrentUser();

//        if(user!=null)
////            silentlySignIn();
////        else
//            userEmail = user.getEmail();
        Timer RunSplash = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(StartApp.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(StartApp.this,"Welcome to Brain Test !",
                                Toast.LENGTH_LONG).show();
                        finish();

//                        if (userEmail!=null) {
////                            lottieAnimationView.setVisibility(View.INVISIBLE);
//                            Intent intent = new Intent(StartApp.this, MainActivity.class);
//                            startActivity(intent);
//                            Toast.makeText(StartApp.this,"Welcome to Brain Test !",
//                                    Toast.LENGTH_LONG).show();
//                            finish();
//                        }else{
//                            Toast.makeText(StartApp.this, "Đăng Nhập Tài Khoản !",Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(StartApp.this, LoginActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
                    }
                });
            }
        };
        RunSplash.schedule(timerTask, SPLASH_TIME_OUT);
    }
}