package co.grappes.bakingnanodegree.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import java.util.ArrayList;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.FoodItem;
import co.grappes.bakingnanodegree.model.Ingredients;
import co.grappes.bakingnanodegree.utils.AppUtils;

/**
 * An activity representing a single FoodItem detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link FoodItemListActivity}.
 */
public class FoodItemDetailActivity extends AppCompatActivity {

    SimpleExoPlayerView exoPlayerView;
    SimpleExoPlayer exoPlayer;
    FoodItem foodItem;
    AppBarLayout appBarLayout;
    NestedScrollView nestedScrollView;
    ProgressBar loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooditem_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        toolbar.setTitle("");
        loadingBar = findViewById(R.id.loading_bar);
        nestedScrollView = findViewById(R.id.fooditem_detail_container);
        setSupportActionBar(toolbar);
        appBarLayout = findViewById(R.id.app_bar);
        exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exo_player_view);
        appBarLayout.getLayoutParams().height = (int) ((720* AppUtils.getWidth(FoodItemDetailActivity.this))/(1280*1.0f));
        exoPlayerView.getLayoutParams().height = (int) ((720* AppUtils.getWidth(FoodItemDetailActivity.this))/(1280*1.0f));
        appBarLayout.requestLayout();
        exoPlayerView.requestLayout();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(foodItem!=null) {
                    showIngredientsInPopup(foodItem.ingredients);
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {

            foodItem = getIntent().getParcelableExtra("foodItem");

            Bundle arguments = new Bundle();
            arguments.putParcelable("foodItem", foodItem);
            FoodItemDetailFragment fragment = new FoodItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fooditem_detail_container, fragment)
                    .commit();
            if(foodItem!=null && foodItem.steps.get(0).videoURL!=null && foodItem.steps.get(0).videoURL.length()>0) {
                playVideo(foodItem.steps.get(0).videoURL);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, FoodItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showIngredientsInPopup(ArrayList<Ingredients> ingredients) {
        AlertDialog.Builder builder = new AlertDialog.Builder(FoodItemDetailActivity.this);
        builder.setMessage(getIngredientsString(ingredients));

        AlertDialog alert = builder.create();
        alert.setTitle("Ingredients");
        alert.show();

    }

    private String getIngredientsString(ArrayList<Ingredients> ingredients) {
        String string="";
        for(Ingredients ingredient : ingredients)
        {
            string +=ingredient.toString()+"\n\n";
        }
        return string;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(exoPlayer!=null)
        {
            exoPlayer.release();
            exoPlayer = null;
        }
    }

    public void playVideo(String videoUrl)
    {
        try {

            if(exoPlayer!=null)
            {
                exoPlayer.release();
                exoPlayer = null;
            }
            loadingBar.setVisibility(View.VISIBLE);
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

            Uri videoURI = Uri.parse(videoUrl);

            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);
            exoPlayer.addListener(new Player.EventListener() {
                @Override
                public void onTimelineChanged(Timeline timeline, Object manifest) {

                }

                @Override
                public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

                }

                @Override
                public void onLoadingChanged(boolean isLoading) {

                }

                @Override
                public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                    if(playbackState==Player.STATE_READY)
                    {
                        loadingBar.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onRepeatModeChanged(int repeatMode) {

                }

                @Override
                public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

                }

                @Override
                public void onPlayerError(ExoPlaybackException error) {
                    loadingBar.setVisibility(View.GONE);
                }

                @Override
                public void onPositionDiscontinuity(int reason) {

                }

                @Override
                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

                }

                @Override
                public void onSeekProcessed() {

                }
            });

            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(true);
            appBarLayout.setExpanded(true, true);
        }catch (Exception e){
            Log.e("MainAcvtivity"," exoplayer error "+ e.toString());
        }

    }
}
