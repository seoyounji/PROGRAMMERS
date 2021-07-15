package PROGRAMMERS;

import java.util.Arrays;

//프로그래머스 코딩테스트 연습 / 탐욕법 / 단속카메라
public class practiceGreedy06 {

	public int solution(int[][] routes) {
		Arrays.sort(routes,(o1,o2) -> o1[1] - o2[1]);
		int min = Integer.MIN_VALUE;
		int answer = 0;
		
		for (int i = 0; i < routes.length; i++) {
			int[] now = routes[i];
			if(min < now[0]) {
				min = now[1];
				answer++;
			}
		}
		return answer;
	}

}
