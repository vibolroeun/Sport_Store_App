package com.vibolroeun.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vibolroeun.android_project.Adapter.Slider_Adapter;

public class Introduction_Screen extends AppCompatActivity implements View.OnClickListener{

    private ViewPager slideViewPager;
    private LinearLayout mDotLayout;
    private Slider_Adapter slider_adapter;
    private Button nextButton;
    private Button preButton;
    private Button startButton;
    private int mCurrentPage;
    private Intent intent;

    private TextView[] mDots;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        slideViewPager = findViewById(R.id.page_viewID);
        mDotLayout = findViewById(R.id.linearLayoutID);
        nextButton = findViewById(R.id.next_btnID);
        preButton = findViewById(R.id.previous_btnID);
        startButton = findViewById(R.id.get_start_btnID);

        nextButton.setOnClickListener(this);
        preButton.setOnClickListener(this);
        startButton.setOnClickListener(this);

        slider_adapter = new Slider_Adapter(this);
        slideViewPager.setAdapter(slider_adapter);

        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);

    }
    public void addDotsIndicator(int position){

        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for(int i = 0; i<mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(30);
            mDots[i].setTextColor(getResources().getColor(R.color.colorGray));

            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorLightgray));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            mCurrentPage = position;

            //first page Button attibute
            if(position == 0){
                nextButton.setEnabled(true);
                preButton.setEnabled(false);
                preButton.setVisibility(View.INVISIBLE);

                nextButton.setText("Next");
                preButton.setText("");
            }
            // last page Button attribute
            else if(position == mDots.length - 1){

                nextButton.setEnabled(true);
                preButton.setEnabled(true);
                preButton.setVisibility(View.VISIBLE);

                nextButton.setText("Finish");
                preButton.setText("Back");
            } else {

                nextButton.setEnabled(true);
                preButton.setEnabled(true);
                preButton.setVisibility(View.VISIBLE);

                nextButton.setText("Next");
                preButton.setText("Back");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.next_btnID: slideViewPager.setCurrentItem(mCurrentPage + 1); break;
            case R.id.previous_btnID: slideViewPager.setCurrentItem(mCurrentPage - 1); break;
            case R.id.get_start_btnID:

                intent = new Intent(Introduction_Screen.this, MainActivity.class);
                startActivity(intent); break;
        }

    }
}
