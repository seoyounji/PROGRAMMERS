package PROGRAMMERS;

//프로그래머스 코딩테스트 연습 / 스택&큐 / 주식가격 - 이중 for문 사용
public class practiceStackQueue04 {

	public int[] solution(int[] prices) {
		int N = prices.length;
		int[] answer = new int[N];
		for (int i = 0; i < N-1; i++) {
			answer[i] = 1;
		}
		outer:
		for (int i = 0; i < N-1; i++) {
			if(prices[i+1] < prices[i]) continue;
			boolean flag = false;
			for (int j = i+2; j < N; j++) {
				if(!flag && prices[j]>=prices[i]) answer[i]++;
				else flag = true;
				if(flag) {
					answer[i]++;
					continue outer;
				}
			}
		}
		return answer;
	}

}
