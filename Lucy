import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lucy {
	
	private static void process(String input) {
		int no = 1;
		char currentChar = input.charAt(0);
		
		for(int i = 1;i<input.length();i++) {
			if(input.charAt(i)!=currentChar) {
				System.out.print(currentChar+""+no);
				currentChar = input.charAt(i);
				no = 1;
			} else {
				no++;
			}
		}
		System.out.print(currentChar+""+no);
	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("lucy.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while(no-->0) {
			int noLines = Integer.parseInt(scan.nextLine());
			for(int i = 0;i<noLines;i++) {
				process(scan.nextLine());
				System.out.println();
			}
			System.out.println("=====");
		}
		scan.close();
		

	}

}
/*2
13
....................
@..................@
.@................@.
..@..............@..
...@@@@@@@@@@@@@@...
...@............@...
....@..**..**..@....
....@..**..**..@....
.....@........@.....
..../@...++...@.....
.../&&@..++..@......
../&&&/@@@@@@.......
./&&&/..............
8
..............................
....____. ....................
....|    |____ ___  _______...
....|    \__  \\  \/ /\__  \..
/\__|    |/ __ \\   /  / __ \_
\________(____  /\_/  (____  /
..............\/...........\/.
..............................
*/
