import java.io.*;
import java.util.*;
public class peter {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("peter"));
	while(scan.hasNextInt()) {
		int total = scan.nextInt();
		int z = total;
		ArrayList<Integer> arr = new ArrayList<>();
		while(scan.hasNextInt()) {
		int a = scan.nextInt();
		if(a <= total) {
			arr.add(a);
		}
		else {
			break;
		}
		}
		ArrayList<Integer> arry = new ArrayList<>();
		int b = total;
		int count = 0;
		while(b >= 0) {
			for(int i = arr.size()-1; i >= 0; i--) {
				int x = b/ arr.get(i);
				int y = x;
				if(x > 0) {
					while(x > 0) {
						arry.add(arr.get(i));
						x--;
						count++;
					}
				}
				b = b - (y*arr.get(i));
			}
		}
		System.out.print(z + " " + count + " ");
		for(int i = 0; i < arry.size(); i++) {
			System.out.print(arry.get(i) + " ");
		}
		System.out.println();
	}
}
}
/*
 11
1 3 5
70
1 5 10 25 50 100
131
1 4 9 14 22 53
*/
