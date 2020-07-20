package PROGRAMMERS;

import java.util.HashMap;

//프로그래머스 코딩테스트 연습 / 해시 / 전화번호 목록
public class practiceHash02 {

	public boolean solution(String[] phone_book) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], i);
		}
		boolean answer = true;
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 1; j < phone_book[i].length(); j++) {
				if(map.containsKey(phone_book[i].substring(0, j))) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}

}
