package dataStructure.hash;

public class HashInStr {
	public int hashCode(String s) {
		int g = 31;
		int hash = 0;
		
		for(int i = 0; i < s.length(); i++) {
			hash += s.charAt(i) * (int)Math.pow(g, i);
		}
		
		return hash;
	}
}
