import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println();
        System.out.println("-- Commands:");
        System.out.println("list - Lists the recipes");
        System.out.println("find name - Searches recipes by name");
        System.out.println("find cooking time - Searches recipe by cooking time");
        System.out.println("find ingredient - Searches recipes by ingredient");
        System.out.println("stop - Stop the program");
        System.out.println();
    }

    public void start() {
        System.out.print("File to read: ");
        String filePath = scanner.nextLine();
        
        RecipeBook recipes = new RecipeBook();
        recipes.loadRecipes(filePath);

        while (true) {
            printMenu();
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "list" :
                    System.out.println();
                    System.out.println("----------------");
                    recipes.list();
                    System.out.println("----------------");
                    break;
                case "stop" :
                    return;
                case "find name" :
                    System.out.println();
                    System.out.print("Searched word: ");
                    String word = scanner.nextLine();
                    System.out.println("----------------");
                    System.out.println("   Recipes with the word \"" + word + "\": ");
                    for (Recipe recipe:recipes.searchRecipe(word)) {
                        System.out.println(recipe);
                    }
                    System.out.println("----------------");
                    break;
                case "find cooking time" :
                    System.out.println();
                    System.out.print("Max cooking time: ");
                    int cookingTime = Integer.parseInt(scanner.nextLine());
                    System.out.println("----------------");
                    System.out.println("   Recipes with max cooking time of " + cookingTime + ":");
                    for (Recipe recipe:recipes.searchCookingTime(cookingTime)) {
                        System.out.println(recipe);
                    }
                    System.out.println("----------------");
                    break;
                case "find ingredient" :
                    System.out.println();
                    System.out.print("Ingredient: ");
                    String ingredient = scanner.nextLine();
                    System.out.println("----------------");
                    System.out.println("   Recipes with the ingredient " + ingredient + ":");
                    for (Recipe recipe:recipes.searchIngredient(ingredient)) {
                        System.out.println(recipe);
                    }
                    System.out.println("----------------");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid command.");
                    
            }
        }
    }
}
