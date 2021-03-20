import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hannah {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("hannah.dat"));
		int num = Integer.parseInt(scan.nextLine());
		while(num-->0) {
			int base = Integer.parseInt(scan.nextLine());
			String[] nextLine = scan.nextLine().split("\\s+");
			int firstNum = Integer.parseInt(nextLine[0], base);
			char operator = nextLine[1].charAt(0);
			int secondNum = Integer.parseInt(nextLine[2], base);
			int result = -1;
			
			switch(operator) {
			case '+':
				result = firstNum+secondNum;
				break;
			case '-':
				result = firstNum-secondNum;
				break;
			case '/':
				result = firstNum/secondNum;
				break;
			case '*':
				result = firstNum*secondNum;
			}
			
			for(String item: nextLine) {
				System.out.print(item+" ");
			}
			
			System.out.println("= "+Integer.toString(result, base));
		}
	}
}
