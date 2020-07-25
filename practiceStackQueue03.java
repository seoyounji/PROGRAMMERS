package PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

//프로그래머스 코딩테스트 연습 / 스택&큐 / 다리를 지나는 트럭
public class practiceStackQueue03 {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<int[]> queue = new LinkedList<>();
		int Ntruck = truck_weights.length;
		queue.offer(new int[] {0,truck_weights[0],1});
		int answer = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			int sum = 0;
			int index = 0;
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				if(now[2] < bridge_length) {
					queue.offer(new int[] {now[0],now[1],now[2]+1});
					sum += now[1];
				}
				index = now[0];
			}
			answer++;
			if(index < Ntruck-1 && sum+truck_weights[index+1] <= weight) {
				queue.offer(new int[] {index+1,truck_weights[index+1],1});
			}
		}
		return answer;
	}

}
