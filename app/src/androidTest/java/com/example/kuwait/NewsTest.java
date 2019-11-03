package com.example.kuwait;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.kuwait.AllNews.News;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class NewsTest {
    @Rule
    public final ActivityTestRule<News> mActivityRule =
            new ActivityTestRule<>(News.class);
    @Before
    public void setUpTest() {

    }
    @Test
    public void testSample(){
        onView(withId(R.id.rv_news)).perform(scrollToPosition(30));
        onView(withId(R.id.btn)).perform(click());

            onView(withId(R.id.rv_news)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        }

}
