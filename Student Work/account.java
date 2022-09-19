import java.util.*;
import java.io.*;

public class account {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("bank"));
		double i = 0.02;
		double interest = 0;
		double total = 0;
		double ans = 0;
		int base = 0;
		ArrayList<Double> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String[] arr = str.split("-");
			String[] arr1 = str.split(" ");
			list1.add(Integer.parseInt(arr[1]));
			list.add(Double.parseDouble(arr1[1]));
		}
		base = list1.get(0);
		for (int j = 0; j < list.size(); j++) {
			total += list.get(j);
			if (list1.indexOf(j) != base) {
				total += (total * i) + (total * i);
				//interest = total * i;
				base = list1.indexOf(j);
			}
		}
		total += interest;                                                                                                                                                                                                                                                                                                                                                
		total *= 100;
		int x = (int) total;
		ans = x / 100.0;
		System.out.print("$" + ans);
	}

}
