package co.grappes.bakingnanodegree.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.FoodItem;
import co.grappes.bakingnanodegree.presenter.FoodPresenter;

public class FoodItemListActivity extends AppCompatActivity {

    ArrayList<FoodItem> foodItems = new ArrayList<>();
    View recyclerView;
    FloatingActionButton fab;
    Toolbar toolbar;
    FoodAdapter foodAdapter;
    private boolean mTwoPane;
    ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooditem_list);

        setViews();
        initViews();
        getRecipes();
    }

    private void setViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = findViewById(R.id.fooditem_list);
        loadingBar = findViewById(R.id.loading_bar);
    }

    private void initViews() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        foodAdapter = new FoodAdapter(this, foodItems, mTwoPane);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Refreshing...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                getRecipes();
            }
        });

        if (findViewById(R.id.fooditem_detail_container) != null) {
            mTwoPane = true;
        }

        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void getRecipes() {

        loadingBar.setVisibility(View.VISIBLE);

        new FoodPresenter().getRecipes(FoodItemListActivity.this, new FoodPresenter.GetRecipesInterface() {
            @Override
            public void onGetRecipesSuccess(ArrayList<FoodItem> foodItems) {
                loadingBar.setVisibility(View.GONE);
                FoodItemListActivity.this.foodItems.clear();
                FoodItemListActivity.this.foodItems.addAll(foodItems);
                foodAdapter.notifyDataSetChanged();
            }

            @Override
            public void onGetRecipesFailure(String message) {
                loadingBar.setVisibility(View.GONE);
                Toast.makeText(FoodItemListActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(foodAdapter);
    }
}
