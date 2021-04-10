import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class XOR {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("xor.dat"));
		int numTestCases = Integer.parseInt(scan.nextLine());
		while(numTestCases-->0) {
			scan.nextLine();
			String[] nextLine = scan.nextLine().split(" ");
			ArrayList<Integer> numbers = new ArrayList<>();
			for(String element: nextLine)
				numbers.add(Integer.parseInt(element));
			int xor = numbers.get(0);
			for(int i = 1; i<numbers.size(); i++)
				xor ^= numbers.get(i);
			System.out.println(xor);
		}
	}
}
