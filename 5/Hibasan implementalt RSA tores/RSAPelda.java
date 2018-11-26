import java.math.BigInteger;
import java.io.*;
import java.util.*;

public class RSAPelda {
	public static void main(String[] args) {

		try
		{
			KulcsPar jSzereplo = new KulcsPar();

			String tisztaSzoveg = "Hello, Vilag!";

			PrintWriter writer = new PrintWriter("kodolt.txt", "UTF-8");

	        //kódol i
			BigInteger[] titkos = new BigInteger[tisztaSzoveg.length()];

			for(int i=0; i<tisztaSzoveg.length(); ++i) {
				String temp = tisztaSzoveg.substring(i,i+1);

				byte[] buffer = temp.getBytes();
				titkos[i] = new BigInteger(new byte[]{buffer[0]});
				titkos[i] = titkos[i].modPow(jSzereplo.e, jSzereplo.m);

				writer.println(titkos[i].toString());//kiírás a fájlba
	        }

			writer.close();
		}
		catch (Exception e) {

		}
		/*
		//kódol i
		byte[] buffer = tisztaSzoveg.getBytes();
		BigInteger[] titkos = new BigInteger[buffer.length];

		for(int i=0; i<titkos.length; ++i) {
			titkos[i] = new BigInteger(new byte[]{buffer[i]});
			titkos[i] = titkos[i].modPow(jSzereplo.e, jSzereplo.m);
        }

        //------------------------------------------------------------

        //dekódol j
		byte[] buffer = tisztaSzoveg.getBytes();

        for(int i=0; i<titkos.length; ++i) {
            titkos[i] = titkos[i].modPow(jSzereplo.d, jSzereplo.m);
            buffer[i] = titkos[i].byteValue();
        }

        System.out.println(new String(buffer));
		*/
	}
}
