import java.util.*;
import java.io.*;
public class Jacob {
static 	double comp(int n) {
		double sum = 0;
		double mult = 2;
		for(int i = 0; i<n; i++) {
			sum+=Math.pow(-1, i)*1/(mult*(mult+1)*(mult+2));
			mult+=2;
			
		}
		return 4*sum;
		
	}
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("jacob.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		double sum = comp(scan.nextInt())+3;
		System.out.printf("%14.13f\n", sum);

	}
}
}
