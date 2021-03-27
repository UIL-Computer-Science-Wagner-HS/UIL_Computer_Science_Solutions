import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Denis {
	
	static int getGCD(int a, int b) {
		if(b==0)
			return a;
		return getGCD(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("denis.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while(n-->0) {
			String nextLine = scan.nextLine();
			String[] nextLineArr = nextLine.split("/");
			int firstNum = Integer.parseInt(nextLineArr[0]);
			int secondNum = Integer.parseInt(nextLineArr[1]);
			int gcd = getGCD(firstNum, secondNum);
			int newFirst = firstNum/gcd, newSecond = secondNum/gcd;
			
			if(newFirst > 0 && newSecond < 0) {
				newFirst *=-1;
				newSecond *= -1;
			}
			
			String simplifiedResult = newFirst+"/"+newSecond;

			System.out.println(nextLine + " reduced is " + simplifiedResult);
		}
	}
}
