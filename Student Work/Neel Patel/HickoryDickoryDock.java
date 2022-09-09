import java.io.*;
import java.util.*;

public class HickoryDickoryDock {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("hickory.dat"));
		while (scan.hasNext()) {
			System.out.println(scan.nextLine());
			scan.nextLine();
		}
	}
}

