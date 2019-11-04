import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "hello";
		Map<Character, Integer> s1Map = new HashMap<>();
		Map<Character, Integer> s2Map = new HashMap<>();
		
		if(s1.length() == s2.length()) {
			for(int i = 0; i<s1.length(); i++) {
				char key = s1.toLowerCase().charAt(i);
				if(s1Map.containsKey(key)) {
					int count = s1Map.get(key);
					s1Map.replace(key, count+1);
				}
				else {
					s1Map.put(key, 1);
				}
			}
			for(int i = 0; i<s2.length(); i++) {
				char key2 = s2.toLowerCase().charAt(i);
				if(s2Map.containsKey(key2)) {
					int count = s2Map.get(key2);
					s2Map.replace(key2, count+1);
				}
				else {
					s2Map.put(key2, 1);
				}
			}
			
			if(s1Map.size() == s2Map.size()) {
				if(s1Map.keySet().containsAll(s2Map.keySet()) &&
						s1Map.values().containsAll(s2Map.values())) {
					System.out.println("Anagrams");
				}else {
					System.out.println("Not Anagrams");
				}
			}
			else {
				System.out.println("Not Anagrams");
			}
		}
		else {
			System.out.println("Not Anagrams");
		}
	}
}
