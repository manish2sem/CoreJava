package secureRandNo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class GenerateSecureRandomNumber {

	public static void main(String[] args) {

		try {

			// Create a secure random number generator using the SHA1PRNG algorithm

			SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");

			// Get 128 random bytes

			byte[] randomBytes = new byte[128];

			secureRandomGenerator.nextBytes(randomBytes);


			// Create two secure number generators with the same seed

			int seedByteCount = 5;

			byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);

			SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
			secureRandom1.setSeed(seed);
			SecureRandom secureRandom2 = SecureRandom.getInstance("SHA1PRNG");
			secureRandom2.setSeed(seed);
			System.out.println("Exit main...");

		} catch (NoSuchAlgorithmException e) {

		}



	}

}
