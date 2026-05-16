import java.util.ArrayList;

public class RecipeBook {
    private ArrayList<Recipe> recipes;

    public RecipeBook () {
        this.recipes = new ArrayList<>();
    }

    public void loadRecipes(String filePath) {
        FileReader fileReader = new FileReader(filePath);

        while (fileReader.hasNextLine()) {

            ArrayList<String> ingredients =
                new ArrayList<>();

            String title = fileReader.nextLine();

            int cookingTime =
                Integer.valueOf(fileReader.nextLine());

            String line = fileReader.nextLine();

            while (!line.isEmpty()) {

                ingredients.add(line);

                if (!fileReader.hasNextLine()) {
                    break;
                }

                line = fileReader.nextLine();
            }

            Recipe recipe =
                new Recipe(title, cookingTime, ingredients);

            recipes.add(recipe);
        }
    } 

    public void list() {
        System.out.println("-- Recipes:");
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }


    public ArrayList<Recipe> searchRecipe(String recipeName) {
        ArrayList<Recipe> recipesSearched = new ArrayList<>();
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getTitle().contains(recipeName)) {
                recipesSearched.add(recipes.get(i));
            }
        }
        return recipesSearched;
    }

    public ArrayList<Recipe> searchCookingTime(int cookingTime) {
        ArrayList<Recipe> recipesSearched = new ArrayList<>();
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getCookingTime() <= cookingTime) {
                recipesSearched.add(recipes.get(i));
            }
        }
        return recipesSearched;
    }

    public ArrayList<Recipe> searchIngredient(String ingredient) {
        ArrayList<Recipe> recipesSearched = new ArrayList<>();
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getIngredients().contains(ingredient)) {
                recipesSearched.add(recipes.get(i));
            }
        }
        return recipesSearched;
    }
}
