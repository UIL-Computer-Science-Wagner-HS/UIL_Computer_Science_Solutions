package noInputStandard;

import java.util.ArrayList;
import java.util.Arrays;

public class pr10 {
	public static void main(String[] args) {
		// ArrayList to hold state names
		ArrayList<String> list = new ArrayList<>(Arrays.asList("ALASKA", "TEXAS", "NEW MEXICO", "OKLAHOMA", "FLORIDA"));

		// Iterate through states and print each one out on a separate line.
		for (String a : list)
			System.out.println(a);
	}
}
