import java.math.BigInteger;
import java.util.Random;

public class KulcsPar {
    BigInteger d, e, m;

    public KulcsPar() {
        int meretBitekben = 700 * (int)(Math.log((double)10)/Math.log((double)2));

		BigInteger p = new BigInteger(meretBitekben, 100, new Random());
		BigInteger q = new BigInteger(meretBitekben, 100, new Random());

		m = p.multiply(q);

		BigInteger z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

		do {
			do {
				d = new BigInteger(meretBitekben, new Random());
			}
			while (d.equals(BigInteger.ONE));
		}
		while (!z.gcd(d).equals(BigInteger.ONE));

		e = d.modInverse(z);
    }
}
