import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kirill {
	static ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,3,5,7,9,20));
	
	static int process(int num) {
		while(num>=numbers.get(numbers.size()-1))
			numbers.add(getNextNum(numbers.get(numbers.size()-1)));
		int indexOfNumToReturn = numbers.size()-1;
		while(numbers.get(indexOfNumToReturn)>num)
			indexOfNumToReturn--;
		return numbers.get(indexOfNumToReturn);
	}
	
	static int getNextNum(int lastNum) {
		for(int i = lastNum+1;;i++)
			if(isSelfNumber(i))
				return i;
	}
	
	static boolean isSelfNumber(int num) {
		int length = (""+num).length();
		for(int j = num; j>=num-length*9; j--) // length*9 is the maximum sod that can be added (this eliminates O(n^2) problem when going all the way to 0)
			if(j+sod(j)==num)
				return false;
		return true;
	}
	
	static int sod(int num) { // sum of digits
		int sum = 0;
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Kirill.dat"));
		int n = scan.nextInt();
		for(int i = 1; i<=n; i++) {
			System.out.printf("Case #%d: %d%n", i, process(scan.nextInt()));
		}
	}
}
