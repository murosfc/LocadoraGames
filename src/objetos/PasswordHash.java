package objetos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//codifica a senha do funcionário para não ser possível ler em consulta ao banco de dados
public interface PasswordHash {

	    public static String getHashMd5(String value) {
	        MessageDigest md;
	        try {
	            md = MessageDigest.getInstance("MD5");
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	        BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
	        return hash.toString(16);
	    }
}


