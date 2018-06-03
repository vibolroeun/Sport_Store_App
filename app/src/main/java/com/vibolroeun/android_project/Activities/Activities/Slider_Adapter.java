package com.vibolroeun.android_project.Activities.Activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vibolroeun.android_project.R;

public class Slider_Adapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    //Arrays
    public int[] slide_back_images = {
            R.drawable.intro1,
            R.drawable.intro2,
            R.drawable.intro3,
            R.drawable.intro4
    };
    public int[] slide_icon_images = {
            R.drawable.icon,
            R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3
    };
    public String[] slide_title = {
            "Welcome To Our Sport Store",
            "Sport Products",
            "Order Products",
            "Delivery Products"
    };
    public String[] slide_desc = {
            "New: A touch ripple and improved response time now accompanies users entering information or filtering content.",
            "New: A touch ripple and improved response time now accompanies users entering information or filtering content.",
            "New: A touch ripple and improved response time now accompanies users entering information or filtering content.",
            "New: A touch ripple and improved response time now accompanies users entering information or filtering content."
    };


    public Slider_Adapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.introduction_slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.backImage_introID);
        ImageView slideLogoImageView = view.findViewById(R.id.logo_introID);
        TextView slideTitle = view.findViewById(R.id.title_introID);
        TextView slideDescription = view.findViewById(R.id.descript_introID);

        slideImageView.setImageResource(slide_back_images[position]);
        slideLogoImageView.setImageResource(slide_icon_images[position]);
        slideTitle.setText(slide_title[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
