package com.stiggpwnz.vibes.fragments.base;

import android.os.Bundle;

public abstract class RetainedFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
}