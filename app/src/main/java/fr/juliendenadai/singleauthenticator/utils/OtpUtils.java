package fr.juliendenadai.singleauthenticator.utils;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import fr.juliendenadai.singleauthenticator.models.Algorithm;
import fr.juliendenadai.singleauthenticator.models.Digits;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 19/09/15.
 */
public class OtpUtils {

    public static String Hmac(byte[] secret, int counter, Digits digits, Algorithm algorithm) {

        final String algo = "Hmac" + algorithm.name();

        // Encode counter in network byte order
        final ByteBuffer bb = ByteBuffer.allocate(8);
        bb.putLong(counter);

        // Create digits divisor
        int div = 1;
        for (int i = digits.getValue(); i > 0; i--)
            div *= 10;

        // Create the HMAC
        try {
            Mac mac = Mac.getInstance(algo);
            mac.init(new SecretKeySpec(secret, algo));

            // Do the hashing
            byte[] digest = mac.doFinal(bb.array());

            // Truncate
            int binary;
            int off = digest[digest.length - 1] & 0xf;
            binary = (digest[off] & 0x7f) << 0x18;
            binary |= (digest[off + 1] & 0xff) << 0x10;
            binary |= (digest[off + 2] & 0xff) << 0x08;
            binary |= (digest[off + 3] & 0xff);
            binary = binary % div;

            // Zero pad
            String hotp = Integer.toString(binary);
            while (hotp.length() != digits.getValue())
                hotp = "0" + hotp;

            return hotp;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";

    }

    private static byte[] truncate(byte[] message, int nb) throws IllegalArgumentException {
        if (message.length < nb) {
            throw new IllegalArgumentException("Array is smaller than truncate size (" + nb + ")");
        }
        return Arrays.copyOf(message, nb);
    }
}
