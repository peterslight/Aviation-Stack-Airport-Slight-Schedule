package com.peterstev.nc_flightradar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.peterstev.nc_flightradar.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    editComment.setOnTouchListener(new OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            final int DRAWABLE_LEFT = 0;
//            final int DRAWABLE_TOP = 1;
//            final int DRAWABLE_RIGHT = 2;
//            final int DRAWABLE_BOTTOM = 3;
//
//            if(event.getAction() == MotionEvent.ACTION_UP) {
//                if(event.getRawX() >= (editComment.getRight() - editComment.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
//                    // your action here
//
//                    return true;
//                }
//            }
//            return false;
//        }
//    });
}