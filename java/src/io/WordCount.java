package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/work/news.txt"));
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		StringTokenizer token = new StringTokenizer(sb.toString());
		
		while (token.hasMoreElements()) {
			String result = token.nextElement().toString();
			if (map.containsKey(result)) {
				map.put(result, map.get(result) + 1);
			} else {
				map.put(result, 1);
			}
		}
		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
		
		for (String key : keySet) {
			System.out.println(key + ":" + map.get(key));
		}
	}
}
