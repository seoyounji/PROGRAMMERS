package PROGRAMMERS;

import java.util.Arrays;

//프로그래머스 코딩테스트 연습 / 정렬 / H-Index
public class practiceSort03 {

	public int solution(int[] citations) {
		Arrays.sort(citations);
		int N = citations.length;
		int answer = citations[N-1];
		outer:
		while(true) {
			for (int i = 0; i < N; i++) {
				if(citations[i] >= answer && N-i >= answer) break outer; 
			}
			answer--;
		}
		return answer;
	}
}
