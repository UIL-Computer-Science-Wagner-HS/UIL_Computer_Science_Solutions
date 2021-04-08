import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shirts {
	static class Shirt implements Comparable<Shirt>{
		String colorOrder = "ROYGB", sizeOrder = "SML";
		char color, size;
		int id;
		
		public Shirt(char color, char size, int id) {
			this.color = color;
			this.size = size;
			this.id = id;
		}

		@Override
		public int compareTo(Shirts.Shirt second) {
			if(colorOrder.indexOf(color) != colorOrder.indexOf(second.color))
				return colorOrder.indexOf(color) - colorOrder.indexOf(second.color);
			else if(sizeOrder.indexOf(size) != sizeOrder.indexOf(second.size))
				return sizeOrder.indexOf(size) - sizeOrder.indexOf(second.size);
			return id - second.id;
		}
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("shirts.dat"));
		int numTestCases = Integer.parseInt(scan.nextLine());
		while(numTestCases-->0) {
			int numShirts = Integer.parseInt(scan.nextLine());
			ArrayList<Shirt> shirts = new ArrayList<>();
			while(numShirts-->0) {
				String[] nextLine = scan.nextLine().split(" ");
				int id = Integer.parseInt(nextLine[0]);
				char color = nextLine[1].charAt(0), size = nextLine[2].charAt(0);
				shirts.add(new Shirt(color, size, id));
			}
			Collections.sort(shirts);
			shirts.forEach(x->System.out.print(x.id+" "));
			System.out.println();
		}
	}
}
