package PROGRAMMERS;

import java.util.HashMap;

//프로그래머스 코딩테스트 연습 / 해시 / 위장
public class practiceHash03 {

	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			String t = clothes[i][1];
			if(map.get(t) == null) {
				map.put(t, 1);
			} else {
				int tmp = map.get(t);
				map.put(t, tmp+1);
			}
		}
		for(String now : map.keySet()) {
			int tmp = map.get(now);
			map.put(now, tmp+1);
		}
		int answer = 1;
		for(int i : map.values()) {
			answer *= i;
		}
		return answer-1;
	}

}
