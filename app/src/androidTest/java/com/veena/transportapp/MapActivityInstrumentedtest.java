package com.veena.transportapp;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by veena on 19/06/17.
 */

@RunWith(AndroidJUnit4.class)
public class MapActivityInstrumentedtest {
    public static final String TAG = "MapActivityTest";

    @Rule
    public ActivityTestRule<MapActivity> mActivityRule = new ActivityTestRule<>(
            MapActivity.class);

    @Test
    public void checkIsChildActivity() {
        Activity mapActivity = mActivityRule.getActivity();
        Log.d(TAG, String.valueOf(mapActivity.isChild()));
        assertEquals(false, mapActivity.isChild());
    }

}
