import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = new Scanner(System.in);;
    }

    public void start() {
        System.out.println("File to read: ");
        String filePath = scanner.nextLine();
        
        RecipeBook recipes = new RecipeBook();
        recipes.loadRecipes(filePath);

        FileReader fileReader = new FileReader(filePath);

        while (true) {
            System.out.println("Commands:");
            System.out.println("list - Lists the recipes");
            System.out.println("stop - Stop the program");
            System.out.println("find name - searches recipes by name");
            System.out.println("find cooking time - searches recipe by cooking time");
            System.out.println("find ingredient - seaches recipes by ingredient");

            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "list" :
                    recipes.list();
                    break;
                case "stop" :
                    return;
                case "find name" :
                    System.out.print("Seached word: ");
                    String word = scanner.nextLine();
                    for (Recipe recipe:recipes.searchRecipe(word)) {
                        System.out.println(recipe);
                    }
                    break;
                case "find cooking time" :
                    System.out.println("Max cooking time: ");
                    int cookingTime = Integer.valueOf(scanner.nextLine());
                    for (Recipe recipe:recipes.searchCookingTime(cookingTime)) {
                        System.out.println(recipe);
                    }
                    break;
                case "find ingredient" :
                    System.out.println("Ingredient: ");
                    String ingredient = scanner.nextLine();
                    for (Recipe recipe:recipes.searchIngredient(ingredient)) {
                        System.out.println(recipe);
                    }
                    break;
                default:
                    System.out.println("Invalid command.");
                    
            }
        }
    }
}
