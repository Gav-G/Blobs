import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Tree {
	
	private ArrayList<String> fullArray;
	
	private String sha1Array = ""; 
	
	public Tree (ArrayList<String> strArr) throws IOException {
		this.fullArray = strArr;
		
		for (String s : strArr) {
			sha1Array+=s + "\n";
		}
		
		sha1Array = getSha1(sha1Array.trim());//turn list of blobs/trees -> sha1 for name
		
		File f = new File("test/objects/" + sha1Array);
		FileWriter writer = new FileWriter (f);
		
		
	}
	
	
	private static String getSha1 (String input) {
		String value = input;
		String sha1 = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(value.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}

		return sha1;
	}
}
