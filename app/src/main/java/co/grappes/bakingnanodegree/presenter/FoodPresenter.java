package co.grappes.bakingnanodegree.presenter;

import java.util.ArrayList;

import co.grappes.bakingnanodegree.model.FoodItem;

/**
 * Created by gunjit on 20/01/18.
 */

public class FoodPresenter {

    public void getRecipes(GetRecipesInterface getRecipesInterface)
    {
        //make network calls and get data
        //Since no api was provided in project rubric i'm sending local data

        ArrayList<FoodItem> foodItems = new ArrayList<>();

        FoodItem recipe1 = new FoodItem("Aalu Snacks Recipe", 1, "<b>How to Make Dilli Ki Fried Aloo Chaat<b><br><br>1.Deep fry the boiled potatoes until golden and crisp, drain excess oil on absorbent kitchen paper and put them into a bowl.<br><br>2.Add the chopped onion, green chilly and coriander leaves. Then add the tamarind and mint chutney.<br><br>3.Squeeze in the lime juice, add the chaat masala, spring onion and season with salt.<br><br>4.Mix everything together nicely to combine.<br><br>5.Serve hot or warm in small bowls.", "http://i.ytimg.com/vi/6_eY1HRnXuk/hqdefault.jpg", "https://ndtvod.bc-ssl.cdn.bitgravity.com/23372/ndtv/MYTS3EP01KADHAIPANEER_48945.mp4");
        FoodItem recipe2 = new FoodItem("Paneer Masala Recipe", 2, "<b>How to Make Matar Paneer Masala<b><br><br>\n" +
                "<b>For Boiling Peas:<b><br><br>\n" +
                "<br><br>1.In a bowl of boiling water add peas to soften them.Matar Paneer Masala<br><br>2.Make sure the peas swell up a little after boiling. Check whether they are boiled and turn off the flame.Matar Paneer Masala\n" +
                "<b>For Boiling Onions:<b>\n" +
                "<br><br>1.Boil long chopped onions in water for better grinding.Matar Paneer Masala<br><br>2.Onions become white after getting boiled and puff up a little.Matar Paneer Masala<br><br>3.Turn off the flame and grind it to a fine paste after letting it cool for some time.\n" +
                "<b>For Frying Paneer Cubes:<b>\n" +
                "<br><br>1.Heat oil in a pan and deep fry the paneer cubes until golden brown. Fry on high flame but do not burn.Matar Paneer Masala\n" +
                "<b>Prepare the Gravy:<b>\n" +
                "<br><br>1.In a heavy bottomed pan heat a tablespoon of oil and add bay leaves and cumin seeds.Matar Paneer Masala<br><br>2.When they crackle add ginger garlic paste and onion paste. Mix well and cook for a minute.Matar Paneer Masala<br><br>3.Now add the spices such as salt, turmeric powder, coriander powder and red chilli powder. Put the chopped green chilli and mix thoroughly to combine the masalas well.Matar Paneer Masala<br><br>4.Cook until oil starts separating spices and releases aroma.<br><br>5.Now add the tomato puree and cook on medium flame for thorough mixing of ingredients.Matar Paneer Masala<br><br>6.When it starts releasing oil, add coriander leaves and mix.Matar Paneer Masala<br><br>7.Then add water and garam masala. Stir and cook for few more minutes until the water evaporates.Matar Paneer Masala<br><br>8.Now add peas and fried paneer to it. Stir with light hands and coat them well with the gravy.Matar Paneer Masala<br><br>9.After thorough cooking transfer the prepared dish in a serving bowl and garnish with fresh coriander leaves. Serve hot.Matar Paneer Masala", "http://i.ytimg.com/vi/YCR95wu1-ng/hqdefault.jpg", "https://ndtvod.bc-ssl.cdn.bitgravity.com/23372/ndtv/MYTS3EP03PIYUSH_48943.mp4");
        FoodItem recipe3 = new FoodItem("Corn and Miso Soup Recipe", 3, "How to Make Corn and Miso Soup<br><br>1.In a medium pot, add corn and creamed corn kernels and add 02 cups of vegetable stock, add more of the stock if require.<br><br>2.Bring to a boil, simmer until stock is infused with corn flavor, for about ½ an hour.<br><br>3.Heat butter in a non-stick pan. Sauté onion until translucent, about 3 minutes.<br><br>4.Add miso and ½ cup corn stock and stir to dissolve miso.<br><br>5.Add corn kernels and another ½ cup corn stock and cook until corn cooked through, about 02 minutes. Set aside and let it cool.<br><br>6.Blend till smooth. Add stock. Strain soup through a fine-mesh soup strainer, back into pot, season it with salt and pepper. Simmer for 02 minutes.<br><br>7.Pour the soup into 04 bowls and drizzle with chili oil.<br><br>8.Serve hot.", "http://i.ytimg.com/vi/U7C63FjeOJY/hqdefault.jpg", "https://ndtvod.bc-ssl.cdn.bitgravity.com/23372/ndtv/SouthIndianFood_New_48850.mp4");
        FoodItem recipe4 = new FoodItem("Hot Chocolate Recipe", 4, "How to Make Hot Chocolate<br><br>1.Boil milk in a deep bowl, add chocolate to it. Stir well.Hot Chocolate<br><br>2.Now put cinnamon stick, vanilla stick and powdered sugar along with cocoa powder.Hot Chocolate<br><br>3.Stir well to mix thoroughly and pour hot in a cup.Hot Chocolate<br><br>4.Serve hot with heavy topping of whipped cream and chocolate powder garnishing.", "http://i.ytimg.com/vi/04kgyIxAgbI/hqdefault.jpg", "https://ndtvod.bc-ssl.cdn.bitgravity.com/23372/ndtv/ChocolateMuffin_New_48920.mp4");
        FoodItem recipe5 = new FoodItem("Green Pea Upma Recipe", 5, "How to Make Green Pea Upma<br><br>1.Heat oil in a heavy bottomed pan add mustard seeds, let them crackle.<br><br>2.Add curry leaves and grated ginger, sauté till the raw aroma of ginger disappears.<br><br>3.Now add finely chopped onion, sauté till translucent, add green chillies, sauté for 02 minutes.<br><br>4.Now add the lightly roasted semolina, add the green peas, sauté for 02 minutes add the hot water.<br><br>5.Add the salt to taste. Stir, to prevent lump formation.<br><br>6.Now cover it and cook on a very slow fame. Cook till all the water is absorbed and semolina and green peas are cooked.<br><br>7.Serve hot garnished with Chopped Coriander leaves or grated fresh coconut.", "http://i.ytimg.com/vi/lfgeF8jn_eM/hqdefault.jpg", "https://ndtvod.bc-ssl.cdn.bitgravity.com/23372/ndtv/hyderabadibiryani_48629.mp4");

        foodItems.add(recipe1);
        foodItems.add(recipe2);
        foodItems.add(recipe3);
        foodItems.add(recipe4);
        foodItems.add(recipe5);

        getRecipesInterface.onGetRecipesSuccess(foodItems);

    }

    public interface GetRecipesInterface
    {
        void onGetRecipesSuccess(ArrayList<FoodItem> foodItems);
        void onGetRecipesFailure(String message);
    }
}
