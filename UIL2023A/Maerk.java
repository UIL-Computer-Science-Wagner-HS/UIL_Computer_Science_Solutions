import java.io.*;
import java.util.*;

public class Maerk {
	static int precedence(char c) {
		if (c == '*' || c == '/')
			return 2;
		return 1;
	}

	static String pf(String[] arr) {
		String ans = "";
		Stack<String> ops = new Stack<>();

		for (String s : arr) {

			if (s.equals("(")) {
				ops.push(s);
				
			}

			else if (s.equals(")")) {
				
				while (!ops.isEmpty() && !ops.peek().equals("("))
					ans += ops.pop() + " ";
				if (!ops.isEmpty()) {
					ops.pop();
				}
			} else if ("/*+-".indexOf(s) >= 0) {
				while (!ops.isEmpty() && (precedence(ops.peek().charAt(0))) >= precedence(s.charAt(0))
						&& !ops.peek().equals("("))
					ans += ops.pop() + " ";

				ops.push(s);

			}

			else if (s.matches("\\d+")) {
				ans += s + " ";

			}

		}
		while (!ops.isEmpty())
			ans += ops.pop() + " ";
		return ans;
	}

	static String compute(String str) {
		//System.out.println("String " + str);
		int ans = 0;
		String[] arr = str.trim().split(" ");
		Stack<Integer> stack = new Stack<>();
		for (String s : arr) {
			if (s.matches("\\d+"))
				stack.push(Integer.parseInt(s));
			else {
				stack.push(ops(stack.pop(), stack.pop(), s));

			}

		}
		return stack.pop() + "";
	}

	static int ops(int a, int b, String op) {
		try {
			switch (op) {
			case "+" -> {
				return a + b;
			}
			case "-" -> {
				return b - a;
			}
			case "*" -> {
				return a * b;
			}
			case "/" -> {
				return b / a;
			}

			}
		} catch (Exception e) {
			return -1000000;
		}
		return 0;

	}

	public static void main(String... args) throws IOException {

		Scanner scan = new Scanner(new File("maerk.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String inp1 = scan.nextLine();
			//System.out.println(inp1);
			String[] inp = inp1.trim().split("\\s+");
			String post = pf(inp);
			//System.out.println(post);
			String n = compute(post) + "";
			//System.out.println(n);
			System.out.println(!n.equals("-1000000")? n:"infinity");

		}

	}
}
