import java.io.*;
import java.util.*;
public class Linus {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan  = new Scanner(new File("linus.dat"));
		int fraction = scan.nextInt();
		for( int i  = 0; i < fraction; i++) {
			int numerator = scan.nextInt();
			int denomator = scan.nextInt();
			double numeratord = numerator;
			double denomatord = denomator;
			if(numerator == 0) {
				System.out.println(0);
			}
			else if(numerator < denomator) {
				for( double j = Math.floor(denomatord/2)+1; j > 0; j-- ) {
					if(numeratord/j == Math.floor(numeratord/j) && denomatord/j == Math.floor(denomatord/j)) {
						int numans = (int) (numerator/j);
						System.out.print(numans);
						System.out.print("/");
						int denans = (int) (denomator/j);
						System.out.println(denans);
						break;
					}
				}
			}
			else if(numerator > denomator) {
				int numeratorrem = numerator%denomator;
				int numeratorfull = (numerator-numeratorrem)/denomator;
				numeratord = numeratorrem;
				numerator = numeratorrem;
				for( double j = Math.floor(denomatord/2)+1; j > 0; j-- ) {
					if(numeratord/j == Math.floor(numeratord/j) && denomatord/j == Math.floor(denomatord/j)) {
						System.out.print(numeratorfull);
						System.out.print(" ");
						int numans = (int) (numerator/j);
						System.out.print(numans);
						System.out.print("/");
						int denans = (int) (denomator/j);
						System.out.println(denans);
						break;
					}
				}
			}
			else {
				System.out.println(1);
			}
		}
	}
}
