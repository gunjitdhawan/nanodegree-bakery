package co.grappes.bakingnanodegree.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.FoodItem;

public class FoodItemDetailFragment extends Fragment {

    FoodItem foodItem;
    public static final String ARG_ITEM_ID = "item_id";

    public FoodItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments()!=null) {
            foodItem = getArguments().getParcelable("foodItem");

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                //appBarLayout.setTitle(foodItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fooditem_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (foodItem != null) {
            ((TextView) rootView.findViewById(R.id.fooditem_detail)).setText(Html.fromHtml(foodItem.description));
        }

        return rootView;
    }
}
