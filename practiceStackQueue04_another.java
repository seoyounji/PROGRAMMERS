package PROGRAMMERS;

import java.util.Stack;

//프로그래머스 코딩테스트 연습 / 스택&큐 / 주식가격 - Stack 사용
public class practiceStackQueue04_another {

	public int[] solution(int[] prices) {
        Stack<Integer[]> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = prices.length - 2; i >= 0; i--) {
            int day = 0;

            while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                day += stack.pop()[1];
            }

            answer[i] = stack.push(new Integer[]{prices[i], day + 1})[1];
        }

        return answer;
    }

}
