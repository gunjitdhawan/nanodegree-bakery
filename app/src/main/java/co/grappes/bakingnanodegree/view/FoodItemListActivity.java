package co.grappes.bakingnanodegree.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
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
    private boolean mTwoPane;

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
    }

    private void initViews() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.fooditem_detail_container) != null) {
            mTwoPane = true;
        }

        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void getRecipes() {
        new FoodPresenter().getRecipes(new FoodPresenter.GetRecipesInterface() {
            @Override
            public void onGetRecipesSuccess(ArrayList<FoodItem> foodItems) {
                FoodItemListActivity.this.foodItems.addAll(foodItems);
            }

            @Override
            public void onGetRecipesFailure(String message) {
                Toast.makeText(FoodItemListActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_LONG);
            }
        });
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new FoodAdapter(this, foodItems, mTwoPane));
    }
}
