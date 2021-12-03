import java.io.*;
import java.util.*;

public class Krill {
	static List<Integer> list = new ArrayList();// contains all y +SOD y up to 5,000,000

	static int sod(int n) {
		int sum = 0;
		int n1 = n;
		while (n1 > 0) {
			sum += n1 % 10;
			n1 /= 10;

		}
		return sum + n;

	}

	static int find(int check) {
		while (check > 0) {
			if (!list.contains(check))
				return check;
			check--;
		}
		return 0;

	}
	//faster way
	static int altFind(int check) {
		while(check>0) {
			if(Collections.binarySearch(list, check)<0)
				return check;
			check--;
			
			
		}
		return 0;
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("krill.dat"));
		int n = scan.nextInt();
		for (int i = 1; i <= 5000000; i++)
			list.add(sod(i));
		int cNum = 1;
		while (n-- > 0) {
			int check = scan.nextInt();
			int ans = find(check);
			System.out.println("Case #"+cNum++ + ": "+ans);

		}

	}
}
