import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 *
 */
public class digit_total {

	public static void main(String[] args) throws IOException{
		System.out.println(new Scanner(new File("digit_total.dat")).nextLine().chars().filter(Character::isDigit).mapToLong(Character::getNumericValue).sum()); // Epic one-liner
	}

}
