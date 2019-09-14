import java.util.*;
import java.io.*;

public class Cognates {

	private static int noOfCommonLetters(String first, String second) {
		ArrayList<Character> firstCharacters = new ArrayList<>();

		for (int i = 0; i < first.length(); i++) {
			firstCharacters.add(first.charAt(i));
		}

		int commonNo = 0;
		for (int i = 0; i < second.length(); i++) {
			if (firstCharacters.contains(second.charAt(i))) {
				firstCharacters.remove(new Character(second.charAt(i))); //new Character required to prevent char from being converted to integer
				commonNo++;
			}
		}
		
		return commonNo;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("cognates.dat"));
		int noDataSets = Integer.parseInt(scan.nextLine());

		while (noDataSets-- > 0) {
			System.out.println(noOfCommonLetters(scan.nextLine(), scan.nextLine()));
		}
		scan.close();
	}

}
