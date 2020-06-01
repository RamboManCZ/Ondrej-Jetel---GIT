
public class Trojuhelnik {
	private double a, b, c;

	public static Trojuhelnik factoryTrojuhelnik(double a, double b, double c) {
		if (a == b || a == c || b == c) {
			return new Trojuhelnik(a, b, c);
		}
		if (a == b && a == c && b == c) {
			return new Trojuhelnik(a, b, c);
		}
		return null;
	}

	private Trojuhelnik(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double Obsah(double a, double b, double c) {
		double v = 0;
		double a1, b1, c1, s;
		if (a == b || a == c || b == c) {
			if (b == c) {
				b1 = b * b;
				a1 = a * a;
				a1 = a1 / 4;
				v = Math.sqrt(b1 - a1);
			}
			if (a == c) {
				c1 = c * c;
				b1 = b * b;
				b1 = b1 / 4;
				v = Math.sqrt(c1 - b1);
			}
			if (a == b) {
				a1 = a * a;
				c1 = c * c;
				c1 = c1 / 4;
				v = Math.sqrt(a1 - c1);
			}
			s = a * v;
			s = s / 2;
			return s;

		}
		if (a == b && a == c && b == c) {
			a1 = a * a;
			b1 = Math.sqrt(3);
			c1 = b1 / 4;
			s = a1 * c1;
			return s;
		}

		return 4312384351.0;

	}

	public double Obvod(double a, double b, double c) {
		return a + b + c;
	}

	public String toString() {
		return "Strana a: " + a + "\nStrana b: "+b+"\nStrana c: "+c+"\n Obvod: " + Obvod(a, b, c)+"\n Obsah: "+Obsah(a,b,c);
	}
}
