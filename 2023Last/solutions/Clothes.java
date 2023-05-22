import java.io.*;
import java.util.*;

public class Clothes {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("clothes.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0) {
			//System.out.println(noSets);
			String str = scan.nextLine();
			str = str.replaceAll("[^0-9]", " ");
			//System.out.println(str);
			String[] arr = str.trim().split("\\s+");
			int sum = 0;
			//System.out.println(Arrays.toString(arr));
			for(String s: arr) {
				sum+=Integer.parseInt(s);
			}
			System.out.println(sum);
		}
	}

}
