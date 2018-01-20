package co.grappes.bakingnanodegree;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by gunjit on 20/01/18.
 */

public class AppUtils {

    public static int getWidth(Activity context)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        return displayMetrics.widthPixels;
    }
}
