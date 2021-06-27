package PROGRAMMERS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//프로그래머스 코딩테스트 연습 / 스택&큐 / 프린터
public class practiceStackQueue02 {

	public int solution(int[] priorities, int location) {
		Queue<int[]> queue = new LinkedList<>();
		ArrayList<Integer> order = new ArrayList<>();
		int[] present = new int[10];
		for (int i = 0; i < priorities.length; i++) {
			queue.offer(new int[] {i,priorities[i]});
			present[priorities[i]]++;
		}
		while(!queue.isEmpty()) {
			int size = queue.size();
			int max = 0;
			for (int i = 0; i < 10; i++) {
				if(present[i]>0) max = i;
			}
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				if(now[1] >= max) {
					order.add(now[0]);
					present[now[1]]--;
					for (int j = 0; j < 10; j++) {
						if(present[j]>0) max = j;
					}
				}
				else {
					queue.offer(now);
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < order.size(); i++) {
			if(order.get(i) == location) answer = i+1;
		}
		return answer;
	}

}
