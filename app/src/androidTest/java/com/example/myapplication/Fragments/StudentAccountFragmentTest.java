package com.example.myapplication.Fragments;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import com.example.myapplication.StudentAccountFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class StudentAccountFragmentTest {

    // Fragment Test Rule for Student Account Fragment
    @Rule
    public FragmentTestRule<?, StudentAccountFragment> studentAccountFragmentTestRule = FragmentTestRule.create(StudentAccountFragment.class);
    StudentAccountFragment studentAccountFragment = studentAccountFragmentTestRule.getFragment();

    // Monitor to be used for Instrumentation
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null ,false);

//    @Before
//    public void setUp() throws Exception {
//    }

    // Checking if the activity appears and whether is matches the id 'studentAccountFragment'
    @Test
    public void isActivityInView(){
        onView(withId(R.id.studentAccountFragment)).check(matches(isDisplayed()));
    }

//     @Test
//     public void testLaunch(){
//         onView(withId(R.id.profileBackground)).check(matches((isDisplayed())));
//         onView(withId(R.id.profilePic)).check(matches(isDisplayed()));
//         onView(withId(R.id.profileName)).check(matches(isDisplayed()));
//         onView(withId(R.id.profileEmail)).check(matches(isDisplayed()));
//         onView(withId(R.id.btnSettings)).check(matches(isDisplayed()));
//         onView(withId(R.id.btnLogout)).check(matches(isDisplayed()));
//         onView(withId(R.id.studentTeacherTextView)).check(matches(isDisplayed()));
//         onView(withId(R.id.toggleBtn)).check(matches(isDisplayed()));
//     }

    // Testing to see if the Settings Button can be clicked
    @Test
    public void testSettingsBtn() {
        onView(withId(R.id.btnSettings)).perform(click());
    }

    // Testing to see if the Logout Button can be clicked
    @Test
    public void testLogoutBtn() {
        onView(withId(R.id.btnLogout)).perform(click());
    }

//     @Test
//     public void testToggleBtn() {
//         onView(withId(R.id.toggleBtn)).perform(click());
//     }

    // Testing to see if the Settings Button can be clicked and what happens when this is executed
    @Test
    public void testSettingsBtn2(){
        onView(withId(R.id.btnSettings)).perform(click());
        Activity settings = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNull(settings);

        //LecturerAccountFragment.finish();
    }

    // Testing to see if the Logout Button can be clicked and what happens when this is executed
    @Test
    public void testLogoutBtn2(){
        onView(withId(R.id.btnLogout)).perform(click());
        Activity settings = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNull(settings);

        //LecturerAccountFragment.finish();
    }

    // Testing to see if the Title of the Dialog matches with the text
    @Test
    public void testLogoutButtonDialogTitle(){
        onView(withId(R.id.btnLogout)).perform(click());
        onView(withText("Log out of Wits Academy")).check(matches(isDisplayed()));
    }

    // Testing to see if the Message of the Dialog matches with the text
    @Test
    public void testLogoutButtonDialogMsg(){
        onView(withId(R.id.btnLogout)).perform(click());
        onView(withText("Are you sure you would like to log out?")).check(matches(isDisplayed()));
    }

    // Testing to see if the options are displayed
    @Test
    public void testLogoutButtonDialogOptions(){
        onView(withId(R.id.btnLogout)).perform(click());
        onView(withId(android.R.id.button1)).check(matches(isDisplayed()));
        onView(withId(android.R.id.button2)).check(matches(isDisplayed()));
    }

    // Testing the logout button from the dialog to see if user is logged out
    @Test
    public void testLogoutClickLogoutBtn(){
        onView(withId(R.id.btnLogout)).perform(click());
        // android.R.id.button1 = positive button (logout)
        onView(withId(android.R.id.button1)).perform(click());
    }

    // Testing the cancel button from the dialog to see if user changes their mind
    @Test
    public void testLogoutClickCancelBtn(){
        onView(withId(R.id.btnLogout)).perform(click());
        // android.R.id.button2 = negative button (Cancel)
        onView(withId(android.R.id.button2)).perform(click());
    }

//     @Test
//     public void testToggleBtn2(){
//         onView(withId(R.id.toggleBtn)).perform(click());
//         Activity studNav = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
//         assertNull(studNav);

//         //LecturerAccountFragment.finish();
//     }

//    @After
//    public void tearDown() throws Exception {
//    }
}
