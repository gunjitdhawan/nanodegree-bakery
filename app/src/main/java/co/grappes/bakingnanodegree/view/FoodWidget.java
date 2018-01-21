package co.grappes.bakingnanodegree.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.text.Html;
import android.widget.RemoteViews;

import java.util.ArrayList;

import co.grappes.bakingnanodegree.R;
import co.grappes.bakingnanodegree.model.FoodItem;
import co.grappes.bakingnanodegree.presenter.FoodPresenter;

/**
 * Created by gunjit on 20/01/18.
 */

public class FoodWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                 int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        // In widget we are not allowing to use intents as usually. We have to use PendingIntent instead of 'startActivity'
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, null, 0);
        // Here the basic operations the remote view can do.
        setWidgetData(context, appWidgetManager, appWidgetId, views, pendingIntent);
    }

    private void setWidgetData(Context context, final AppWidgetManager appWidgetManager, final int appWidgetId, final RemoteViews views, PendingIntent pendingIntent) {
        new FoodPresenter().getRecipes(context, new FoodPresenter.GetRecipesInterface() {
            @Override
            public void onGetRecipesSuccess(ArrayList<FoodItem> foodItems) {
                views.setTextViewText(R.id.tv_title, foodItems.get(0).name);
                views.setTextViewText(R.id.tv_description, Html.fromHtml(foodItems.get(0).ingredients.toString()));
                // Instruct the widget manager to update the widget
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }

            @Override
            public void onGetRecipesFailure(String message) {

            }
        });
    }

}