package com.thoughtbot.expandablerecyclerview.sample;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import android.app.Application;
import android.content.Context;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableListPosition;
import com.thoughtbot.expandablerecyclerview.sample.expand.ArtistViewHolder;
import com.thoughtbot.expandablerecyclerview.sample.expand.GenreAdapter;
import com.thoughtbot.expandablerecyclerview.sample.expand.GenreViewHolder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.List;

/**
 * Unit test for GenreAdapter
 */
@RunWith(RobolectricTestRunner.class)
public class GenreAdapterTest {

    private Context context;
    private List<Genre> groups;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Application application = RuntimeEnvironment.application;
        assertNotNull(application);

        context = application;
        groups = GenreDataFactory.makeGenres();
    }

    @Test
    public void test_onCreateViewHolder() {
        GenreAdapter adapter = new GenreAdapter(groups);
        LinearLayout parent = new LinearLayout(context);

        //child view holder
        RecyclerView.ViewHolder childViewHolder = adapter.onCreateViewHolder(parent, ExpandableListPosition.CHILD);
        assertTrue(childViewHolder instanceof ArtistViewHolder);

        //group view holder
        RecyclerView.ViewHolder groupViewHolder = adapter.onCreateViewHolder(parent, ExpandableListPosition.GROUP);
        assertTrue(groupViewHolder instanceof GenreViewHolder);
    }

    @Test
    public void test_getItemCount() {
        GenreAdapter adapter = new GenreAdapter(groups);

        //initial state
        int initialExpected = 5;
        int initialActual = adapter.getItemCount();

        assertEquals(initialExpected, initialActual);
    }

    @Test
    public void test_getItemViewType() {
        GenreAdapter adapter = new GenreAdapter(groups);

        //initial state
        int initialExpected = ExpandableListPosition.GROUP;
        int initialActual = adapter.getItemViewType(3);

        assertEquals(initialExpected, initialActual);
    }
}