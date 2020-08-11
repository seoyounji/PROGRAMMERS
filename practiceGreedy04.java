package PROGRAMMERS;

import java.util.Arrays;

//프로그래머스 코딩테스트 연습 / 탐욕법 / 구명보트
public class practiceGreedy04 {

	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int length = people.length;
		int answer = 0;
		int first = 0;
		int second = length-1;
		
		while(true) {
			if(first > second) break;
			if(people[first] > limit/2) {
				answer += (second-first+1);
				break;
			}
			if(people[first] + people[second] <= limit) {
				first++;
				second--;
				answer++;
			} else {
				second--;
				answer++;
			}
		}
		return answer;
	}

}
