/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal
 * Date: 21-12-2020
 *
 * Description of program
 ********************************************/

package Main;

import java.util.ArrayList;

// EKSEMPEL Interface
public class RecipeArchive {

    // EKSEMPEL ArrayList
    private static ArrayList<Recipe> recipes = new ArrayList<>();

    public static void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public static void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    public static int catchRecipeIndex(String name) {

        int i;
        for (i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getName().equals(name)) { break; }
        }

        return i;
    }

    public static ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public static void setRecipes(ArrayList<Recipe> recipes) {
        RecipeArchive.recipes = recipes;
    }

}
