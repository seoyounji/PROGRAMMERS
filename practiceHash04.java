package PROGRAMMERS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//프로그래머스 코딩테스트 연습 / 해시 / 베스트앨범
public class practiceHash04 {

public int[] solution(String[] genres, int[] plays) {
		
		HashMap<String, Integer> sum = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			String temp = genres[i];
			if(sum.get(temp) == null) {
				sum.put(temp, plays[i]);
			} else {
				int tmp = sum.get(temp);
				sum.put(temp, tmp + plays[i]);
			}
		}
		List<String> sumkey = new ArrayList<>(sum.keySet());
		sumkey.sort((o1, o2) -> sum.get(o2) - sum.get(o1));
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for (String genre : sumkey) {
			HashMap<Integer,Integer> tmp = new HashMap<>();
			for (int i = 0; i < genres.length; i++) {
				if(genres[i].equals(genre)) {
					tmp.put(i, plays[i]);
				}
			}
			List<Integer> keySet = new ArrayList<>(tmp.keySet());
			keySet.sort((o1, o2) -> tmp.get(o2) - tmp.get(o1));
			
			int index = 0;
			for(int i : keySet) {
				result.add(i);
				index++;
				if(keySet.size() == 1 && index == 1) break;
				if(index >= 2) break;
			}
		}
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

}
