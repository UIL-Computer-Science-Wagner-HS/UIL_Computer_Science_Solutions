import java.io.*;
import java.util.*;

public class Shivam {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("shivam.dat"));
		
		int n = scan.nextInt();
		scan.nextLine();
		
		int counter = 0;
		String y_coordinate = "0.00";
		
		while (n-->0) {
			counter++; // counts the n^th number of functions
			String str = scan.nextLine();
			str = str.substring(7);
			int a = 1;
			int b = 0;
			int c = 0;
			if (str.indexOf("x")!= 0)
				a = Integer.parseInt(str.substring(0,str.indexOf("x")));
			str = str.substring(str.indexOf("x")+3);
			if (str.contains("x")) {
				b = Integer.parseInt(str.substring(0,str.indexOf("x")));
				str = str.substring(str.indexOf("x")+1);
			}
			if (!str.isEmpty())
				c = Integer.parseInt(str.substring(0));

			boolean roots = containsRoot(a,b,c);
			if (roots!= true){
				System.out.println("Function #" + counter + ": There are no real roots to the function.");
			}
			else {
				double root1 = getRoot1(a,b,c);
				double root2 = getRoot2(a,b,c);
				if (root1 == root2) {
					System.out.println("Function #" + counter + ": There is one real root at (" + root1 + "," + y_coordinate + ").");
				}
				else {
					if (root1 < root2)
						System.out.printf("Function # %d: There are two real roots at (%.2f, %s) and (%.2f, %s)", counter, root1,y_coordinate,root2,y_coordinate );
					else
						System.out.printf("Function # %d: There are two real roots at (%.2f, %s) and (%.2f, %s)", counter, root2,y_coordinate,root1,y_coordinate );
					System.out.println();
				}
		
				
			}

			
			
		}
	}

	static boolean containsRoot(int a, int b, int c) {
		if ((Math.pow(b,2)-(4*a*c)) < 0) {
			return false;
		}
		return true;
	}

	static double getRoot1(int a, int b, int c) {
		double root = ((-1*b)+(Math.sqrt((Math.pow(b, 2))-(4*a*c))))/(2*a);
		if (root == -0) 
			return 0;
		return root;
	}
	
	static double getRoot2(int a, int b, int c) {
		double root = ((-1*b)-(Math.sqrt((Math.pow(b, 2))-(4*a*c))))/(2*a);
		if (root == -0) 
			return 0;
		return root;
	}

}
