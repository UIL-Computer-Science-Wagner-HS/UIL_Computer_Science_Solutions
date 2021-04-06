import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Average {
	
	public static void process(String[] nextLine) {
		ArrayList<Double> numbers = new ArrayList<>();
		for(String str: nextLine)
			numbers.add(Double.parseDouble(str));
		
		System.out.printf("%.3f%n", Math.sqrt(numbers.stream().mapToDouble(x->x*x).average().getAsDouble()));
	}

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("average.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while(n-->0)
			process(scan.nextLine().split(" "));
	}

}
