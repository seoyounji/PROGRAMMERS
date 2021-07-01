package PROGRAMMERS;

import java.util.Arrays;

//프로그래머스 코딩테스트 연습 / 정렬 / K번째수
public class practiceSort01 {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] order = commands[i];
			int[] tmp = new int[order[1]-order[0]+1];
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = array[order[0]-1+j];
			}
			Arrays.sort(tmp);
			answer[i] = tmp[order[2]-1];
		}
		return answer;
	}
}
