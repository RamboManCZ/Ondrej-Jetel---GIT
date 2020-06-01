import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		Trojuhelnik t1 = Trojuhelnik.factoryTrojuhelnik(a, b, c);
		System.out.println(t1);
	}

}
