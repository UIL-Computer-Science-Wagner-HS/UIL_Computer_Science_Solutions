import java.util.*;
import java.io.*;

public class pr57 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("pr57.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		int index = 0;
		List<String[]> names = new ArrayList<String[]>();
		while (n-- > 0)
		{
			names.add(scan.nextLine().split(" "));
			String[] current = names.get(index);
			if (current.length == 3)
			{
				String[] lastFirst = {current[2], current[0] + " " + current[1]};
				names.remove(index);
				names.add(index, lastFirst);
			}
			else
			{
				String temp = current[0];
				current[0] = current[1];
				current[1] = temp;
			}
			index++;
		}
		List<String> fullNames = new ArrayList<String>();
		for (String[] s: names)
		{
			fullNames.add(s[0] + ", " + s[1]);
		}
		Collections.sort(fullNames);
		for (String s: fullNames)
		{
			System.out.println(s);
		}
	}
}
