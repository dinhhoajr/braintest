package com.example.mybraintest.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mybraintest.MainActivity;
import com.example.mybraintest.R;
import com.example.mybraintest.model.Category;
import com.example.mybraintest.model.Database;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView textViewHighScore;
    private Spinner spinnerCategory;
    private Button buttonStart;
    private int highScore;
    private static final int REQUEST_CODE_QUESTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getID();

        loadCategories();

        loadHighScore();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuestion();
            }
        });

        HwAds.init(HomeActivity.this);

        // Obtain BannerView configured in the XML layout file.
        BannerView bottomBannerView = findViewById(R.id.hw_banner_view);
        AdParam adParam = new AdParam.Builder().build();
        bottomBannerView.loadAd(adParam);

        // Add BannerView through coding.
        BannerView topBannerView = new BannerView(HomeActivity.this);
        topBannerView.setAdId("testw6vs28auh3");
        topBannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_SMART);


        RelativeLayout rootView = findViewById(R.id.root_view);
        rootView.addView(topBannerView);
    }
    private void loadHighScore() {
        SharedPreferences preferences = getSharedPreferences("share",MODE_PRIVATE);
        highScore = preferences.getInt("highscore",0);
        textViewHighScore.setText("Điểm Cao : "+highScore);
    }

    private void startQuestion() {

        Category category = (Category) spinnerCategory.getSelectedItem();
        int categoryID = category.getId();
        String categoryName = category.getName();

        Intent intent = new Intent(HomeActivity.this, QuestionActivity.class);

        intent.putExtra("idcategories",categoryID);
        intent.putExtra("catgoriesname",categoryName);

        startActivityForResult(intent,REQUEST_CODE_QUESTION);

    }

    private void loadCategories(){
        Database database = new Database(this);

        List<Category> categories = database.getDataCategories();

        ArrayAdapter<Category> categoryArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,categories);

        categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCategory.setAdapter(categoryArrayAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUESTION){
            if (resultCode == RESULT_OK){
                int score = data.getIntExtra("Score", 0);

                if (score > highScore){
                    updateHighScore(score);
                }
            }
        }
    }

    private void updateHighScore(int score) {

        highScore = score;

        textViewHighScore.setText("Điểm Cao : "+highScore);

        SharedPreferences preferences = getSharedPreferences("share",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("highscore",highScore);

        editor.apply();

    }
    private void getID(){
        buttonStart = findViewById(R.id.button_start);
        textViewHighScore = findViewById(R.id.textView_high_score);
        spinnerCategory = findViewById(R.id.spinnerCategory);
    }
}