package com.example.pritam.twopane;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pritam on 2/15/2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityTest {

    public static final String NAME = "Pritam";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new
            ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkActivity(){
        onView(withId(R.id.recycler_view_fragment_main)).perform(RecyclerViewActions.scrollToPosition(1));
        onView(withText(NAME)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view_fragment_main))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}
