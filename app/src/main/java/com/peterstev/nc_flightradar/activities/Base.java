package com.peterstev.nc_flightradar.activities;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.peterstev.nc_flightradar.R;

import java.util.ArrayList;
import java.util.List;

public abstract class Base extends AppCompatActivity {

    List<Fragment> oldFragmentList = new ArrayList<>();
    private int count = 0;

    public Fragment getCurrentFragment(int frameLayoutId) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(frameLayoutId);
        if (fragment != null) {
            return fragment;
        }
        return null;
    }

    public void applyFragment(Fragment fragment, int frameLayoutId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frameLayoutId, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commitAllowingStateLoss();
    }

    public void saveAndGotoNextFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment oldFragment = getCurrentFragment(R.id.main_frame);
        oldFragmentList.add(oldFragment);
        transaction.hide(oldFragment);
        transaction.add(R.id.main_frame, fragment, String.valueOf(fragment.getId()));
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    public void onBackPressedImpl(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (oldFragmentList.size() > 0) {
            transaction.remove(getCurrentFragment(R.id.main_frame));
            int fragmentPosition = (oldFragmentList.size() - 1);
            transaction.show(oldFragmentList.get(fragmentPosition));
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.commit();
            oldFragmentList.remove(fragmentPosition);
            count = 0;
            if (fragmentPosition == 0) {
//                showExFab();
            }
        } else {
            count++;
            if (count < 2) {
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            } else
                super.onBackPressed();
        }
    }
}
