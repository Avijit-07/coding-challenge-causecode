package hackerrank.java;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

	public static void main(String[] args) {
		int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		int n = 9;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<ar.length; i++) {
			if(map.containsKey(ar[i])) {
				int count = map.get(ar[i]);
				map.put(ar[i], count+1);
			}else {
				map.put(ar[i], 1);
			}
		}
		int finalCount = 0;
		for (int key : map.keySet()) {
			if(map.get(key) % 2 == 0) {
				finalCount = finalCount + map.get(key) / 2;
			} else if(map.get(key) > 1 && (map.get(key) % 2 != 0)){
				finalCount = finalCount + map.get(key) / 2;
			}
		}
		System.out.println(finalCount);
	}

}
