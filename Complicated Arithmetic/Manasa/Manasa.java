import java.io.*;
import java.util.*;
public class Manasa {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("manasa.dat"));
		int number = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < number; i++) {
			int V = scan.nextInt();
			int T = scan.nextInt();
			
			int W = scan.nextInt();
			int S = scan.nextInt();
			int D = scan.nextInt();
			scan.nextLine();
			if( V*T >= D) {
				System.out.println(" Case #" +  (i+1) + ": 1");
			}
			else if (V*T <= W*S) {
				System.out.println(" Case #" +  (i+1) + ": Impossible");
			}
			else {
				int distance = 0;
				int start = 0;
				while(true) {
					distance += V*T;
					start++;
					if(distance >= D) {
						System.out.println(" Case #" +  (i+1) + ": " + start);
						break;
					}
					else {
						distance -= W*S;
					}
				}
			}
		}
	}
}
