package PROGRAMMERS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//프로그래머스 코딩테스트 연습 / 스택&큐 / 기능개발
public class practiceStackQueue01 {

	public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			queue.offer(new int[] {i,progresses[i]});
		}
		ArrayList<Integer> result = new ArrayList<>();

		while(!queue.isEmpty()) {
			int size = queue.size();
			int time = 0;
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				if(i==0 && now[1] >= 100) {
					time++;
					flag = true;
					continue;
				}
				else if(i!=0 && flag && now[1] >= 100) {
					time++;
					continue;
				}
				now[1] += speeds[now[0]];
				flag = false;
				queue.offer(new int[] {now[0],now[1]});
			}
			if(time!=0) result.add(time);
		}
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
        return answer;
    }

}
