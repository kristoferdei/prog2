import java.math.BigInteger;
import java.util.Random;

public class RSA {
	public static void main(String[] args) {

		int meretBitekben = 700 * (int)(Math.log((double)10)/Math.log((double)2));
		System.out.println("Méret bitekben:");
		System.out.println(meretBitekben);

		BigInteger p_i = new BigInteger(meretBitekben, 100, new Random());
		System.out.println("p_i");
		System.out.println(p_i);
		System.out.println("p_i hexa");
		System.out.println(p_i.toString(16));

		BigInteger q_i = new BigInteger(meretBitekben, 100, new Random());
		System.out.println("q_i");
		System.out.println(q_i);

		BigInteger m_i = p_i.multiply(q_i);
		System.out.println("m_i");
		System.out.println(m_i);

		BigInteger z_i = p_i.subtract(BigInteger.ONE).multiply(q_i.subtract(BigInteger.ONE));
		System.out.println("z_i");
		System.out.println(z_i);

		BigInteger d_i;
		do {
			do {
				d_i = new BigInteger(meretBitekben, new Random());
			}
			while (d_i.equals(BigInteger.ONE));
		}
		while (!z_i.gcd(d_i).equals(BigInteger.ONE));
		System.out.println("d_i");
		System.out.println(d_i);

		BigInteger e_i = d_i.modInverse(z_i);
		System.out.println("e_i");
		System.out.println(e_i);

	}
}
