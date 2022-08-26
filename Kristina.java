import java.util.*;
import java.io.*;

public class Kristina {
	
	public static Integer evaluate(Integer a, Integer b, String op)
	{
		if (op.equals("^"))
		{
			return (int) Math.pow(a, b);
		}
		if (op.equals("*"))
		{
			return a * b;
		}
		if (op.equals("/"))
		{
			return a / b;
		}
		if (op.equals("+"))
		{
			return a + b;
		}
		return a - b;
		
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("kristina.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		while (n-- > 0)
		{
			String[] exp = scan.nextLine().split(" ");
			String ops = "^*/+-";
			Stack<Integer> stack = new Stack<>();

			if (exp[0].equals("PRE"))
			{
				for (int i = exp.length-1; i > 0; i--)
				{
					if (!ops.contains(exp[i]))
					{
						stack.push(Integer.parseInt(exp[i]));
					}
					else
					{
						stack.push(evaluate(stack.pop(), stack.pop(), exp[i]));
					}
				}
				System.out.println(stack.peek());
			}
			else
			{
				for (int i = 1; i < exp.length; i++)
				{
					if (!ops.contains(exp[i]))
					{
						stack.push(Integer.parseInt(exp[i]));
					}
					else
					{
						Integer b = stack.pop();
						Integer a = stack.pop();
						stack.push(evaluate(a, b, exp[i]));
					}
				}
				System.out.println(stack.peek());	
			}
		}
	}
}

