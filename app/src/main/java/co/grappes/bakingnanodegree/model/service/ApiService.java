package co.grappes.bakingnanodegree.model.service;

import java.util.ArrayList;

import co.grappes.bakingnanodegree.model.FoodItem;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gunjit on 21/01/18.
 */

public interface ApiService {
    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<ArrayList<FoodItem>> getFoodItems();
}
