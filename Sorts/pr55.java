import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class pr55 {
	
	private static void process(String[] arr) {
		ArrayList<Integer> evens = new ArrayList<>();
		ArrayList<Integer> odds = new ArrayList<>();
		
		for(int i = 0;i<arr.length;i++) {
			if((i+1)%2==0)
				evens.add(Integer.parseInt(arr[i]));
			else
				odds.add(Integer.parseInt(arr[i]));
		}
		
		Collections.sort(odds);
		Collections.sort(evens, Collections.reverseOrder());
		
		odds.forEach(x->System.out.print(x+" "));
		System.out.print("^ ");
		evens.forEach(x->System.out.print(x+" "));
		

	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("pr55.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while(n-->0) {
			process(scan.nextLine().split(" "));
			System.out.println();
		}
		scan.close();

	}

}
