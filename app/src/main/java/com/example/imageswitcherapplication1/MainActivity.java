package com.example.imageswitcherapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher mimgsw;
    Button mbtnnext;

    int imageids[]={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5};
    int count=imageids.length;;
    int currentIndex=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mimgsw=findViewById(R.id.imgswither);
        mbtnnext=findViewById(R.id.buttonNext);

    mimgsw.setFactory(new ViewSwitcher.ViewFactory() {
        @Override
        public View makeView() {
            ImageView newimgview=new ImageView(getApplicationContext());
            newimgview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            newimgview.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));


            return newimgview;

        }
    });
        // Declare in and out animations and load them using AnimationUtils class
        Animation in= AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out=AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        // set the animation type to ImageSwitcher
        mimgsw.setInAnimation(in);
        mimgsw.setOutAnimation(out);

        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        mbtnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if(currentIndex==count)
                {
                    currentIndex=0;
                }

                mimgsw.setImageResource(imageids[currentIndex]);
            }
        });


    }
}