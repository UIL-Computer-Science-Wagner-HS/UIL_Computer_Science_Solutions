import java.io.*;
import java.util.*;

public class Kristina {
	static int pre(String[] arr) {
		int ans = 0;
		// Queue<Integer> ops =
		Stack<Integer> nums = new Stack<>();
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i].matches(".*[0-9]"))
				nums.push(Integer.parseInt(arr[i]));
			else {
				if (arr[i].equals("+")) {
					int n1 = nums.pop();
					int n2 = nums.pop();
					nums.push(n1 + n2);
				} else if (arr[i].equals("-")) {
					int n1 = nums.pop();
					int n2 = nums.pop();
					nums.push(n1 - n2);
				} else if (arr[i].equals("*")) {
					int n1 = nums.pop();
					int n2 = nums.pop();
					nums.push(n1 * n2);

				} else if (arr[i].equals("/")) {
					int n1 = nums.pop();
					int n2 = nums.pop();
					nums.push(n1 / n2);

				}
				else if (arr[i].equals("^")) {
					int n1 = nums.pop();
					int n2 = nums.pop();
					nums.push((int) Math.pow(n1, n2));

				}

			}
		}
		return nums.pop();
	}
	static int post(String [] arr) {
		
			int ans = 0;
			// Queue<Integer> ops =
			Stack<Integer> nums = new Stack<>();
			for (int i =  1; i <arr.length; i++) {
				if (arr[i].matches(".*[0-9]"))
					nums.push(Integer.parseInt(arr[i]));
				else {
					if (arr[i].equals("+")) {
						int n1 = nums.pop();
						int n2 = nums.pop();
						nums.push(n1 + n2);
					} else if (arr[i].equals("-")) {
						int n1 = nums.pop();
						int n2 = nums.pop();
						nums.push(n2 - n1);
					} else if (arr[i].equals("*")) {
						int n1 = nums.pop();
						int n2 = nums.pop();
						nums.push(n1 * n2);

					} else if (arr[i].equals("/")) {
						int n1 = nums.pop();
						int n2 = nums.pop();
						nums.push(n2 / n1);

					}
					else if (arr[i].equals("^")) {
						int n1 = nums.pop();
						int n2 = nums.pop();
						nums.push((int) Math.pow(n2, n1));

					}

				}
			}
			return nums.pop();
		
		
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("kristina.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String[] arr = scan.nextLine().split(" ");
			if (arr[0].equals("PRE"))
				System.out.println(pre(arr));
			else System.out.println(post(arr));

		}
	}

}