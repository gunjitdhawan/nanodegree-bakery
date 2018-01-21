package co.grappes.bakingnanodegree.presenter;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.FoodItem;
import co.grappes.bakingnanodegree.model.service.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gunjit on 20/01/18.
 */

public class FoodPresenter {

    public void getRecipes(final Context context, final GetRecipesInterface getRecipesInterface)
    {
        //make network calls and get data
        Log.e("-----", "1");
        ApiUtils.getFoodService().getFoodItems().enqueue(new Callback<ArrayList<FoodItem>>() {
            @Override
            public void onResponse(Call<ArrayList<FoodItem>> call, Response<ArrayList<FoodItem>> response) {
                if(response.isSuccessful()) {
                    Log.e("-----", "2");
                    getRecipesInterface.onGetRecipesSuccess(response.body());

                }else {
                    Log.e("-----", "3");
                    int statusCode  = response.code();
                    getRecipesInterface.onGetRecipesFailure(""+statusCode);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FoodItem>> call, Throwable t) {
                if(t!=null)
                {
                    Log.e("-----", "4");
                    getRecipesInterface.onGetRecipesFailure(""+t.getMessage());
                    return;
                }
                Log.e("-----", "5");
                getRecipesInterface.onGetRecipesFailure(context.getResources().getString(R.string.server_error));
            }
        });

    }

    public interface GetRecipesInterface
    {
        void onGetRecipesSuccess(ArrayList<FoodItem> foodItems);
        void onGetRecipesFailure(String message);
    }
}
