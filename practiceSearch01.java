package PROGRAMMERS;

import java.util.ArrayList;

//프로그래머스 코딩테스트 연습 / 완전탐색 / 모의고사
public class practiceSearch01 {

	public int[] solution(int[] answers) {
		int N = answers.length;
		int[] one = new int[((N/5)+1)*5];
		int[] two = new int[((N/8)+1)*8];
		int[] three = new int[((N/10)+1)*10];
		int oidx = 0;
		for (int i = 0; i <= N/5; i++) {
			one[oidx++] = 1;
			one[oidx++] = 2;
			one[oidx++] = 3;
			one[oidx++] = 4;
			one[oidx++] = 5;
		}
		int tidx = 0;
		for (int i = 0; i <= N/8; i++) {
			two[tidx++] = 2; 
			two[tidx++] = 1; 
			two[tidx++] = 2;
			two[tidx++] = 3;
			two[tidx++] = 2;
			two[tidx++] = 4;
			two[tidx++] = 2;
			two[tidx++] = 5;
		}
		int thidx = 0;
		for (int i = 0; i <= N/10; i++) {
			three[thidx++] = 3;
			three[thidx++] = 3;
			three[thidx++] = 1;
			three[thidx++] = 1;
			three[thidx++] = 2;
			three[thidx++] = 2;
			three[thidx++] = 4;
			three[thidx++] = 4;
			three[thidx++] = 5;
			three[thidx++] = 5;
		}
		int first = 0;
		int second = 0;
		int third = 0;
		for (int i = 0; i < N; i++) {
			int tmp = answers[i];
			if(one[i]==tmp) first++;
			if(two[i]==tmp) second++;
			if(three[i]==tmp) third++;
		}
		int[] tmp = {first,second,third};
		int max = 0;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, tmp[i]);
		}
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if(tmp[i]>=max) temp.add(i+1);
		}
		int[] answer = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			answer[i] = temp.get(i);
		}
		return answer;
	}

}
