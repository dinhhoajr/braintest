package com.example.mybraintest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mybraintest.activity.HomeActivity;
import com.example.mybraintest.activity.InstructActivity;
import com.example.mybraintest.activity.IntroActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay,buttonIntro,buttonInstruct;
//    Button btnSignOut;
//    TextView txtEmail;
//    AGConnectUser user;
//    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getID();
//        buttonPlay.findViewById(R.id.button_play);
//        buttonInstruct.findViewById(R.id.button_instruct);
//        buttonIntro.findViewById(R.id.button_intro);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonInstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, InstructActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        buttonIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(intent2);
                finish();
            }
        });
//        loadCategories();
//
//        loadHighScore();
//        txtEmail.setText(AGConnectAuth.getInstance().getCurrentUser().getEmail());
//
//        buttonStartQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startQuestion();
//            }
//        });
//        btnSignOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AGConnectAuth.getInstance().signOut();
//                startActivity(new Intent(MainActivity.this, StartApp.class));
//                finish();
//            }
//        });
    }


    private void getID(){
//        txtEmail.findViewById(R.id.txtEmail);
//        btnSignOut.findViewById(R.id.btnLogout);
        buttonPlay = findViewById(R.id.button_play);
        buttonInstruct = findViewById(R.id.button_instruct);
        buttonIntro = findViewById(R.id.button_intro);


    }
}