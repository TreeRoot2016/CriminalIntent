package com.bignerdranch.android.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity
        implements CrimeListFragment.CallBacks, CrimeFragment.CallBacks{



    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdatail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if(null == findViewById(R.id.detail_fragment_container)){
            Intent intent = CrimePagerActivity
                    .newIntent(CrimeListActivity.this, crime.getId());
            startActivity(intent);
        }else {
            Fragment newCrime = CrimeFragment.newInstance(crime.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newCrime)
                    .commit();
        }
    }


    @Override
    public void onCrimeUpdated(Crime crime) {
        ((CrimeListFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_container))
                .updateUI();
    }
}
