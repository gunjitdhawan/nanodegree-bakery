package co.grappes.bakingnanodegree.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.Step;

/**
 * Created by gunjit on 21/01/18.
 */

class FoodStepAdapter extends RecyclerView.Adapter<FoodStepAdapter.ViewHolder> {
    ArrayList<Step> steps;
    FoodItemDetailActivity foodItemDetailActivity;
    public FoodStepAdapter(Activity activity, ArrayList<Step> steps) {
        foodItemDetailActivity = (FoodItemDetailActivity) activity;
        this.steps = steps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fooditem_steps_content, parent, false);
        return new FoodStepAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.shortDescription.setText(steps.get(position).shortDescription);
        holder.description.setText(steps.get(position).description);
        if(steps.get(position).thumbnailURL!=null && steps.get(position).thumbnailURL.length()>0) {
            Glide.with(foodItemDetailActivity).load(steps.get(position).thumbnailURL).into(holder.thumbnail);
        }
        else
        {
            holder.thumbnail.setImageResource(R.drawable.default_thumbnail);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(steps.get(position).videoURL!=null && steps.get(position).videoURL.length()>0)
                {
                    foodItemDetailActivity.playVideo(steps.get(position).videoURL);
                }
                else
                {
                    Toast.makeText(foodItemDetailActivity, R.string.no_video, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        TextView shortDescription;
        ImageView thumbnail;
        public ViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            shortDescription = itemView.findViewById(R.id.short_description);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
