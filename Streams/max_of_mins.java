import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 *
 */
public class max_of_mins {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("max_of_mins.dat"));
		List<Integer> minimumValues = new ArrayList<>();
		
		while(scan.hasNextLine()) {
			String[] nextLine = scan.nextLine().split(",");
			minimumValues.add(Arrays.stream(nextLine).mapToInt(x->Integer.parseInt(x)).min().getAsInt());
		}
		
		System.out.println(Collections.max(minimumValues));
		
		scan.close();
	}

}
