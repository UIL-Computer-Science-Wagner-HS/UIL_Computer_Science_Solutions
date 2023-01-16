import java.io.*;
import java.util.*;

public class Maerk {
	static int precedence(char c) {
		if (c == '*' || c == '/')
			return 1;
		return 0;
	}

	static String pf(String[] arr) {
		String ans = "";
		Stack<String> ops = new Stack<>();
		for(String s: arr) {
			 if(s.matches("\\d+")) {
				ans += s + " ";
			//System.out.println(ans);
			 }
			 else if (s.equals("("))
				ops.push(s);
			else if (s.equals(")")) {
				System.out.println("hi"+ ops);
				while (!ops.peek().equals("("))
					ans += ops.pop() + " ";
				System.out.println("ops pop "+ops.pop());
				

			}
			else if ("/*+-".indexOf(s)>=0) {
				while (!ops.isEmpty())
					if((ops.peek().charAt(0)) >= precedence(s.charAt(0)))
						ans += ops.pop() + " ";
				ops.push(s);
			}
				
				


		}
		while (!ops.isEmpty())
			ans += ops.pop()+" ";
		return ans;
	}

	public static void main(String... args) throws IOException {

		Scanner scan = new Scanner(new File("marek.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String[] inp = scan.nextLine().trim().split("\\s+");
			System.out.println(Arrays.toString(inp));
			String post =pf(inp); 
			
			System.out.println(post);

		}

	}
}
