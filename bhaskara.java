import java.util.Scanner;
import java.util.Locale;
class bhaskara{
	public static void main(String args[]){
		Locale.setDefault(Locale.US);
		System.out.println("Programa para calcular raizes");
	    Scanner input = new Scanner(System.in);
	    float delta,a,b,c,x1,x2;
		System.out.print("A: ");
		a = input.nextFloat();

		System.out.print("B: ");
		b = input.nextFloat();

		System.out.print("C: ");
		c = input.nextFloat();

		delta = b*b-4*a*c;

		if (delta>=0){
			x1 = (float)(-b+Math.sqrt(delta))/(2*a);
			x2 = (float)(-b-Math.sqrt(delta))/(2*a);
			System.out.printf("X1: %.2f\tX2: %.2f\n",x1,x2);
		}
		else{
			System.out.printf("X1: %.2f+j%.2f \tX2: %.2f-j%.2f\n",-b/(2*a),Math.sqrt(-delta)/(2*a),-b/(2*a),Math.sqrt(-delta)/(2*a));
		}
	}
}

























