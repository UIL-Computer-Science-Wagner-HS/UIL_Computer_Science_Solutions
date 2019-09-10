import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sarah {

private static void process(String input) {
  String copy = input;

  if (copy.substring(0, 1).matches("[aeiou]")) {
    copy = "" + copy.charAt(1) + copy.charAt(0) + copy.substring(2);
  }

  for (int i = 1; i < copy.length() - 1; i++) {
  if (copy.substring(i, i + 1).matches("[aeiou]"))
    copy = copy.substring(0, i - 1) + copy.charAt(i + 1) + copy.charAt(i) + copy.charAt(i - 1)
    + copy.substring(i + 2);
  }

  if (copy.substring(copy.length() - 1).matches("[aeiou]")) 
    copy = copy.charAt(copy.length() - 1) + copy.substring(1, copy.length() - 1) + copy.charAt(0);

  System.out.println(input + " " + copy);
}

public static void main(String[] args) throws IOException {
  Scanner scan = new Scanner(new File("sarah.dat"));
  
  while (scan.hasNext())
  process(scan.next());
  
  scan.close();

  }

}
