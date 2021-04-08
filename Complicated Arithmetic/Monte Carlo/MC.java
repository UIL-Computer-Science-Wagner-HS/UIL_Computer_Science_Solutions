import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MC {
	
	static class Particle {
		double x, y;
		
		public Particle(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean overlappingWith(double otherX, double otherY) {
			double distance = Math.sqrt(Math.pow(otherX-x, 2) + Math.pow(otherY-y, 2));
			return distance<1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("mc.dat"));
		int numParticles = scan.nextInt(), numAttemptedMovements = scan.nextInt();
		scan.nextLine();
		ArrayList<Particle> particles = new ArrayList<>();
		while(numParticles-->0)
			particles.add(new Particle(scan.nextDouble(), scan.nextDouble()));
		while(numAttemptedMovements-->0) {
			int particleNum = scan.nextInt();
			double deltaX = scan.nextDouble(), deltaY = scan.nextDouble();
			Particle particleToMove = particles.get(particleNum-1);
			double newX = particleToMove.x + deltaX, newY = particleToMove.y + deltaY;
			boolean everOverlaps = false;
			for(Particle particle: particles) {
				if(particle.overlappingWith(newX, newY))
					everOverlaps = true;
			}
			if(!everOverlaps) {
				particleToMove.x = newX;
				particleToMove.y = newY;
			}
		}
		for(Particle particle: particles)
			System.out.printf("%.3f %.3f%n", particle.x, particle.y);
	}
}
