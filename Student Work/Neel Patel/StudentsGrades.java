import java.io.*;
import java.util.*;

public class StudentsGrades {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File("students.dat"));
		
		int n = scan.nextInt();
		scan.nextLine();
		
		int count_less_40 = 0;
		int count_40_49 = 0;
		int count_50_59 = 0;
		int count_60_69 = 0;
		int count_70_79 = 0;
		int count_80_89 = 0;
		int count_90_100 = 0;
		
		while (n-- > 0) {
			String[] arr = scan.nextLine().split(" ");
			int grade = Integer.parseInt(arr[arr.length-1]);
			
			if (grade <= 100 && grade >= 90) {
				count_90_100++;
			}
			else if (grade <= 89 && grade >= 80) {
				count_80_89++;
			}
			else if (grade <= 79 && grade >= 70) {
				count_70_79++;
			}
			else if (grade <= 69 && grade >= 60) {
				count_60_69++;
			}
			else if (grade <= 59 && grade >= 50) {
				count_50_59++;
			}
			else if (grade <= 49 && grade >= 40) {
				count_40_49++;
			}
			else {
				count_less_40++;
			}
		}
		
		System.out.println("   <40:" + solve(count_less_40));
		System.out.println(" 40-49:" + solve(count_40_49));
		System.out.println(" 50-59:" + solve(count_50_59));
		System.out.println(" 60-69:" + solve(count_60_69));
		System.out.println(" 70-79:" + solve(count_70_79));
		System.out.println(" 80-89:" + solve(count_80_89));
		System.out.println("90-100:" + solve(count_90_100));
	}

	static String solve(int num) {
		String str ="";
		for (int i = 0; i < num; i++) {
			str+="*";
		}
		return str;
	}

}
