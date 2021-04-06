import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConvertMe {
	
	public static void process(String[] nextLine) {
		int firstNum = Integer.parseInt(nextLine[0]);
		int secondNum = Integer.parseInt(nextLine[1]);
		ArrayList<Integer> divisorsOfN = new ArrayList<>();
		for(int i = 2; i<firstNum; i++)
			if(firstNum%i==0)
				divisorsOfN.add(i);
		if(divisorsOfN.isEmpty()) {
			System.out.println(-1);
			return;
		}
		ArrayList<Integer> steps = new ArrayList<>();
		for(int divisor: divisorsOfN) {
			int numSteps = 0;
			int n = firstNum, m = secondNum;
			while(n<m) {
				n+=divisor;
				numSteps++;
			}
			if(n==m)
				steps.add(numSteps);
			else
				steps.add(Integer.MAX_VALUE);
		}
		
		int min = Collections.min(steps);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("convertme.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while(n-->0)
			process(scan.nextLine().split(" "));
	}
}
