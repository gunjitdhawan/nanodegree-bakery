package co.grappes.bakingnanodegree.model.service;

import co.grappes.bakingnanodegree.utils.RetrofitClient;

/**
 * Created by gunjit on 21/01/18.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net";

    public static ApiService getFoodService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}