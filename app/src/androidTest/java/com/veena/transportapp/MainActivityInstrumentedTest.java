package com.veena.transportapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    public static final String TAG = "MainActivityTest";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        Log.d(TAG, "Package Name : " + appContext.getPackageName());
        assertEquals("com.veena.transportapp."+BuildConfig.FLAVOR, appContext.getPackageName());
    }

    @Test
    public void checkButtonName() {
        if ("full".equals(BuildConfig.FLAVOR)) {
            MainActivity mainActivity = mActivityRule.getActivity();
            Button button = (Button) mainActivity.findViewById(R.id.navigate);
            assertEquals("NAVIGATE", button.getText());
        }
    }
}
