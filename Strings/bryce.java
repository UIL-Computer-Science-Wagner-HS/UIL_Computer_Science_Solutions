package compsci;
import java.util.*;
import java.io.*;
public class bryce {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("bryce"));
		while(scan.hasNext()) {
			int a = scan.nextInt();
			int b = a;
			String str ="";
			while(a > 0) {
				if(a / 1000 > 0) {
					int y = a/1000;
					while(y > 0) {
						str = str + "M";
						y--;
					}
				a = a-((a/1000)*1000);
				}
				if(a / 500 > 0) {
					if(a-900>=0) {
						str = str + "CM";
						a = a-900;
					}
					int y = a/500;
					while(y > 0) {
						str = str + "D";
						y--;
					}
					a = a-((a/500)*500);
				}
				if(a / 100 > 0) {
					int y = a/100;
					while(y > 0) {
						str = str + "C";
						y--;
					}
					a = a-((a/100)*100);
				}
				if(a / 50 > 0) {
					if(a-90>=0) {
						str = str + "XC";
						a = a-90;
					}
					int y = a/50;
					while(y > 0) {
						str = str + "L";
						y--;
					}
					a = a-((a/50)*50);
				}
				if(a / 10 > 0) {
					int y = a/10;
					while(y > 0) {
						str = str + "X";
						y--;
					}
					a = a-((a/10)*10);
				}
				if(a / 5 > 0) {
					if(a-9>=0) {
						str = str +"IX";
						a = a-9;
					}
					int y = a/5;
					while(y > 0) {
						str = str + "V";
						y--;
					}
					a = a-((a/5)*5);
				}
				if(a / 1 > 0) {
					if(a>=4 ) {
						str = str +"IV";
						a = a-4;
					}
					int y = a/1;
					while(y > 0) {
						str = str + "I";
						y--;
					}
					a = 0;
				}
			}
			System.out.println(b + ":" + str);
		}
	}
}
