import java.util.ArrayList;

public class Recipe {
    private String title;
    private int cookingTime;
    private ArrayList<String> ingredients;

    public Recipe(String title, int cookingTime, ArrayList<String> ingredients) {
        this.title = title;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    public String toString() {
        return this.title + ", cooking time: " + this.cookingTime; 
    }
}
