package co.grappes.bakingnanodegree.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.FoodItem;

public class FoodItemDetailFragment extends Fragment {

    FoodItem foodItem;
    RecyclerView recyclerView;

    public FoodItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments()!=null) {
            foodItem = getArguments().getParcelable("foodItem");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fooditem_detail, container, false);

        setViews(rootView);
        initViews();
        return rootView;
    }

    private void initViews() {
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    private void setViews(View rootView) {
        recyclerView = rootView.findViewById(R.id.fooditem_details);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        if(foodItem!=null) {
            recyclerView.setAdapter(new FoodStepAdapter(getActivity(), foodItem.steps));
        }
    }
}
