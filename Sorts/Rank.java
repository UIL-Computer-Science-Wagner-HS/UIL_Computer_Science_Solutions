import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 *
 */
public class Rank {
	
	static class Student {
		private String firstName, lastName, grades;
		private double gpa;
		
		public Student(String firstName, String lastName, String grades) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.grades = grades;
			
			this.gpa = getGPA();
		}
		
		private double getGPA() {
			String[] gradesArr = grades.split(",");
			return Arrays.stream(gradesArr).mapToDouble(x->Double.parseDouble(x)).average().getAsDouble();
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rank.dat"));
		List<Student> students = new ArrayList<>();
		
		while(scan.hasNextLine()) {
			String[] nextLine = scan.nextLine().split("/");
			students.add(new Student(nextLine[1], nextLine[2], nextLine[0]));
		}
		
		students.sort(Comparator.comparing((Student x)->x.gpa).reversed().thenComparing(x->x.lastName).thenComparing(x->x.firstName));
		
		students.forEach(student->System.out.printf("%.3f - (%s,%s)%n", student.gpa, student.lastName, student.firstName));
		
		scan.close();
	}

}
