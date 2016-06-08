package utilidades;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Seguridad {

    public static String getHash(String message) throws NoSuchAlgorithmException {
        MessageDigest md;
        byte[] buffer, digest;
        String hash = "";

        buffer = message.getBytes();
        md = MessageDigest.getInstance("SHA-256");
        md.update(buffer);
        digest = md.digest();

        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }

        return hash;
    }
}
/*public class Security {
    public Security() {
        super();
    }
}
*/