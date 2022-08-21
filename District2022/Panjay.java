/*5
Alex,Brent,Chris,Dave,Eric,Fred
Alex<->Chris,Alex<->Eric,Brent<->Dave,Brent<->Fred,Chris<->Eric,Dave<->Fred
Alex,Brent,Chris,Dave,Eric,Fred
Alex<->Chris,Alex<->Eric
Alex,Brent,Chris,Dave,Eric,Fred
Alex<->Brent,Brent<->Chris,Chris<->Dave,Dave<->Eric,Eric<->Fred,Fred<->Alex
Alex,Brent,Chris,Dave,Eric,Fred
Alex<->Brent,Alex<->Chris,Alex<->Dave,Alex<->Eric,Alex<->Fred
Alex,Brent,Chris,Dave,Eric,Fred
Alex<->Brent,Alex<->Chris,Alex<->Dave,Alex<->Eric,Alex<->Fred,Brent<->Chris
*/
import java.io.*;
import java.util.*;

public class Panjay {

	static boolean good(List<String> left, List<String> right, Map<String, List<String>> map) {
		for (String l : left) {
			if (map.get(l) != null)
				for (String s : map.get(l))
					if (left.contains(s))
						return false;

		}
		for (String l : right) {
			if (map.get(l) != null)
				for (String s : map.get(l))
					if (right.contains(s))
						return false;

		}
		//System.out.println(map);
		//System.out.println(left);
		//System.out.println(right);
		return true;
	}

	public static void main(String... args) throws IOException {

		Scanner scan = new Scanner(new File("panjay.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		int testCase = 1;
		while (noSets-- > 0) {
			
			List<String> list = Arrays.asList(scan.nextLine().split(","));
			//System.out.println("list "+list);
			String[] haters = scan.nextLine().split(",|<->");
			//System.out.println(Arrays.toString(haters));
			Map<String, List<String>> map = new HashMap<>();
			for (int i = 0; i < haters.length; i += 2) {
				map.putIfAbsent(haters[i], new ArrayList<String>());
				map.get(haters[i]).add(haters[i + 1]);
				map.put(haters[i], map.get(haters[i]));
				map.putIfAbsent(haters[i + 1], new ArrayList<String>());
				map.get(haters[i + 1]).add(haters[i]);

			}
			//System.out.println(map);
			boolean ans = false;
			lab: for (int i = 0; i < 1 << list.size(); i++) {
				List<String> right = new ArrayList<>();
				List<String> left = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					if ((i >> j & 1) == 1)
						right.add(list.get(j));
					else
						left.add(list.get(j));

				}
				if (good(right, left, map)) {
					ans = true;
					break lab;
				}

			}
		
			System.out.println("Test Case "+(testCase++) +": "+ (ans?"possible":
				"impossible"));
		}

	}
}
