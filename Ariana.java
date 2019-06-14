/**
 * 
 */
package region2018;

/**
 * Ariana.java | Input: None | UIL Region 2018
 * 
 * @author Ian Fernandes
 *
 */
public class Ariana {

	/**
	 * Prints the same String 40 times, but with different variations. First, the
	 * first word is upper-cased. Then, the next one is and so on Once the last word
	 * has been upper-cased, the pattern reverses, and the second last one is
	 * upper-cased.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean reversed = false;
		int index = 0;
		String[] arr = { "i ", "must ", "not ", "tell ", "lies." };

		for (int i = 0; i < 40; i++) {
			System.out.printf("%-3d", i + 1);
			for (int j = 0; j < arr.length; j++) {
				if (j == index)
					System.out.print(arr[j].toUpperCase());
				else
					System.out.print(arr[j]);
			}
			System.out.println();

			if (index == arr.length - 1)
				reversed = true;

			if (index == 0)
				reversed = false;

			if (reversed)
				index--;
			else
				index++;
		}

	}

}
