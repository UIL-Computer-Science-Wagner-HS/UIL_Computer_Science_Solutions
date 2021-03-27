import java.io.*;
import java.util.*;
public class Arthur {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("arthur.dat"));
		int number = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < number; i++) {
			ArrayList<Integer> numbers = new ArrayList<>();
			numbers.add(scan.nextInt());
			numbers.add(scan.nextInt());
			numbers.add(scan.nextInt());
			scan.nextLine();
			Collections.sort(numbers);
			if(Math.pow(numbers.get(0), 2)+Math.pow(numbers.get(1), 2) == Math.pow(numbers.get(2), 2)) {
				System.out.printf("%d, %d, %d is a Pythagorean triple.%n", numbers.get(0), numbers.get(1), numbers.get(2));
			} else {
				System.out.printf("%d, %d, %d is not a Pythagorean triple.%n", numbers.get(0), numbers.get(1), numbers.get(2));
			}		
		}
	}
}
