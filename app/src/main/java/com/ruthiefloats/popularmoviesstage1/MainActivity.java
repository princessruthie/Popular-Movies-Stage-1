package com.ruthiefloats.popularmoviesstage1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * The MainActivity by default populates with a list of the most popular movies.
 * <p/>
 * I based networking code off of the official example:
 * https://developer.android.com/training/basics/network-ops/connecting.html
 */
public class MainActivity extends AppCompatActivity {

    private static final String MASTER_FRAGMENT_TAG = "master frag tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MasterFragment(), MASTER_FRAGMENT_TAG)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Depending on the option selected, get which set of data
     *
     * @param item The menu item selected
     * @return always false
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MasterFragment fragment = (MasterFragment) getSupportFragmentManager().
                findFragmentByTag(MASTER_FRAGMENT_TAG);
        if (item.getItemId() == R.id.menu_sort_popularity) {
            fragment.getData(MasterFragment.POPULAR_RESOURCE_ROOT);
        } else if (item.getItemId() == R.id.menu_sort_rating) {
            fragment.getData(MasterFragment.TOP_RATED_RESOURCE_ROOT);
        }
        return false;
    }
}