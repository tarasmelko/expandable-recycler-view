package com.thoughtbot.expandablerecyclerview.sample;

import static androidx.test.espresso.action.ViewActions.click;
import static junit.framework.Assert.assertTrue;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.thoughtbot.expandablerecyclerview.sample.expand.ExpandActivity;
import com.thoughtbot.expandablerecyclerview.sample.expand.GenreAdapter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExpandActivityTest {

    @Rule
    public ActivityTestRule<ExpandActivity> activityRule = new ActivityTestRule<>(ExpandActivity.class);

    private RecyclerView recyclerView;
    private GenreAdapter adapter;

    @Before
    public void setUp() {
        recyclerView = (RecyclerView) activityRule.getActivity().findViewById(R.id.recycler_view);

        adapter = activityRule.getActivity().adapter;
    }

    @Test
    public void testClickGroup() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        assertTrue(adapter.isGroupExpanded(0));
    }

    @Test
    public void testClickItem() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
    }
}