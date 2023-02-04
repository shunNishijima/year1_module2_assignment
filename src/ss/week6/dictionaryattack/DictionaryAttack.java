package ss.week6.dictionaryattack;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws IOException
	 */
	public void readPasswords(String filename) throws IOException {
		String line;
		String [] split;
		var fr = new FileReader(filename);
		var br = new BufferedReader(fr);
		passwordMap = new HashMap<String,String>();

		while ((line=br.readLine())!=null) {
			try {
				split = line.split(": ");
				passwordMap.put(split[0],split[1]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		br.close();
		}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte [] bytes = md.digest();
			password= String.format("%032x", new BigInteger(1, bytes));
			return password;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
		/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		password = getPasswordHash(password);
		String userpassword = passwordMap.get(user);
		return password.equals(userpassword);
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) {
			try {
				String line;
				var fr = new FileReader(filename);
				var br = new BufferedReader(fr);
				hashDictionary = new HashMap<String, String>();
				while ((line = br.readLine()) != null) {
					hashDictionary.put(getPasswordHash(line), line);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (String key1 : passwordMap.keySet()) {
			if (hashDictionary.get(getPasswordHash(passwordMap.get(key1))) != null) {
				System.out.println(hashDictionary.get(getPasswordHash(passwordMap.get(key1))) + " " + key1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		da.passwordMap = new HashMap<>();
		da.passwordMap.put("Shun","access");
		da.addToHashDictionary("C:\\softwaresystems\\java\\SoftwareSystems\\src\\ss\\week6\\dictionaryattack\\linuxwords.txt");
		da.doDictionaryAttack();
	}
}
//6.6: 26^4/2