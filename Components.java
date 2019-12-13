import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Components {

	/**
	 * "Recipe book"
	 */
	private static HashMap<String, ArrayList<String>> recipeMap = new HashMap<>();

	/**
	 * Holds ingredients of given items sorted by key.
	 */
	private static TreeMap<String, Integer> ingredients;

	/**
	 * Recursively get raw ingredients of given input
	 * 
	 * @param input the item to get the ingredients of
	 */
	private static void getIngredients(String input) {
		// If the input is a raw item, add it accordingly to the ingredients TreeMap
		if (recipeMap.get(input) == null) {
			if (ingredients.containsKey(input))
				ingredients.put(input, ingredients.get(input) + 1);
			else
				ingredients.put(input, 1);
			return;
		}

		// Otherwise, cycle through its ingredients and recursively get their
		// ingredients.
		ArrayList<String> currentIngredients = recipeMap.get(input);
		for (String ingredient : currentIngredients)
			getIngredients(ingredient);
	}

	/**
	 * Handle input according to problem specifications.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("components.dat"));
		int noRecipes = Integer.parseInt(scan.nextLine());

		// Construct recipe book.
		while (noRecipes-- > 0) {
			String[] nextLine = scan.nextLine().split("\\s+>>\\s+");
			String object = nextLine[0];
			ArrayList<String> ingredients = new ArrayList<>(Arrays.asList(nextLine[1].split(" ")));
			recipeMap.put(object, ingredients);
		}

		int noTestCases = Integer.parseInt(scan.nextLine());
		while (noTestCases-- > 0) {
			// Reset TreeMap of ingredients
			ingredients = new TreeMap<>();

			// Get ingredients
			getIngredients(scan.nextLine());

			// Print out results
			Set<String> keys = ingredients.keySet();
			keys.forEach(x -> {
				System.out.println(x + " " + ingredients.get(x));
			});

			System.out.println("***");
		}

		scan.close();

	}

}
