package com.sai8.superheros.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.sai8.superheros.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SplashTest {

    @Rule
    public ActivityTestRule<Splash> mActivityTestRule = new ActivityTestRule<>(Splash.class);

    @Test
    public void splashTest2() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.loginregisterbutton), withText("Sign up"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 4), isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textInputEditText = onView(allOf(childAtPosition(childAtPosition(withId(R.id.registeremail), 0), 0), isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(allOf(childAtPosition(childAtPosition(withId(R.id.registeremail), 0), 0), isDisplayed()));
        textInputEditText2.perform(replaceText("sai3@gmail.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(allOf(childAtPosition(childAtPosition(withId(R.id.registerpassword), 0), 0), isDisplayed()));
        textInputEditText3.perform(replaceText("12345678"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(allOf(withId(R.id.registerbutton), withText("Register"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 3), isDisplayed()));
        appCompatButton2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textInputEditText4 = onView(allOf(childAtPosition(childAtPosition(withId(R.id.loginemail), 0), 0), isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction textInputEditText5 = onView(allOf(childAtPosition(childAtPosition(withId(R.id.loginemail), 0), 0), isDisplayed()));
        textInputEditText5.perform(replaceText("saikumarvayala@gmail.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText6 = onView(allOf(childAtPosition(childAtPosition(withId(R.id.loginpassword), 0), 0), isDisplayed()));
        textInputEditText6.perform(replaceText("sai@1234"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(allOf(withId(R.id.loginsigninbutton), withText("Sign in"), childAtPosition(childAtPosition(withId(android.R.id.content), 0), 3), isDisplayed()));
        appCompatButton3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html

    }

    private static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
