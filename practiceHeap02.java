package PROGRAMMERS;

import java.util.Arrays;
import java.util.PriorityQueue;

//프로그래머스 코딩테스트 연습 / 힙 / 디스크 컨트롤러
public class practiceHeap02 {

	public int solution(int[][] jobs) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		int cnt = 0;
		int index = 0;
		int idx = 0;
		int answer = 0;
		while(cnt < jobs.length) {
			while(idx < jobs.length && jobs[idx][0] <= index) {
				queue.add(jobs[idx++]);
			}
			if(queue.isEmpty()) index = jobs[idx][0];
			else {
				int[] now = queue.poll();
				answer += (index - now[0]) + now[1];
				index += now[1];
				cnt++;
			}
		}
		return answer / jobs.length;
	}

}
