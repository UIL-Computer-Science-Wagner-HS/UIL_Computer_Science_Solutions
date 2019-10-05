import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Judith {
	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("judith.dat"));
		ArrayList<BigDecimal> list = new ArrayList<>();
		while(scan.hasNextLine()) {
			list.add(new BigDecimal(scan.nextLine()));
		}
		Collections.sort(list);
		for(BigDecimal a: list)
			System.out.println(a);
		scan.close();
	}
}
/*395.96774839412213864694087795
375.286439548498
8.412190040221
0.382560882678260591251068
0.23943358855017051969126499
95.96038946102548087733835
0.392863116206040
557.91740143772795279
46.8020528027329
0.91986136436504
*/
