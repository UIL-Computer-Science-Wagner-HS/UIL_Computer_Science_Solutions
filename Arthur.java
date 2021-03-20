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
			/**
			ArrayList <Integer> nums = new ArrayList<Integer>();
			nums.add(scan.nextInt());
			nums.add(scan.nextInt());
			nums.add(scan.nextInt());
			nums.sort(null);
		
			if((nums.get(0)*nums.get(0) + nums.get(1)*nums.get(1)) == (nums.get(2)*nums.get(2))  ) {
				System.out.print(nums.get(0) + ", " + nums.get(1)+ ", " + nums.get(2));
				System.out.print(" is a Pythagorean triple");
				//break;
			}
			else {
				if(nums.get(0)+ nums.get(1) > nums.get(2)) {
					System.out.print(nums.get(0) + ", " + nums.get(1)+ ", " + nums.get(2));
					System.out.print(" is a Pythagorean triple");
					//break;
				}
				else {
					System.out.print(nums.get(0) + ", " + nums.get(1)+ ", " + nums.get(2));
					System.out.print(" is not a Pythagorean triple");
				}
			}
			System.out.println();
			//System.out.println(nums);
//			int x = scan.nextInt();
//			int y = scan.nextInt();
//			int z = scan.nextInt();
//			scan.nextLine();
//			int c = 0;
//			boolean triple = true;
//			if (x > y) {
//				if(x > z) {
//					c = x;
//					if(y + z > c) {
//						triple = false;
//					}
//				}
//				else {
//					c = z;
//					if(y + x > c) {
//						triple = false;
//					}
//				}
//			}
//			else {
//				if(y > z) {
//					c = y;
//					if(z + x > c) {
//						triple = false;
//					}
//				}
//				else {
//					c = z;
//					if(y + x > c) {
//						triple = false;
//					}
//				}
//			}
 * 
 */
			
			
		}
	}
}
