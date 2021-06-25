package PROGRAMMERS;

import java.util.HashMap;

//프로그래머스 코딩테스트 연습 / 해시 / 완주하지 못한 선수
public class practiceHash01 {
	
	public String solution(String[] participant, String[] completion) {	
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
        	String now = participant[i];
			if(map.get(now) != null) {
				int tmp = map.get(now);
				map.put(now, tmp+1);
			}
			else {
				map.put(now, 1);
			}
		}
        for (int i = 0; i < completion.length; i++) {
			String now = completion[i];
			int tmp = map.get(now);
			map.put(now, tmp-1);
		}
        for(String i : map.keySet()) {
        	int n = map.get(i);
        	if(n==1) answer = i;
        }
        return answer;
    }
}