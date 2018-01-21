package co.grappes.bakingnanodegree;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.grappes.bakingnanodegree.view.FoodItemDetailActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by gunjit on 21/01/18.
 */

@RunWith(AndroidJUnit4.class)
public class IngredientFabTest {

    @Rule
    public ActivityTestRule<FoodItemDetailActivity> mActivityRule =
            new ActivityTestRule<>(FoodItemDetailActivity.class);

    @Test
    public void changeText_newActivity() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.fooditem_detail_container)).perform(ViewActions.swipeUp());
    }
}
