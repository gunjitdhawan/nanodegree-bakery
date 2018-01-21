package co.grappes.bakingnanodegree.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.FoodItem;

/**
 * Created by gunjit on 20/01/18.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private final FoodItemListActivity mParentActivity;
    private final List<FoodItem> mValues;
    private final boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FoodItem item = (FoodItem) view.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putParcelable("foodItem", item);
                FoodItemDetailFragment fragment = new FoodItemDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fooditem_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, FoodItemDetailActivity.class);
                intent.putExtra("foodItem", item);

                context.startActivity(intent);
            }
        }
    };

    public FoodAdapter(FoodItemListActivity parent,
                                  List<FoodItem> items,
                                  boolean twoPane) {
        mValues = items;
        mParentActivity = parent;
        mTwoPane = twoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fooditem_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(mValues.get(position).image!=null &&mValues.get(position).image.length()>0) {
            Glide.with(mParentActivity).load(mValues.get(position).image).into(holder.thumbnailImage);
        }
        else
        {
            holder.thumbnailImage.setImageResource(R.drawable.default_thumbnail);
        }
        holder.titleView.setText(mValues.get(position).name);
        holder.servingTextView.setText("Servings : "+mValues.get(position).servings);
        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView thumbnailImage;
        final TextView titleView, servingTextView;

        ViewHolder(View view) {
            super(view);
            thumbnailImage = (ImageView) view.findViewById(R.id.thumbnail);
            titleView = (TextView) view.findViewById(R.id.title);
            servingTextView = view.findViewById(R.id.serving);
        }
    }
}